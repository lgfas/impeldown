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

    public Guarda() {
    }

    public Guarda(Long id, String nome, Posto posto) {
        this.id = id;
        this.nome = nome;
        this.posto = posto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Posto getPosto() {
        return posto;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }
}