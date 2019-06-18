package com.inforhomex.calculador;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig{
    
    @Bean(name="celsiusBean")
    public Celsius celsius(){
        return new CelsiusImpl();
    }

    @Bean(name="puntoBean")
    public Punto punto(){
        return new Punto();
    }

    @Bean(name="camionetaBean")
    public Vehiculo getCamioneta(){
        return new Camioneta();
    }

    @Bean(name="motocicletaBean")
    public Vehiculo getMotocicleta(){
        return new Motocicleta();
    }

    @Bean(name="bicicletaBean")
    public Vehiculo getBicicleta(){
        return new Bicicleta();
    }
}