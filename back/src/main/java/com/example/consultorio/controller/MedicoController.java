package com.example.consultorio.controller;

import com.example.consultorio.entity.Medico;
import com.example.consultorio.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    // GET: listar todos os médicos
    @GetMapping
    public List<Medico> getAll() {
        return medicoRepository.findAll();
    }

    // GET: buscar médico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Medico> getById(@PathVariable Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return medico.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: criar novo médico
    @PostMapping
    public Medico create(@RequestBody Medico medico) {
        return medicoRepository.save(medico);
    }

    // DELETE: remover médico por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}