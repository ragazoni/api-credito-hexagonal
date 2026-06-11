# ADR-001 — Arquitetura Hexagonal

## Status
Aceito

## Contexto
Precisamos de uma arquitetura que isole o domínio de negócio
dos detalhes técnicos (banco, framework, API).

## Decisão
Adotar Hexagonal Architecture (Ports and Adapters).
- Domain: regras de negócio puras, sem dependências externas
- Ports: interfaces que o domínio expõe e consome
- Adapters: implementações técnicas (JPA, REST, etc)

## Consequências
- Domínio testável sem Spring ou banco
- Fácil trocar implementações (ex: PostgreSQL → MongoDB)
- Mais arquivos e camadas — complexidade inicial maior