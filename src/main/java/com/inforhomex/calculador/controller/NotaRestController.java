package com.inforhomex.calculador.controller;

import com.inforhomex.calculador.entity.Nota;
import com.inforhomex.calculador.model.MNota;
import com.inforhomex.calculador.service.NotaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


@CrossOrigin("*")
@RestController
@RequestMapping("/curso")
public class NotaRestController{

    private static final Logger LOG = LoggerFactory.getLogger(NotaRestController.class); 

    
    @Autowired
    private NotaServiceImpl notaServiceImpl;


    //http://localhost:8090/curso/notas
    @GetMapping("/notas")
    public List<MNota> notas(){
        LOG.info("Has entrado a http://localhost:8090/curso/notas");
        return notaServiceImpl.findNotasAll();
    }
    
    //http://localhost:8090/curso/notas/1
    @GetMapping("/notas/{id}")
    public ResponseEntity<?> nota(@PathVariable Long id){
        LOG.info("Has entrado a http://localhost:8090/curso/notas/"+id);
        
        MNota mnota = null;
        Map<String,Object> response = new HashMap<>();

        try {
            mnota = notaServiceImpl.findNotaById(id);
            response.put("mnota",mnota);
            response.put("mensaje","Obtenido exitosamente: "+mnota);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(mnota == null) {
            response.put("mensaje", "La nota con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

    //http://localhost:8090/curso/notas/create
    @PostMapping("/notas/create")
    public ResponseEntity<?> crearNota(@RequestBody Nota nota){
        MNota mnota = null;
        Map<String,Object> response = new HashMap<>();
        try{
            mnota = notaServiceImpl.crearNota(nota);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }

    


}
