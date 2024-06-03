package com.natsystem1.service;

import com.natsystem1.dto.Carte;
import com.natsystem1.enums.TetesCarte;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.natsystem1.enums.CouleursCarte;

import java.util.ArrayList;
import java.util.List;

public class PaquetService {
    protected static final Logger logger = LogManager.getLogger();
    List<Carte> creerPileCouleur(CouleursCarte couleur){
        List<Carte> pile = new ArrayList<>();

        // Creation de la pile numéroté de 1 à 10
        for (int i = 1; i < 10; i++){
            Carte carte = new Carte();
            carte.setValeur(Integer.toString(i+1));
            carte.setCouleur(couleur);
            pile.add(carte);
        }

        // Création des têtes
        for (TetesCarte tete : TetesCarte.values()) {
            Carte carte = new Carte();
            carte.setValeur(tete.toString());
            carte.setCouleur(couleur);
            pile.add(carte);
        }

        return pile;
    }

    public List<Carte> creerPaquet(){
        logger.debug("Création du jeu de carte ...");
        List<Carte> paquet = new ArrayList<Carte>() ;
        paquet.addAll(creerPileCouleur(CouleursCarte.CARREAU));
        paquet.addAll(creerPileCouleur(CouleursCarte.COEUR));
        paquet.addAll(creerPileCouleur(CouleursCarte.PIQUE));
        paquet.addAll(creerPileCouleur(CouleursCarte.TREFLE));

        return paquet;
    }

    public void listerCartesConsole(List<Carte> paquet){
        logger.debug("Affichage du jeu de carte:");
        paquet.forEach(carte -> logger.info("{} de {}", carte.getValeur(), carte.getCouleur()));
    }
}
