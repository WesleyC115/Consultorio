package com.example.consultorio.repository;

import com.example.consultorio.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
