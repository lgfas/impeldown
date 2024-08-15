package com.lgfas.impeldown.service;

import com.lgfas.impeldown.dto.AdministradorDto;
import com.lgfas.impeldown.model.Administrador;

import java.util.List;

public interface AdministradorService {
    void cadastrarAdministrador(AdministradorDto administradorDto);

    AdministradorDto buscarAdministradorPorId(Long id);

    List<AdministradorDto> buscarAdministradores();

    AdministradorDto atualizarAdministrador(Long id, AdministradorDto administradorDto);

    void removerAdministrador(Long id);
}
