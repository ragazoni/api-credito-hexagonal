package com.originacao.domain.port;

import com.originacao.domain.model.Proposta;

import java.util.Optional;
import java.util.UUID;

public interface PropostaRepository {

    Proposta salvar(Proposta proposta);

    Optional<Proposta>buscarPorId(UUID id);
}
