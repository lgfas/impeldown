package com.lgfas.impeldown.model;

import com.lgfas.impeldown.model.enums.NivelPerigo;
import com.lgfas.impeldown.model.enums.NivelSeguranca;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_prisioneiro")
public class Prisioneiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private Integer idade;
    private NivelPerigo nivelPerigo;
    @OneToMany
    private List<Crime> crimes;
    private NivelSeguranca nivelSeguranca;

    public Prisioneiro() {
    }

    public Prisioneiro(Long id, String nome, Integer idade, NivelPerigo nivelPerigo, List<Crime> crimes, NivelSeguranca nivelSeguranca) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.nivelPerigo = nivelPerigo;
        this.crimes = crimes;
        this.nivelSeguranca = nivelSeguranca;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public NivelPerigo getNivelPerigo() {
        return nivelPerigo;
    }

    public void setNivelPerigo(NivelPerigo nivelPerigo) {
        this.nivelPerigo = nivelPerigo;
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    public NivelSeguranca getNivelSeguranca() {
        return nivelSeguranca;
    }

    public void setNivelSeguranca(NivelSeguranca nivelSeguranca) {
        this.nivelSeguranca = nivelSeguranca;
    }
}
