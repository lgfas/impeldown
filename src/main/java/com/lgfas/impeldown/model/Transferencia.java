package com.lgfas.impeldown.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "tb_transferencia")
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "prisioneiro_id")
    private Prisioneiro prisioneiro;
    private String nivelOrigem;
    private String nivelDestino;
    private LocalDateTime dataTransferencia;

    public Transferencia() {
    }

    public Transferencia(Long id, Prisioneiro prisioneiro, String nivelOrigem, String nivelDestino, LocalDateTime dataTransferencia) {
        this.id = id;
        this.prisioneiro = prisioneiro;
        this.nivelOrigem = nivelOrigem;
        this.nivelDestino = nivelDestino;
        this.dataTransferencia = dataTransferencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prisioneiro getPrisioneiro() {
        return prisioneiro;
    }

    public void setPrisioneiro(Prisioneiro prisioneiro) {
        this.prisioneiro = prisioneiro;
    }

    public String getNivelOrigem() {
        return nivelOrigem;
    }

    public void setNivelOrigem(String nivelOrigem) {
        this.nivelOrigem = nivelOrigem;
    }

    public String getNivelDestino() {
        return nivelDestino;
    }

    public void setNivelDestino(String nivelDestino) {
        this.nivelDestino = nivelDestino;
    }

    public LocalDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDateTime dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }
}
