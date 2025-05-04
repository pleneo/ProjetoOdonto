package com.unifor.web.projetoodontologia.resources;

import com.unifor.web.projetoodontologia.entities.Paciente;
import com.unifor.web.projetoodontologia.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResource {

    @Autowired
    private PacienteService pacienteService;

//    @GetMapping
//    public ResponseEntity<List<Paciente>> findAll() {
//        List<Paciente> list = pacienteService.findAll();
//        return ResponseEntity.ok().body(list);
//        //TODO criar findAll de Paciente
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable String id) {
        Paciente obj = pacienteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Paciente> insert(@RequestBody Paciente obj) {
        obj = pacienteService.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Paciente> update(@PathVariable String id, @RequestBody Paciente obj) {
        obj.setId(id);
        obj = pacienteService.update(obj);
        return ResponseEntity.ok().body(obj);
    }
}