package com.unifor.web.projetoodontologia.resources;

import com.unifor.web.projetoodontologia.entities.Disciplina;
import com.unifor.web.projetoodontologia.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaResource {

    @Autowired
    private DisciplinaService disciplinaService;

//    @GetMapping
//    public ResponseEntity<List<Disciplina>> findAll() {
//        List<Disciplina> list = disciplinaService.findAll();
//        return ResponseEntity.ok().body(list);
//        //TODO criar findAll de Disciplina
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable String id) {
        Disciplina obj = disciplinaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Disciplina> insert(@RequestBody Disciplina obj) {
        obj = disciplinaService.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        disciplinaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Disciplina> update(@PathVariable String id, @RequestBody Disciplina obj) {
        obj.setId(id);
        obj = disciplinaService.update(obj);
        return ResponseEntity.ok().body(obj);
    }
}
