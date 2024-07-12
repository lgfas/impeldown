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

}
