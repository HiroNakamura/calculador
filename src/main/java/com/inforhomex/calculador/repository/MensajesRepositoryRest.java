package com.inforhomex.calculador.repository;

//import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("mensajesRepository")
public interface MensajesRepositoryRest extends MongoRepository<Mensajes, String> {
    
}