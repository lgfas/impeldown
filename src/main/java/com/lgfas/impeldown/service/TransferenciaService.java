package com.lgfas.impeldown.service;

import com.lgfas.impeldown.dto.TransferenciaDto;
import com.lgfas.impeldown.model.enums.NivelSeguranca;

import java.util.List;

public interface TransferenciaService {
    void cadastrarTransferencia(TransferenciaDto transferenciaDto);

    TransferenciaDto buscarTransferenciaPorId(Long id);

    List<TransferenciaDto> buscarTransferencias(int pagina, int tamanhoPagina);

    TransferenciaDto atualizarTransferencia(Long id,TransferenciaDto transferenciaDto);

    void removerTransferencia(Long id);

    List<NivelSeguranca> buscarNiveisSeguranca();
}
