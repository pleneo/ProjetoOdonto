package com.unifor.web.projetoodontologia.services;

import com.unifor.web.projetoodontologia.entities.Paciente;
import com.unifor.web.projetoodontologia.repositories.PacienteRepository;
import com.unifor.web.projetoodontologia.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente findById(String id) {
        Optional<Paciente> obj = pacienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object with id = " + id + " not found."));
    }

    public Paciente insert(Paciente obj) {
        return pacienteRepository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        pacienteRepository.deleteById(id);
    }

    public Paciente update(Paciente obj) {
        Paciente newObj = findById(obj.getId());
        updateData(newObj, obj);
        return pacienteRepository.save(newObj);
    }

    private void updateData(Paciente newObj, Paciente obj) {
        newObj.setNome(obj.getNome());
        newObj.setIdade(obj.getIdade());
    }
}
