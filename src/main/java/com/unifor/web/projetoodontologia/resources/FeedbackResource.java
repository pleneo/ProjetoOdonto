package com.unifor.web.projetoodontologia.resources;

import com.unifor.web.projetoodontologia.entities.Feedback;
import com.unifor.web.projetoodontologia.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/feedbacks")
public class FeedbackResource {

    @Autowired
    private FeedbackService feedbackService;

//    @GetMapping
//    public ResponseEntity<List<Feedback>> findAll() {
//        List<Feedback> list = feedbackService.findAll();
//        return ResponseEntity.ok().body(list);
//
//        //TODO criar findAll de Feedback
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Feedback> findById(@PathVariable String id) {
        Feedback obj = feedbackService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Feedback> insert(@RequestBody Feedback obj) {
        obj = feedbackService.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        feedbackService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Feedback> update(@PathVariable String id, @RequestBody Feedback obj) {
        obj.setId(id);
        obj = feedbackService.update(obj);
        return ResponseEntity.ok().body(obj);
    }
}
