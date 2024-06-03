package com.natsystem.natsystem.service;

import com.natsystem.natsystem.dto.CarteDTO;
import com.natsystem.natsystem.entity.Carte;
import com.natsystem.natsystem.enums.CouleursCarte;
import com.natsystem.natsystem.enums.TetesCarte;
import com.natsystem.natsystem.repository.IPaquetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaquetService {

    private static final Logger logger = LoggerFactory.getLogger(PaquetService.class);
    @Autowired
    IPaquetRepository paquetRepository;

    public List<CarteDTO> creerPileCouleur(CouleursCarte couleur){
        List<CarteDTO> pile = new ArrayList<>();

        // Creation de la pile numéroté de 1 à 10
        for (int i = 1; i < 10; i++){
            CarteDTO carte = new CarteDTO();
            carte.setValeur(Integer.toString(i+1));
            carte.setCouleur(couleur);
            carte.setImageUrl(couleur +"_"+ Integer.toString(i+1)+".jpg");
            pile.add(carte);
        }

        // Création des têtes
        for (TetesCarte tete : TetesCarte.values()) {
            CarteDTO carte = new CarteDTO();
            carte.setValeur(tete.toString());
            carte.setCouleur(couleur);
            carte.setImageUrl(couleur +"_"+ tete.toString()+".jpg");
            pile.add(carte);
        }

        return pile;
    }

    public List<CarteDTO> creerPaquet(){
        logger.info("Création du jeu de carte ...");
        List<CarteDTO> paquet = new ArrayList<CarteDTO>() ;
        paquet.addAll(creerPileCouleur(CouleursCarte.CARREAU));
        paquet.addAll(creerPileCouleur(CouleursCarte.COEUR));
        paquet.addAll(creerPileCouleur(CouleursCarte.PIQUE));
        paquet.addAll(creerPileCouleur(CouleursCarte.TREFLE));

        return paquet;
    }

    public void listerCartesVersConsole(List<CarteDTO> paquet){
        logger.info("Affichage du jeu de carte:");
        paquet.forEach(carte -> logger.info("{} de {}", carte.getValeur(), carte.getCouleur()));
    }

    public void listerCartesDeBDDversConsole(){
        logger.info("Affichage du jeu de carte:");
        List<Carte> paquet = Streamable.of(paquetRepository.findAll()).toList();
        paquet.forEach(carte -> logger.info("{} de {}", carte.getValeur(), carte.getCouleur()));
    }

    public List<CarteDTO> listerCartes(){
        List<Carte> paquet = Streamable.of(paquetRepository.findAll()).toList();
        List<CarteDTO> paquetDTO = paquet.stream().map(carte -> {
                    CarteDTO carteDTO = new CarteDTO();
                    carteDTO.setCouleur(CouleursCarte.valueOf(carte.getCouleur()));
                    carteDTO.setValeur(carte.getValeur());
                    carteDTO.setImageUrl(carte.getImageUrl());
                    return carteDTO;
                }).collect(Collectors.toList());
        /*List<CarteDTO> result = paquetRepository.findAll().stream().map(carte -> {
            CarteDTO carteDTO = new CarteDTO();
            carteDTO.setCouleur(CouleursCarte.valueOf(carte.getCouleur()));
            carteDTO.setValeur(carte.getValeur());
            carteDTO.setImageUrl(carte.getImageUrl());
            return carteDTO;
        }).collect(Collectors.toList());*/

        return paquetDTO;
    }

    public void sauvegarderPaquetEnBDD(List<CarteDTO> paquet){
        logger.info("Sauvegarde en BDD ...");
        List<Carte> paquetBDD = paquet.stream().map(carteDTO -> {
            Carte carteEntity = new Carte();
            carteEntity.setCouleur(carteDTO.getCouleur().toString());
            carteEntity.setValeur(carteDTO.getValeur());
            carteEntity.setImageUrl(carteDTO.getImageUrl());
            return carteEntity;
        }).collect(Collectors.toList());

        paquetRepository.saveAll(paquetBDD);
    }

    public void supprimerPaquet(){
        paquetRepository.deleteAll();
    }
}
