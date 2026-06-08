package com.originacao.domain.exception;

import com.originacao.enums.StatusProposta;

public class TransicaoStatusInvalidaException extends DomainException{

    public TransicaoStatusInvalidaException(StatusProposta statusAtual) {
        super("Transição inválida a partir do status " + statusAtual);
    }
}
