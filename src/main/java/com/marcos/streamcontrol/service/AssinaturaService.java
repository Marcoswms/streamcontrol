package com.marcos.streamcontrol.service;

import com.marcos.streamcontrol.entity.Assinatura;
import com.marcos.streamcontrol.repository.AssinaturaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class AssinaturaService {

    private final AssinaturaRepository assinaturaRepository;

    public AssinaturaService(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<Assinatura> listar() {
        return assinaturaRepository.findAll();
    }

    public Assinatura buscarporId(Long id) {
        return assinaturaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Assinatura não encontrada"));
    }

    public void salvar(Assinatura assinatura) {
        assinaturaRepository.save(assinatura);
    }

    public void excluir(Long id) {
        assinaturaRepository.deleteById(id);
    }

    public BigDecimal totalMensal() {
        return assinaturaRepository.findAll().stream()
                .map(Assinatura::getValorMensal)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}