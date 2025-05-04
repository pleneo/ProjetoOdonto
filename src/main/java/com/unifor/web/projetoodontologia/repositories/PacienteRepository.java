package com.unifor.web.projetoodontologia.repositories;

import com.unifor.web.projetoodontologia.entities.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {
}
