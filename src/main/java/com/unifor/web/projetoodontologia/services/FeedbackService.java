package com.unifor.web.projetoodontologia.services;

import com.unifor.web.projetoodontologia.entities.Feedback;
import com.unifor.web.projetoodontologia.repositories.FeedbackRepository;
import com.unifor.web.projetoodontologia.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback findById(String id) {
        Optional<Feedback> obj = feedbackRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object with id = " + id + " not found."));
    }

    public Feedback insert(Feedback obj) {
        return feedbackRepository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        feedbackRepository.deleteById(id);
    }

    public Feedback update(Feedback obj) {
        Feedback newObj = findById(obj.getId());
        updateData(newObj, obj);
        return feedbackRepository.save(newObj);
    }

    private void updateData(Feedback newObj, Feedback obj) {
        newObj.setDescricao(obj.getDescricao());
        //TODO revisar update do feedback pois fiz na pressa.
    }
}
