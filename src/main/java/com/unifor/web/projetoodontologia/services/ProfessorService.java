package com.unifor.web.projetoodontologia.services;

import com.unifor.web.projetoodontologia.entities.Professor;
import com.unifor.web.projetoodontologia.repositories.ProfessorRepository;
import com.unifor.web.projetoodontologia.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor findById(String id) {
        Optional<Professor> obj = professorRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object with id = " + id + " not found."));
    }

    public Professor insert(Professor obj) {
        return professorRepository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        professorRepository.deleteById(id);
    }

    public Professor update(Professor obj) {
        Professor newObj = findById(obj.getId());
        updateData(newObj, obj);
        return professorRepository.save(newObj);
    }

    private void updateData(Professor newObj, Professor obj) {
        newObj.setNome(obj.getNome());
        newObj.setEspecializacao(obj.getEspecializacao());
    }
}