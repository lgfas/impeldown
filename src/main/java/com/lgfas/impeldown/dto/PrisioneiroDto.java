package com.lgfas.impeldown.dto;

import com.lgfas.impeldown.model.enums.NivelPerigo;
import com.lgfas.impeldown.model.enums.NivelSeguranca;

public record PrisioneiroDto (
        Long id,
        String nome,
        Integer idade,
        NivelPerigo nivelPerigo,
        String crime,
        NivelSeguranca nivelSeguranca
){
}
