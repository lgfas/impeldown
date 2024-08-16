package com.lgfas.impeldown.mapper;

import com.lgfas.impeldown.dto.GuardaDto;
import com.lgfas.impeldown.model.Guarda;

public class GuardaMapper {

    public static GuardaDto toDto(Guarda guarda) {
        return new GuardaDto(
                guarda.getId(),
                guarda.getNome(),
                guarda.getPosto()
        );
    }

    public static Guarda fromDto(GuardaDto guardaDto) {
        return new Guarda(
                guardaDto.id(),
                guardaDto.nome(),
                guardaDto.posto()
        );
    }
}
