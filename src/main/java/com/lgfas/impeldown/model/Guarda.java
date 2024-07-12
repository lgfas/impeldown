package com.lgfas.impeldown.model;

import com.lgfas.impeldown.model.enums.Posto;
import jakarta.persistence.*;

@Entity(name = "tb_guarda")
public class Guarda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private Posto posto;
    private Boolean autorizado;
}
