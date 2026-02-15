package com.clinica.pacientes.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clinica.pacientes.entity.Paciente;
import com.clinica.pacientes.repository.PacienteRepository;

@Service
public class PacienteService {
	private final PacienteRepository pacienteRepository;

	public PacienteService(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}

	public Paciente crearPaciente(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	public Optional<Paciente> obtenerPaciente(Long id) {
		return pacienteRepository.findById(id);
	}
}
