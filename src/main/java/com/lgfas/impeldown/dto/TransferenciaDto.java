package com.lgfas.impeldown.dto;

import com.lgfas.impeldown.model.enums.NivelSeguranca;

import java.time.LocalDateTime;

public record TransferenciaDto(
        Long id,
        Long codPrisioneiro,
        NivelSeguranca nivelOrigem,
        NivelSeguranca nivelDestino,
        LocalDateTime dataTransferencia) {
}
