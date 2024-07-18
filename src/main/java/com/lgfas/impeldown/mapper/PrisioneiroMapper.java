package com.lgfas.impeldown.mapper;

import com.lgfas.impeldown.dto.PrisioneiroDto;
import com.lgfas.impeldown.model.Prisioneiro;

public class PrisioneiroMapper {

    public static PrisioneiroDto toDto(Prisioneiro prisioneiro) {
        return new PrisioneiroDto(
                prisioneiro.getNome(),
                prisioneiro.getIdade(),
                prisioneiro.getNivelPerigo(),
                prisioneiro.getCrimes(),
                prisioneiro.getNivelSeguranca()
        );
    }

    public static Prisioneiro fromDto(PrisioneiroDto prisioneiroDto) {
        return new Prisioneiro(
                prisioneiroDto.getNome(),
                prisioneiroDto.getIdade(),
                prisioneiroDto.getNivelPerigo(),
                prisioneiroDto.getCrimes(),
                prisioneiroDto.getNivelSeguranca()
        );
    }
}
