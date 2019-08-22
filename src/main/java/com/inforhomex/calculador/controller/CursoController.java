package com.inforhomex.calculador.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@CrossOrigin("*")
@RequestMapping("/calculador")
public class CursoController{

    private static final Logger LOG = LoggerFactory.getLogger(CursoController.class); 

    @Value("${programador.aplicacion}")
    private String nombre;

    //http://localhost:8090/calculador/index
    @GetMapping("/index")
    public String index(Model model){
        LOG.info("Has entrado a http://localhost:8090/calculador/index");
        model.addAttribute("nombre", nombre);
        return "index";
    }

}