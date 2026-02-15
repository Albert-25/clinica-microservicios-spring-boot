package com.clinica.facturacion.event;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CitaConfirmadaEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long citaId;
	private Long pacienteId;
	private LocalDateTime fecha;
	private String doctor;

	public CitaConfirmadaEvent() {
	}

	public CitaConfirmadaEvent(Long citaId, Long pacienteId, LocalDateTime fecha, String doctor) {
		this.citaId = citaId;
		this.pacienteId = pacienteId;
		this.fecha = fecha;
		this.doctor = doctor;
	}

	public Long getCitaId() {
		return citaId;
	}

	public void setCitaId(Long citaId) {
		this.citaId = citaId;
	}

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
}
