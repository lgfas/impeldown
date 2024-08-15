package com.lgfas.impeldown.service;

import com.lgfas.impeldown.dto.PrisioneiroDto;

import java.util.List;

public interface PrisioneiroService {
    void cadastrarPrioneiro(PrisioneiroDto prisioneiroDto);

    PrisioneiroDto buscarPrisioneiroPorId(Long id);

    List<PrisioneiroDto> buscarPrisioneiros();

    PrisioneiroDto atualizarPrisioneiro(Long id,PrisioneiroDto prisioneiroDto);

    void removerPrisioneiro(Long id);
}
