package com.unifor.web.projetoodontologia.repositories;

import com.unifor.web.projetoodontologia.entities.Atendimento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends MongoRepository<Atendimento, String> {
}
