package com.inforhomex.calculador.processor;

import com.inforhomex.calculador.model.Modelo;
import org.springframework.batch.item.ItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ModeloItemProcessor implements ItemProcessor<Modelo, Modelo>{


    private static final Logger LOG = LoggerFactory.getLogger(CursoRestController.class); 


    @Override
    public Modelo process(Modelo modelo) throws Exception {
        LOG.info("Se esta procesando: "+modelo);
        return modelo;
    }
    
}