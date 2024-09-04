package com.lgfas.impeldown.mapper;

import com.lgfas.impeldown.dto.TransferenciaDto;
import com.lgfas.impeldown.model.Transferencia;

public class TransferenciaMapper {

    public static TransferenciaDto toDto(Transferencia transferencia) {
        return new TransferenciaDto(
                transferencia.getId(),
                transferencia.getPrisioneiro(),
                transferencia.getNivelOrigem(),
                transferencia.getNivelDestino(),
                transferencia.getDataTransferencia()
        );
    }

    public static Transferencia fromDto(TransferenciaDto transferenciaDto) {
        return new Transferencia(
                transferenciaDto.id(),
                transferenciaDto.prisioneiro(),
                transferenciaDto.nivelOrigem(),
                transferenciaDto.nivelDestino(),
                transferenciaDto.dataTransferencia()
        );
    }
}
