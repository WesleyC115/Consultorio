package com.example.consultorio.controller;

import com.example.consultorio.entity.Consulta;
import com.example.consultorio.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    // GET: listar todas as consultas
    @GetMapping
    public List<Consulta> getAll() {
        return consultaRepository.findAll();
    }

    // GET: buscar consulta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getById(@PathVariable Long id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        return consulta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: criar nova consulta
    @PostMapping
    public Consulta create(@RequestBody Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    // DELETE: remover consulta por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}