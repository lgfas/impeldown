package com.lgfas.impeldown.model;

import com.lgfas.impeldown.model.enums.Posto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_guarda")
public class Guarda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Posto posto;
}
