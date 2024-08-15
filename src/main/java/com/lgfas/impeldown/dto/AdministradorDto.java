package com.lgfas.impeldown.dto;

import com.lgfas.impeldown.model.enums.Cargo;

public record AdministradorDto(
        Long id,
        String nome,
        Cargo cargo
) {
}
