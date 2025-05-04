package com.unifor.web.projetoodontologia.resources;

import com.unifor.web.projetoodontologia.entities.Resposta;
import com.unifor.web.projetoodontologia.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/respostas")
@CrossOrigin(origins = "http://localhost:63342")
public class RespostaResource {

    @Autowired
    private RespostaService respostaService;

//    @GetMapping
//    public ResponseEntity<List<Resposta>> findAll() {
//        List<Resposta> list = respostaService.findAll();
//        return ResponseEntity.ok().body(list);
//        //TODO criar findAll de Resposta
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Resposta> findById(@PathVariable String id) {
        Resposta obj = respostaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Resposta> insert(@RequestBody Resposta obj) {
        obj = respostaService.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        respostaService.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Resposta> update(@PathVariable String id, @RequestBody Resposta obj) {
//        obj.setId(id);
//        obj = respostaService.update(obj);
//        return ResponseEntity.ok().body(obj);
//    }
    //TODO: Implement update in RespostaService
}
