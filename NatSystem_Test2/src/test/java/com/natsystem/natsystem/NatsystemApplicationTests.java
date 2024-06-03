package com.natsystem.natsystem;

import com.natsystem.natsystem.dto.CarteDTO;
import com.natsystem.natsystem.enums.CouleursCarte;
import com.natsystem.natsystem.repository.IPaquetRepository;
import com.natsystem.natsystem.service.PaquetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NatsystemApplicationTests {

    @Autowired
    PaquetService paquetService;

    @Autowired
    IPaquetRepository paquetRepository;

    @Test
    void creerUnePile(){

        List<CarteDTO> pileTesteuse = new ArrayList<CarteDTO>();
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "1"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "2"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "3"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "4"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "5"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "6"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "7"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "8"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "9"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "10"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "VALET"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "DAME"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "ROI"));
        pileTesteuse.add(new CarteDTO(CouleursCarte.COEUR, "AS"));

        List<CarteDTO> pileTest = paquetService.creerPileCouleur(CouleursCarte.COEUR);

        assertEquals(pileTest.size(), pileTesteuse.size());


    }

    @Test
    void creerUnPaquetEtSauvegarder() {
        // Suppression du paquet en base pour le test
        paquetService.supprimerPaquet();


        List<CarteDTO> paquetTesteur = paquetService.creerPaquet();
        paquetService.sauvegarderPaquetEnBDD(paquetTesteur);

        List<CarteDTO> paquetTest = paquetService.listerCartes();

        assertEquals(paquetTesteur.size(), paquetTest.size());
    }

}
