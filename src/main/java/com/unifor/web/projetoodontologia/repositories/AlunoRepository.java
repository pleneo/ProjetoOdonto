package com.unifor.web.projetoodontologia.repositories;

import com.unifor.web.projetoodontologia.entities.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
