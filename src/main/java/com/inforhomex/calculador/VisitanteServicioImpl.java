package com.inforhomex.calculador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("usuarioService")
public class VisitanteServicioImpl implements VisitanteServicio {

        @Autowired
        private VisitanteRepository visitanteRepository;

        @Override
        public List<Visitante> getAllVisitantes() {
                return visitanteRepository.findAll();
        }

}