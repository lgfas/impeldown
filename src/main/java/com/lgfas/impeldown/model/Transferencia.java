package com.lgfas.impeldown.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
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
}
