package com.marcos.streamcontrol.repository;

import com.marcos.streamcontrol.entity.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    List<Assinatura> findByNomePlataformaContainingIgnoreCase(String nome);
}