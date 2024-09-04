package com.lgfas.impeldown.service;

import com.lgfas.impeldown.dto.PrisioneiroDto;
import com.lgfas.impeldown.model.enums.NivelPerigo;
import com.lgfas.impeldown.model.enums.NivelSeguranca;

import java.util.List;

public interface PrisioneiroService {
    void cadastrarPrisioneiro(PrisioneiroDto prisioneiroDto);

    PrisioneiroDto buscarPrisioneiroPorId(Long id);

    List<PrisioneiroDto> buscarPrisioneiros(int pagina, int tamanhoPagina);

    PrisioneiroDto atualizarPrisioneiro(Long id,PrisioneiroDto prisioneiroDto);

    void removerPrisioneiro(Long id);

    List<NivelPerigo> buscarNiveisPerigo();

    List<NivelSeguranca> buscarNiveisSeguranca();
}
