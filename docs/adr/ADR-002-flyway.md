# ADR-002 — Flyway para migrations

## Status
Aceito

## Contexto
Precisamos versionar mudanças de schema do banco de dados
de forma controlada e rastreável.

## Decisão
Usar Flyway com scripts SQL versionados em db/migration/.
- ddl-auto: validate — Hibernate valida, não cria schema
- Scripts nomeados: V{versão}__{descrição}.sql

## Consequências
- Histórico completo de mudanças no banco
- Rollback controlado por versão
- Flyway 10+ exige flyway-database-postgresql explícito