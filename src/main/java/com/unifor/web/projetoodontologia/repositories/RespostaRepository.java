package com.unifor.web.projetoodontologia.repositories;

import com.unifor.web.projetoodontologia.entities.Resposta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends MongoRepository<Resposta, String> {
}
