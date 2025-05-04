package com.unifor.web.projetoodontologia.services;

import com.unifor.web.projetoodontologia.entities.Aluno;
import com.unifor.web.projetoodontologia.repositories.AlunoRepository;
import com.unifor.web.projetoodontologia.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoService {
    //TODO tratamento de erros de buscas melhor feito.
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno findById(String id) {
        Optional<Aluno> obj = alunoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object with id = " + id + " not found."));
    }

    public Aluno insert(Aluno obj) {
        return alunoRepository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        alunoRepository.deleteById(id);
    }

    public Aluno update(Aluno obj) {
        Aluno newObj = findById(obj.getId());
        updateData(newObj, obj);
        return alunoRepository.save(newObj);
    }

    private void updateData(Aluno newObj, Aluno obj) {
        newObj.setNome(obj.getNome());
    }

}
