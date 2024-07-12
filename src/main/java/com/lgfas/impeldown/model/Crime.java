package com.lgfas.impeldown.model;

import jakarta.persistence.*;

@Entity(name = "tb_crime")
public class Crime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String descricao;
}
