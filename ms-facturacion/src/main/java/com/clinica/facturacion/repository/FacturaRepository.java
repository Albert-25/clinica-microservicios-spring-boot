package com.clinica.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.facturacion.entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
