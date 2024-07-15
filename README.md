# Impel Down

## Diagrama de Classes

```mermaid
classDiagram
    class Prisioneiro {
        +int id
        +String nome
        +int idade
        +String nivelPerigo
        +String nivelSeguranca
        +cadastrar()
        +atualizar()
        +remover()
        +consultar()
    }

    class Crime {
        +int id
        +String descricao
        +cadastrar()
        +atualizar()
        +remover()
        +consultar()
    }

    class PrisioneiroCrimes {
        +int id
        +Prisioneiro prisioneiro
        +Crime crime
    }

    class Guarda {
        +int id
        +String nome
        +String posto
        +cadastrar()
        +atualizar()
        +remover()
    }

    class Transferencia {
        +int id
        +Prisioneiro prisioneiro
        +String nivelOrigem
        +String nivelDestino
        +Date dataTransferencia
        +registrar()
        +consultar()
    }

    class Relatorio {
        +gerarRelatorioPrisioneiros()
        +gerarRelatorioCrimes()
    }

    class Administrador {
        +int id
        +String nome
        +String cargo
        +cadastrarGuarda()
        +atualizarGuarda()
        +removerGuarda()
        +gerarRelatorio()
    }

    Prisioneiro --> PrisioneiroCrimes : "1 comete"
    Crime --> PrisioneiroCrimes : "1 é cometido por"
    Prisioneiro --> Transferencia : "1 tem"
    Transferencia --> Prisioneiro : "1 refere-se"
    Guarda --> Transferencia : "1 realiza"
    Administrador --> Guarda : "1 gerencia"
    Administrador --> Relatorio : "1 gera"



```

## Modelo Entidade-Relacionamento

```mermaid

erDiagram
    PRISIONEIROS {
        int id PK
        varchar nome
        int idade
        varchar nivel_perigo
        varchar nivel_seguranca
    }

    CRIMES {
        int id PK
        varchar descricao
    }

    PRISIONEIROCRIMES {
        int id PK
        int prisioneiro_id FK
        int crime_id FK
    }

    GUARDAS {
        int id PK
        varchar nome
        varchar posto
    }

    TRANSFERENCIAS {
        int id PK
        int prisioneiro_id FK
        varchar nivel_origem
        varchar nivel_destino
        date data_transferencia
    }

    ADMINISTRADORES {
        int id PK
        varchar nome
        varchar cargo
    }

    PRISIONEIROS ||--o{ PRISIONEIROCRIMES : "comete"
    PRISIONEIROCRIMES }o--|| CRIMES : "lista"
    PRISIONEIROS ||--o{ TRANSFERENCIAS : "possui"
    TRANSFERENCIAS }o--|| PRISIONEIROS : "referem-se a"


```