package com.clinica.pacientes.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.pacientes.entity.Paciente;
import com.clinica.pacientes.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	private final PacienteService pacienteService;

	public PacienteController(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	@PostMapping
	public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente) {
		Paciente creado = pacienteService.crearPaciente(paciente);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Paciente> obtenerPaciente(@PathVariable Long id) {
		Optional<Paciente> paciente = pacienteService.obtenerPaciente(id);
		return paciente.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
