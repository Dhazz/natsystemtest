package com.natsystem1;

import com.natsystem1.service.PaquetService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PaquetService paquetService = new PaquetService();
        List paquet;
        paquet = paquetService.creerPaquet();
        paquetService.listerCartesConsole(paquet);
    }
}