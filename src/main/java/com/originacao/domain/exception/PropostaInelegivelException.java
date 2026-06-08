package com.originacao.domain.exception;

public class PropostaInelegivelException extends DomainException{

    public PropostaInelegivelException(String motivo) {
        super("Proposta inelegível " + motivo);
    }
}
