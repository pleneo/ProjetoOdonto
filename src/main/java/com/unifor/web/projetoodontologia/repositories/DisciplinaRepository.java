package com.unifor.web.projetoodontologia.repositories;

import com.unifor.web.projetoodontologia.entities.Disciplina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends MongoRepository<Disciplina, String> {
}
