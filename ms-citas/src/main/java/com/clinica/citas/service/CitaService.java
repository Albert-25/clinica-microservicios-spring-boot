package com.clinica.citas.service;

import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.clinica.citas.client.PacienteClient;
import com.clinica.citas.config.RabbitMQConfig;
import com.clinica.citas.entity.Cita;
import com.clinica.citas.event.CitaConfirmadaEvent;
import com.clinica.citas.repository.CitaRepository;

@Service
public class CitaService {
	private final CitaRepository citaRepository;
	private final PacienteClient pacienteClient;
	private final RabbitTemplate rabbitTemplate;

	public CitaService(CitaRepository citaRepository, PacienteClient pacienteClient, RabbitTemplate rabbitTemplate) {
		this.citaRepository = citaRepository;
		this.pacienteClient = pacienteClient;
		this.rabbitTemplate = rabbitTemplate;
	}

	public Cita crearCita(Cita cita) {
		PacienteClient.PacienteResponse paciente = pacienteClient.obtenerPaciente(cita.getPacienteId());

		if (paciente == null || paciente.id == null) {
			throw new RuntimeException("Paciente no encontrado: " + cita.getPacienteId());
		}

		Cita citaCreada = citaRepository.save(cita);

		CitaConfirmadaEvent evento = new CitaConfirmadaEvent(
				citaCreada.getId(),
				citaCreada.getPacienteId(),
				citaCreada.getFecha(),
				citaCreada.getDoctor()
		);

		rabbitTemplate.convertAndSend(
				RabbitMQConfig.EXCHANGE_NAME,
				RabbitMQConfig.ROUTING_KEY,
				evento
		);

		return citaCreada;
	}

	public Optional<Cita> obtenerCita(Long id) {
		return citaRepository.findById(id);
	}
}
