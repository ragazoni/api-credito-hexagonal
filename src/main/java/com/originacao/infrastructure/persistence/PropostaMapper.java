package com.originacao.infrastructure.persistence;

import com.originacao.domain.model.Proposta;
import com.originacao.enums.StatusProposta;
import org.springframework.stereotype.Component;

@Component
public class PropostaMapper {

    public PropostaEntity toEntity(Proposta proposta){
        PropostaEntity entity = new PropostaEntity();
        entity.setId(proposta.getId());
        entity.setCpf(proposta.getCpf());
        entity.setValor(proposta.getValor());
        entity.setTaxa(proposta.getTaxa());
        entity.setStatus(proposta.getStatus().name());
        entity.setCriadoEm(proposta.getCriadoEm());
        entity.setAtualizadoEm(proposta.getAtualizadoEm());
        return entity;
    }

    public Proposta toDomain(PropostaEntity propostaEntity){
        return new Proposta(
                propostaEntity.getId(),
                propostaEntity.getCpf(),
                propostaEntity.getValor(),
                propostaEntity.getTaxa(),
                StatusProposta.valueOf(propostaEntity.getStatus()),
                propostaEntity.getCriadoEm(),
                propostaEntity.getAtualizadoEm());
    }
}
