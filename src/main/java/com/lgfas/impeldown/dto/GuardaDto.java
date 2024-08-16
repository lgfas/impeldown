package com.lgfas.impeldown.dto;

import com.lgfas.impeldown.model.enums.Posto;

public record GuardaDto(
        Long id,
        String nome,
        Posto posto
) {
}
