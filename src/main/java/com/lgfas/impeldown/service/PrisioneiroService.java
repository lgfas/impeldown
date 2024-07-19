package com.lgfas.impeldown.service;

import com.lgfas.impeldown.dto.PrisioneiroDto;

import java.util.List;

public interface PrisioneiroService {
    PrisioneiroDto cadastrarPrioneiro(PrisioneiroDto prisioneiroDto);

    PrisioneiroDto buscarPrisioneiroPorId(Long id);

    List<PrisioneiroDto> buscarPrisioneiros();
}
