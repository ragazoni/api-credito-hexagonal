package com.originacao.interfaces.rest;

import java.math.BigDecimal;

public record PropostaRequest(
        String cpf,
        BigDecimal valor
) {
}
