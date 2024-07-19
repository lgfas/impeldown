package com.lgfas.impeldown.model;

import com.lgfas.impeldown.model.enums.NivelPerigo;
import com.lgfas.impeldown.model.enums.NivelSeguranca;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_prisioneiro")
public class Prisioneiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private Integer idade;
    @Enumerated(EnumType.STRING)
    private NivelPerigo nivelPerigo;
    private String crime;
    @Enumerated(EnumType.STRING)
    private NivelSeguranca nivelSeguranca;

    public Prisioneiro(String nome, Integer idade, NivelPerigo nivelPerigo, String crime, NivelSeguranca nivelSeguranca) {
        this.nome = nome;
        this.idade = idade;
        this.nivelPerigo = nivelPerigo;
        this.crime = crime;
        this.nivelSeguranca = nivelSeguranca;
    }
}
