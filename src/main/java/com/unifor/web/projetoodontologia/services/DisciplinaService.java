package com.unifor.web.projetoodontologia.services;

import com.unifor.web.projetoodontologia.entities.Disciplina;
import com.unifor.web.projetoodontologia.repositories.DisciplinaRepository;
import com.unifor.web.projetoodontologia.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisciplinaService{
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina findById(String id) {
        Optional<Disciplina> obj = disciplinaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object with id = " + id + " not found."));
    }

    public Disciplina insert(Disciplina obj) {
        return disciplinaRepository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        disciplinaRepository.deleteById(id);
    }

    public Disciplina update(Disciplina obj) {
        Disciplina newObj = findById(obj.getId());
        updateData(newObj, obj);
        return disciplinaRepository.save(newObj);
    }

    private void updateData(Disciplina newObj, Disciplina obj) {
        newObj.setNome(obj.getNome());
    }
}
