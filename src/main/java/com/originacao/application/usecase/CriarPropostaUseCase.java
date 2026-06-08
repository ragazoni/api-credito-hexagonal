package com.originacao.application.usecase;

import com.originacao.domain.exception.PropostaInelegivelException;
import com.originacao.domain.model.Proposta;
import com.originacao.domain.port.PropostaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CriarPropostaUseCase {

    private final PropostaRepository repository;

    public CriarPropostaUseCase(PropostaRepository repository) {
        this.repository = repository;
    }

    public Proposta executa(String cpf, BigDecimal valor){

        Proposta proposta = new Proposta(cpf, valor);

        if(!proposta.isElegivel()){
            throw new PropostaInelegivelException("valor fora do limite permitido (min R$500 - max R$100.000");
        }
        return repository.salvar(proposta);
    }
}
