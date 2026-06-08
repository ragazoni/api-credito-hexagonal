package com.originacao.infrastructure.persistence;

import com.originacao.domain.model.Proposta;
import com.originacao.domain.port.PropostaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class PropostaRepositoryAdapter implements PropostaRepository {

    private final PropostaRepositoryJpa propostaRepositoryJpa;
    private final PropostaMapper propostaMapper;

    public PropostaRepositoryAdapter(PropostaRepositoryJpa propostaRepositoryJpa,
                                     PropostaMapper propostaMapper) {
        this.propostaRepositoryJpa = propostaRepositoryJpa;
        this.propostaMapper = propostaMapper;
    }


    @Override
    public Proposta salvar(Proposta proposta) {
        PropostaEntity entity = propostaMapper.toEntity(proposta);
        PropostaEntity salvar = propostaRepositoryJpa.save(entity);
        return propostaMapper.toDomain(salvar);
    }

    @Override
    public Optional<Proposta> buscarPorId(UUID id) {
        return propostaRepositoryJpa.findById(id).map(propostaMapper::toDomain);
    }
}
