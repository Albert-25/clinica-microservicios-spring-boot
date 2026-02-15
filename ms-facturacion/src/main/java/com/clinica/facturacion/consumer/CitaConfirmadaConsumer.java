package com.clinica.facturacion.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.clinica.facturacion.config.RabbitMQConfig;
import com.clinica.facturacion.event.CitaConfirmadaEvent;
import com.clinica.facturacion.service.FacturacionService;

@Component
public class CitaConfirmadaConsumer {
	private final FacturacionService facturacionService;

	public CitaConfirmadaConsumer(FacturacionService facturacionService) {
		this.facturacionService = facturacionService;
	}

	@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
	public void procesarCitaConfirmada(CitaConfirmadaEvent evento) {
		facturacionService.crearFactura(evento.getCitaId(), evento.getPacienteId());
	}
}
