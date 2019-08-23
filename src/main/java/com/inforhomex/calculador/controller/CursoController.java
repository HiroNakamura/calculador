package com.inforhomex.calculador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import com.inforhomex.calculador.service.ISaludoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("cursoController")
@CrossOrigin("*")
@RequestMapping("/calculador")
public class CursoController{

    private static final Logger LOG = LoggerFactory.getLogger(CursoController.class); 

    @Value("${programador.aplicacion}")
    private String nombre;

    @Value("#{new java.text.SimpleDateFormat('${programador.fechaFormat}').parse('${programador.fecha}')}")
    private Date fecha;

    @Autowired
    @Qualifier("saludoServiceImpl")
    private ISaludoService saludoService;

    public String aplicacion(String nombre){
        LOG.info("Esto se ejecutara en el main...");
        return saludoService.decirHola(nombre);
    }

    //http://localhost:8090/calculador/index
    @GetMapping("/index")
    public String index(Model model){
        LOG.info("Has entrado a http://localhost:8090/calculador/index");
        model.addAttribute("nombre", nombre);
        model.addAttribute("fecha", fecha);
        return "index";
    }

}