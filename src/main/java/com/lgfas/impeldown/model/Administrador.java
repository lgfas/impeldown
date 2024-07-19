package com.lgfas.impeldown.model;

import com.lgfas.impeldown.model.enums.Cargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_administrador")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private Cargo cargo;

    public Administrador(String nome, Cargo cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }
}
