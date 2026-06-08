package com.originacao.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PropostaRepositoryJpa extends JpaRepository<PropostaEntity, UUID> {
}
