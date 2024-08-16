package com.lgfas.impeldown.service;

import com.lgfas.impeldown.dto.GuardaDto;

import java.util.List;

public interface GuardaService {
    void cadastraGuarda(GuardaDto guardaDto);

    GuardaDto buscaGuardaPorId(Long id);

    List<GuardaDto> buscarGuardas();

    GuardaDto atualizarGuarda(Long id, GuardaDto guardaDto);

    void removerGuarda(Long id);
}