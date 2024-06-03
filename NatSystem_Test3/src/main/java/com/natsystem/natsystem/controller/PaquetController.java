package com.natsystem.natsystem.controller;

import com.natsystem.natsystem.dto.CarteDTO;
import com.natsystem.natsystem.service.PaquetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PaquetController {

    @Autowired
    PaquetService paquetService;

    @GetMapping("/paquet")
    public ModelAndView voirPaquet(Model model){
        ModelAndView mav = new ModelAndView("paquet");
        List<CarteDTO> paquet = paquetService.listerCartes();
        mav.addObject("paquetList", paquet);
        return mav;
    }
}
