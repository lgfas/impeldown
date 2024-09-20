package com.lgfas.impeldown.mapper;

import com.lgfas.impeldown.dto.TransferenciaDto;
import com.lgfas.impeldown.model.Prisioneiro;
import com.lgfas.impeldown.model.Transferencia;

public class TransferenciaMapper {

    public static TransferenciaDto toDto(Transferencia transferencia) {
        return new TransferenciaDto(
                transferencia.getId(),
                transferencia.getPrisioneiro().getId(),
                transferencia.getNivelOrigem(),
                transferencia.getNivelDestino(),
                transferencia.getDataTransferencia()
        );
    }

    public static Transferencia fromDto(TransferenciaDto transferenciaDto) {
        return new Transferencia(
                transferenciaDto.id(),
                new Prisioneiro(transferenciaDto.codPrisioneiro()),
                transferenciaDto.nivelOrigem(),
                transferenciaDto.nivelDestino(),
                transferenciaDto.dataTransferencia()
        );
    }
}
