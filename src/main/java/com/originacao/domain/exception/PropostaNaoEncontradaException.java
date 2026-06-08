package com.originacao.domain.exception;

import java.util.UUID;

public class PropostaNaoEncontradaException extends DomainException{

    public PropostaNaoEncontradaException(UUID id) {
        super("Proposta não encontrada para o id " + id);
    }
}
