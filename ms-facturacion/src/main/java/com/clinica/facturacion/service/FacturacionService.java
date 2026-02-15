package com.clinica.facturacion.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clinica.facturacion.entity.Factura;
import com.clinica.facturacion.repository.FacturaRepository;

@Service
public class FacturacionService {
	private final FacturaRepository facturaRepository;

	public FacturacionService(FacturaRepository facturaRepository) {
		this.facturaRepository = facturaRepository;
	}

	public Factura crearFactura(Long citaId, Long pacienteId) {
		Factura factura = new Factura(citaId, pacienteId, new BigDecimal("150.00"));
		return facturaRepository.save(factura);
	}

	public Optional<Factura> obtenerFactura(Long id) {
		return facturaRepository.findById(id);
	}
}
