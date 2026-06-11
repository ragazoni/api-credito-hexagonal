package com.originacao.application.usecase;

import com.originacao.domain.exception.PropostaInelegivelException;
import com.originacao.domain.model.Proposta;
import com.originacao.domain.port.PropostaRepository;
import com.originacao.enums.StatusProposta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CriarPropostaUseCaseTest {

    @Mock
    private PropostaRepository repository;

    @InjectMocks
    CriarPropostaUseCase criarPropostaUseCase;

    @Test
    void deve_criar_proposta_valida(){
        when(repository.salvar(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Proposta resultado = criarPropostaUseCase.executa("12345678900", new BigDecimal("5000"));
        assertThat(resultado.getStatus()).isEqualTo(StatusProposta.PENDENTE);
        assertThat(resultado.getCpf()).isEqualTo("12345678900");
        assertThat(resultado.getValor()).isEqualByComparingTo(new BigDecimal("5000"));
        verify(repository, times(1)).salvar(any());

    }

    @Test
    void nao_deve_criar_proposta_com_valor_abaixo_do_minimo(){
        assertThatThrownBy(() -> criarPropostaUseCase.executa("12345678900", new BigDecimal("100")))
                .isInstanceOf(PropostaInelegivelException.class)
                .hasMessageContaining("Proposta inelegível valor fora do limite permitido (min R$500 - max R$100.000");
        verify(repository, never()).salvar(any());
    }

    @Test
    void nao_deve_criar_proposta_com_valor_acima_do_maximo(){
        assertThatThrownBy(() -> criarPropostaUseCase.executa("12345678900", new BigDecimal("150000")))
                .isInstanceOf(PropostaInelegivelException.class)
                .hasMessageContaining("Proposta inelegível valor fora do limite permitido (min R$500 - max R$100.000");
        verify(repository, never()).salvar(any());
    }



}
