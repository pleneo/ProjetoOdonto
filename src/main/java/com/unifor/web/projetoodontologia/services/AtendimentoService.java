package com.unifor.web.projetoodontologia.services;

import com.unifor.web.projetoodontologia.entities.Atendimento;
import com.unifor.web.projetoodontologia.repositories.AtendimentoRepository;
import com.unifor.web.projetoodontologia.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public Atendimento findById(String id) {
        Optional<Atendimento> obj = atendimentoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object with id = " + id + " not found."));
    }

    public Atendimento insert(Atendimento obj) {
        return atendimentoRepository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        atendimentoRepository.deleteById(id);
    }

//    public Atendimento update(Atendimento obj) {
//        //TODO atendimento update
//    }

    private void updateData(Atendimento newObj, Atendimento obj) {
        //TODO atendimento update
    }
}
