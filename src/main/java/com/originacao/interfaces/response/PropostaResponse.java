package com.originacao.interfaces.response;

import com.originacao.domain.model.Proposta;

import java.math.BigDecimal;
import java.util.UUID;

public record PropostaResponse(
        UUID id,
        String cpf,
        BigDecimal valor,
        String status
) {
    public PropostaResponse(Proposta proposta){
        this(   proposta.getId(),
                proposta.getCpf(),
                proposta.getValor(),
                proposta.getStatus().name()
        );
    }
}
