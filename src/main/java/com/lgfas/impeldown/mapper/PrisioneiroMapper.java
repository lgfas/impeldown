package com.lgfas.impeldown.mapper;

import com.lgfas.impeldown.dto.PrisioneiroDto;
import com.lgfas.impeldown.model.Prisioneiro;

public class PrisioneiroMapper {

    public static PrisioneiroDto toDto(Prisioneiro prisioneiro) {
        return new PrisioneiroDto(
                prisioneiro.getNome(),
                prisioneiro.getIdade(),
                prisioneiro.getNivelPerigo(),
                prisioneiro.getCrime(),
                prisioneiro.getNivelSeguranca()
        );
    }

    public static Prisioneiro fromDto(PrisioneiroDto prisioneiroDto) {
        return new Prisioneiro(
                prisioneiroDto.nome(),
                prisioneiroDto.idade(),
                prisioneiroDto.nivelPerigo(),
                prisioneiroDto.crime(),
                prisioneiroDto.nivelSeguranca()
        );
    }
}
