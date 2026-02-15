package com.clinica.pacientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.pacientes.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
