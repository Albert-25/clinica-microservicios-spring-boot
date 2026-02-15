package com.clinica.citas.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	public static final String EXCHANGE_NAME = "clinica.exchange";
	public static final String QUEUE_NAME = "cita-confirmada.queue";
	public static final String ROUTING_KEY = "cita.confirmada";

	@Bean
	public DirectExchange clinicaExchange() {
		return new DirectExchange(EXCHANGE_NAME);
	}

	@Bean
	public Queue citaConfirmadaQueue() {
		return new Queue(QUEUE_NAME);
	}

	@Bean
	public Binding bindingCitaConfirmada(Queue citaConfirmadaQueue, DirectExchange clinicaExchange) {
		return BindingBuilder.bind(citaConfirmadaQueue)
				.to(clinicaExchange)
				.with(ROUTING_KEY);
	}

	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(jackson2JsonMessageConverter());
		return template;
	}
}
