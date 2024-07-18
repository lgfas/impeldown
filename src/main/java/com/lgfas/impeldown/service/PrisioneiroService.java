package com.lgfas.impeldown.service;

import com.lgfas.impeldown.dto.PrisioneiroDto;

public interface PrisioneiroService {
    PrisioneiroDto cadastrarPrioneiro(PrisioneiroDto prisioneiroDto);

    PrisioneiroDto buscarPrisioneiroPorId(Long id);
}
