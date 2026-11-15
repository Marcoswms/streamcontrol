package com.marcos.streamcontrol.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "assinaturas")
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da plataforma é obrigatório")
    @Size(min = 2, max = 50, message = "O nome deve ter de 2 a 50 caracteres")
    private String nomePlataforma;

    @NotNull(message = "O valor mensal é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    private BigDecimal valorMensal;

    @NotNull(message = "A data da assinatura é obrigatória")
    @PastOrPresent(message = "A data não pode ser no futuro")
    private LocalDate dataAssinatura;

    public Assinatura() {

    }

    public String getNomePlataforma() {
        return nomePlataforma;
    }

    public void setNomePlataforma(String nomePlataforma) {
        this.nomePlataforma = nomePlataforma;
    }

    public BigDecimal getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(BigDecimal valorMensal) {
        this.valorMensal = valorMensal;
    }

    public LocalDate getDataAssinatura() {
        return dataAssinatura;
    }

    public void setDataAssinatura() {
        this.dataAssinatura = dataAssinatura;
    }
}