package com.originacao.interfaces;

import com.originacao.application.usecase.CriarPropostaUseCase;
import com.originacao.interfaces.response.PropostaResponse;
import com.originacao.interfaces.rest.PropostaRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    private final CriarPropostaUseCase criarPropostaUseCase;

    public PropostaController(CriarPropostaUseCase criarPropostaUseCase) {
        this.criarPropostaUseCase = criarPropostaUseCase;
    }

    @PostMapping
    public ResponseEntity<PropostaResponse> criarProposta(@RequestBody PropostaRequest request) {
        var proposta = criarPropostaUseCase.executa(request.cpf(), request.valor());
        return ResponseEntity.status(HttpStatus.CREATED).body(new PropostaResponse(proposta));
    }


}
