package com.unifor.web.projetoodontologia.repositories;

import com.unifor.web.projetoodontologia.entities.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends MongoRepository<Professor, String> {
}
