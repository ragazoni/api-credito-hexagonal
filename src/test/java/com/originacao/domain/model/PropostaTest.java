package com.originacao.domain.model;

import com.originacao.domain.exception.TransicaoStatusInvalidaException;
import com.originacao.enums.StatusProposta;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PropostaTest {

    @Test
    void deve_criar_com_status_pendente() {
        var proposta = new Proposta("12345678900", new BigDecimal("5000"));
        assertThat(proposta.getStatus()).isEqualTo(StatusProposta.PENDENTE);
        assertThat(proposta.getId()).isNotNull();
        assertThat(proposta.getCriadoEm()).isNotNull();
    }

    @Test
    void deve_aprovar_proposta_pendente(){
        var proposta = new Proposta("12345678900", new BigDecimal("5000"));
        var taxa = new BigDecimal("0.05");
        proposta.aprovar(taxa);

        assertThat(proposta.getStatus()).isEqualTo(StatusProposta.APROVADA);
        assertThat(proposta.getTaxa()).isEqualByComparingTo(taxa);

    }

    @Test
    void nao_deve_aprovar_proposta_ja_aprovada() {
        var proposta = new Proposta("12345678900", new BigDecimal("5000"));
        proposta.aprovar(new BigDecimal("0.05"));
        assertThatThrownBy(() -> proposta.aprovar(new BigDecimal("0.01")))
                .isInstanceOf(TransicaoStatusInvalidaException.class);
    }

    @Test
    void deve_reprovar_proposta_pendente(){
        var proposta = new Proposta("12345678900", new BigDecimal("5000"));
        proposta.reprovar("Scorred credito baixo");
        assertThat(proposta.getStatus()).isEqualTo(StatusProposta.REPROVADA);
    }

    @Test
    void nao_deve_reprovar_proposta_ja_reprovada() {
        var proposta = new Proposta("12345678900", new BigDecimal("5000"));
        proposta.reprovar("Scorred credito baixo");
        assertThatThrownBy(() -> proposta.reprovar("Outro motivo"))
                .isInstanceOf(TransicaoStatusInvalidaException.class);
    }

    @Test
    void nao_deve_ser_elegivel_para_valor_abaixo_do_minimo() {
        var proposta = new Proposta("12345678900", new BigDecimal("100"));
        assertThat(proposta.isElegivel()).isFalse();
    }

    @Test
    void deve_ser_elegivel_para_valor_acima_do_minimo() {
        var proposta = new Proposta("12345678900", new BigDecimal("5000"));
        assertThat(proposta.isElegivel()).isTrue();
    }

}
