package com.inforhomex.calculador;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.MongoClient;


@Configuration
@ComponentScan(basePackages = "com.inforhomex.calculador")
@EnableMongoRepositories({ "com.inforhomex.calculador" })
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

    @Bean(name="mensajesServicioBean")
    public MensajesServicioImpl mensajesServicioImpl(){
        return new MensajesServicioImpl();
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        //UserCredentials userCredentials = new UserCredentials("", "");
        return new SimpleMongoDbFactory(mongoClient,"mensajes");
    }
 
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }

    @Bean(name="adminABean")
    public Administrador adminA(){
        return new AdministradorImplA();
    }

    @Bean(name="adminBBean")
    public Administrador adminB(){
        return new AdministradorImplB();
    }

   
}