package com.clinica.facturacion.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.facturacion.entity.Factura;
import com.clinica.facturacion.service.FacturacionService;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
	private final FacturacionService facturacionService;

	public FacturaController(FacturacionService facturacionService) {
		this.facturacionService = facturacionService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Factura> obtenerFactura(@PathVariable Long id) {
		Optional<Factura> factura = facturacionService.obtenerFactura(id);
		return factura.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
