package com.lgfas.impeldown.mapper;

import com.lgfas.impeldown.dto.AdministradorDto;
import com.lgfas.impeldown.model.Administrador;

public class AdministradorMapper {

    public static AdministradorDto toDto(Administrador administrador) {
        return new AdministradorDto(
                administrador.getId(),
                administrador.getNome(),
                administrador.getCargo()
        );
    }

    public static Administrador fromDto(AdministradorDto administradorDto) {
        return new Administrador(
                administradorDto.id(),
                administradorDto.nome(),
                administradorDto.cargo()
        );
    }
}
