package com.clinica.citas.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.citas.entity.Cita;
import com.clinica.citas.service.CitaService;

@RestController
@RequestMapping("/citas")
public class CitaController {
	private final CitaService citaService;

	public CitaController(CitaService citaService) {
		this.citaService = citaService;
	}

	@PostMapping
	public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
		Cita creada = citaService.crearCita(cita);
		return ResponseEntity.status(HttpStatus.CREATED).body(creada);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cita> obtenerCita(@PathVariable Long id) {
		Optional<Cita> cita = citaService.obtenerCita(id);
		return cita.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
