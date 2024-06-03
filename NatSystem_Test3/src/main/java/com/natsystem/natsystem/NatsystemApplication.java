package com.natsystem.natsystem;

import com.natsystem.natsystem.dto.CarteDTO;
import com.natsystem.natsystem.service.PaquetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class NatsystemApplication implements CommandLineRunner {


    public static void main(String[] args) { SpringApplication.run(NatsystemApplication.class, args);
    }

    @Autowired
    PaquetService paquetService;


    @Override
    public void run(String... args) {

        List<CarteDTO> paquetTesteur = paquetService.creerPaquet();
        paquetService.sauvegarderPaquetEnBDD(paquetTesteur);
        paquetService.listerCartesDeBDDversConsole();

    }

}
