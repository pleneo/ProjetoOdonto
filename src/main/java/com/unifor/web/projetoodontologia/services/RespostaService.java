package com.unifor.web.projetoodontologia.services;

import com.unifor.web.projetoodontologia.entities.Resposta;
import com.unifor.web.projetoodontologia.repositories.RespostaRepository;
import com.unifor.web.projetoodontologia.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    public Resposta findById(String id) {
        Optional<Resposta> obj = respostaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object with id = " + id + " not found."));
    }

    public Resposta insert(Resposta obj) {
        return respostaRepository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        respostaRepository.deleteById(id);
    }

//    public Resposta update(Resposta obj) {
//        Resposta newObj = findById(obj.getId());
//        updateData(newObj, obj);
//        return respostaRepository.save(newObj);
//    }
//
//    private void updateData(Resposta newObj, Resposta obj) {
//        newObj.setNome(obj.getNome());
//        newObj.setEspecializacao(obj.getEspecializacao());
//    }

    //TODO update respostaService
}