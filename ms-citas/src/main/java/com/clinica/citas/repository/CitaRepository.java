package com.clinica.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.citas.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
}
