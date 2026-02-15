package com.clinica.citas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-pacientes")
public interface PacienteClient {
	@GetMapping("/pacientes/{id}")
	PacienteResponse obtenerPaciente(@PathVariable("id") Long id);

	class PacienteResponse {
		public Long id;
		public String nombre;
		public String email;
		public String telefono;
	}
}
