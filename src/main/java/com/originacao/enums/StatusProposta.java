package com.originacao.enums;

public enum StatusProposta {

    PENDENTE,
    APROVADA,
    REPROVADA,
    CANCELADA;

    public boolean podeSerAprovada() {
        return this == PENDENTE;
    }

    public boolean podeSerReprovada() {
        return this == PENDENTE;
    }


}
