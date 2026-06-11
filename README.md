# api-credito-hexagonal

API REST de proposta de crédito desenvolvida com arquitetura hexagonal.

## Stack
- Java 21
- Spring Boot 3.5.1
- PostgreSQL 16
- Flyway
- Docker
- JUnit 5 + Mockito

## Estrutura de pacotes
src/main/java/com/originacao/
├── domain/
│   ├── model/       
│   ├── port/         
│   └── exception/    
├── application/
│   └── usecase/      
├── infrastructure/
│   └── persistence/ 
└── interfaces/       

## Como rodar

### Pré-requisitos
- Docker
- Java 21
- Maven

### Subir o banco
```bash
docker-compose up -d
```

### Rodar a aplicação
```bash
mvn spring-boot:run
```

### Rodar os testes
```bash
mvn test
```

## Endpoints

### POST /propostas
Cria uma nova proposta de crédito.

**Request:**
```json
{
    "cpf": "12345678901",
    "valor": 5000
}
```

**Response 201 Created:**
```json
{
    "id": "uuid",
    "cpf": "12345678901",
    "valor": 5000,
    "status": "PENDENTE"
}
```

**Erros:**
| Status | Motivo |
|---|---|
| 422 | Valor fora do limite (mín R$500 — máx R$100.000) |
| 500 | Erro interno |

## ADRs
- [ADR-001 — Arquitetura Hexagonal](docs/adr/ADR-001-hexagonal-architecture.md)
- [ADR-002 — Flyway para migrations](docs/adr/ADR-002-flyway.md)