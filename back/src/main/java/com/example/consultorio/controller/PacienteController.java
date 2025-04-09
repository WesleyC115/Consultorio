package com.example.consultorio.controller;

import com.example.consultorio.entity.Paciente;
import com.example.consultorio.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    // GET: listar todos os pacientes
    @GetMapping
    public List<Paciente> getAll() {
        return pacienteRepository.findAll();
    }

    // GET: buscar paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: criar um novo paciente
    @PostMapping
    public Paciente create(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // DELETE: remover paciente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
