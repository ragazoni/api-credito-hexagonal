CREATE TABLE propostas (
    id            UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cpf           VARCHAR(11)     NOT NULL,
    valor         NUMERIC(15, 2)  NOT NULL,
    taxa          NUMERIC(6, 4),
    status        VARCHAR(20)     NOT NULL DEFAULT 'PENDENTE',
    criado_em     TIMESTAMP       NOT NULL DEFAULT NOW(),
    atualizado_em TIMESTAMP       NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_propostas_cpf    ON propostas(cpf);
CREATE INDEX idx_propostas_status ON propostas(status);
