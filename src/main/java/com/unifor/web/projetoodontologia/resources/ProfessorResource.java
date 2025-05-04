package com.unifor.web.projetoodontologia.resources;

import com.unifor.web.projetoodontologia.entities.Professor;
import com.unifor.web.projetoodontologia.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {

    @Autowired
    private ProfessorService professorService;

//    @GetMapping
//    public ResponseEntity<List<Professor>> findAll() {
//        List<Professor> list = professorService.findAll();
//        return ResponseEntity.ok().body(list);
//
//        //TODO criar findAll de Professor
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Professor> findById(@PathVariable String id) {
        Professor obj = professorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Professor> insert(@RequestBody Professor obj) {
        obj = professorService.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        professorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Professor> update(@PathVariable String id, @RequestBody Professor obj) {
        obj.setId(id);
        obj = professorService.update(obj);
        return ResponseEntity.ok().body(obj);
    }
}
