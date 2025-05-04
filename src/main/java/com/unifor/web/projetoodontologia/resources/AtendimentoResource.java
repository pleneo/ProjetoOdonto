package com.unifor.web.projetoodontologia.resources;

import com.unifor.web.projetoodontologia.entities.Atendimento;
import com.unifor.web.projetoodontologia.services.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/atendimentos")
public class AtendimentoResource {

    @Autowired
    private AtendimentoService atendimentoService;

//    @GetMapping
//    public ResponseEntity<List<Atendimento>> findAll() {
//        // TODO: Implement findAll in AtendimentoService
//        List<Atendimento> list = atendimentoService.findAll();
//        return ResponseEntity.ok().body(list);
//        //TODO findAll de Atendimento
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Atendimento> findById(@PathVariable String id) {
        Atendimento obj = atendimentoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Atendimento> insert(@RequestBody Atendimento obj) {
        obj = atendimentoService.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        atendimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Atendimento> update(@PathVariable String id, @RequestBody Atendimento obj) {
//        obj.setId(id);
//        obj = atendimentoService.update(obj);
//        return ResponseEntity.ok().body(obj);
//        //TODO: Implement update in AtendimentoService
//    }
}
