package com.originacao.domain.model;

import com.originacao.domain.exception.TransicaoStatusInvalidaException;
import com.originacao.enums.StatusProposta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Proposta {

    private UUID id;
    private String cpf;
    private BigDecimal valor;
    private BigDecimal taxa;
    private StatusProposta status;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;


    public Proposta(String cpf, BigDecimal valor) {
        this.id           = UUID.randomUUID();
        this.cpf          = cpf;
        this.valor        = valor;
        this.status       = StatusProposta.PENDENTE;
        this.criadoEm     = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
    }

    public Proposta(UUID id, String cpf, BigDecimal valor, BigDecimal taxa,
                    StatusProposta status, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.id = id;
        this.cpf = cpf;
        this.valor = valor;
        this.taxa = taxa;
        this.status = status;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public void aprovar(BigDecimal taxa) {
        if (this.status != StatusProposta.PENDENTE) {
            throw new TransicaoStatusInvalidaException(this.status);
        }
        this.taxa = taxa;
        this.status = StatusProposta.APROVADA;
        this.atualizadoEm = LocalDateTime.now();
    }

    public void reprovar(String motivo) {
        if (this.status != StatusProposta.PENDENTE) {
            throw new TransicaoStatusInvalidaException(this.status);
        }
        this.status = StatusProposta.REPROVADA;
        this.atualizadoEm = LocalDateTime.now();
    }

    public boolean isElegivel() {
        return this.valor.compareTo(new BigDecimal("500")) >= 0
                && this.valor.compareTo(new BigDecimal("100000")) <= 0;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public StatusProposta getStatus() {
        return status;
    }

    public void setStatus(StatusProposta status) {
        this.status = status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
