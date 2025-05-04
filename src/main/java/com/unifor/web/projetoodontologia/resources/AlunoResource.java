package com.unifor.web.projetoodontologia.resources;

import com.unifor.web.projetoodontologia.entities.Aluno;
import com.unifor.web.projetoodontologia.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

//    @GetMapping
//    public ResponseEntity<List<Aluno>> findAll() {
//        List<Aluno> list = alunoService.findAll();
//        return ResponseEntity.ok().body(list);
//        //TODO criar findAll de Aluno
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable String id) {
        Aluno obj = alunoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Aluno> insert(@RequestBody Aluno obj) {
        obj = alunoService.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> update(@PathVariable String id, @RequestBody Aluno obj) {
        obj.setId(id);
        obj = alunoService.update(obj);
        return ResponseEntity.ok().body(obj);
    }
}
