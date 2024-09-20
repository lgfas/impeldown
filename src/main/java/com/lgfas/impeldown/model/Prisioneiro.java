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
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer idade;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelPerigo nivelPerigo;
    @Column(nullable = false)
    private String crime;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelSeguranca nivelSeguranca;

    public Prisioneiro(Long id) {
        this.id = id;
    }
}
