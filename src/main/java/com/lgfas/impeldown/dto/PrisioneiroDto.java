package com.lgfas.impeldown.dto;

import com.lgfas.impeldown.model.Crime;
import com.lgfas.impeldown.model.enums.NivelPerigo;
import com.lgfas.impeldown.model.enums.NivelSeguranca;

import java.util.List;

public class PrisioneiroDto {
    private String nome;
    private Integer idade;
    private NivelPerigo nivelPerigo;
    private List<Crime> crimes;
    private NivelSeguranca nivelSeguranca;

    public PrisioneiroDto() {
    }

    public PrisioneiroDto(String nome, Integer idade, NivelPerigo nivelPerigo, List<Crime> crimes, NivelSeguranca nivelSeguranca) {
        this.nome = nome;
        this.idade = idade;
        this.nivelPerigo = nivelPerigo;
        this.crimes = crimes;
        this.nivelSeguranca = nivelSeguranca;
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
