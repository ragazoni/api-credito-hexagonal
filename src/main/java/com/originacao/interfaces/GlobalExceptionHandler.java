package com.originacao.interfaces;

import com.originacao.domain.exception.PropostaInelegivelException;
import com.originacao.domain.exception.PropostaNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PropostaNaoEncontradaException.class)
    public ResponseEntity<Map<String, Object>> handleNaoEncontrada(
            PropostaNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error(404, ex.getMessage()));
    }

    @ExceptionHandler(PropostaInelegivelException.class)
    public ResponseEntity<Map<String, Object>> handleInelegivel(
            PropostaInelegivelException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(error(422, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error(500, "Ocorreu um erro inesperado"));
    }

    private Map<String, Object> error(int status, String message) {
        return Map.of(
                "status", status,
                "message", message
        );
    }
}
