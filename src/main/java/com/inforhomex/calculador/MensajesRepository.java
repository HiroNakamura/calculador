package com.inforhomex.calculador;

//import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository("mensajesRepository")
public interface MensajesRepository extends MongoRepository<Mensajes, String> {
    
}