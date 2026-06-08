package com.originacao.infrastructure.persistence;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "propostas")
public class PropostaEntity {

    @Id
    private UUID id;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false, precision = 6, scale = 4)
    private BigDecimal taxa;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(name = "criado_em", nullable = false, updatable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em", nullable = false)
    private LocalDateTime atualizadoEm;

    @PrePersist
    protected void onCreated(){
        criadoEm = LocalDateTime.now();
        atualizadoEm = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        atualizadoEm = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    @Override
    public String toString() {
        return "PropostaEntity{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", valor=" + valor +
                ", taxa=" + taxa +
                ", status='" + status + '\'' +
                ", criadoEm=" + criadoEm +
                ", atualizadoEm=" + atualizadoEm +
                '}';
    }


}
