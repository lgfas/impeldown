package com.lgfas.impeldown.service.impl;

import com.lgfas.impeldown.dto.AdministradorDto;
import com.lgfas.impeldown.exception.ResourceNotFoundException;
import com.lgfas.impeldown.mapper.AdministradorMapper;
import com.lgfas.impeldown.model.Administrador;
import com.lgfas.impeldown.model.enums.Cargo;
import com.lgfas.impeldown.repository.AdministradorRepository;
import com.lgfas.impeldown.service.AdministradorService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    private final AdministradorRepository administradorRepository;

    public AdministradorServiceImpl(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }


    @Override
    public void cadastrarAdministrador(AdministradorDto administradorDto) {
        Administrador administrador = AdministradorMapper.fromDto(administradorDto);
        administradorRepository.cadastrarAdministrador(administrador);
    }

    @Override
    public AdministradorDto buscarAdministradorPorId(Long id) {

        try {
            Administrador administrador = administradorRepository.buscarAdministradorPorId(id);
            return AdministradorMapper.toDto(administrador);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Administrador de ID " + id + "     inexistente.");
        }
    }

    @Override
    public List<AdministradorDto> buscarAdministradores() {

        List<Administrador> administradores = administradorRepository.buscarAdministradores();
        return administradores.stream()
                .map(AdministradorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdministradorDto atualizarAdministrador(Long id, AdministradorDto administradorDto) {

        Administrador administrador = administradorRepository.buscarAdministradorPorId(id);

        if (administrador == null) {
            throw new ResourceNotFoundException("Administrador de ID " + id + "     inexistente.");
        }

        administrador.setNome(administradorDto.nome());
        administrador.setCargo(administradorDto.cargo());

        administradorRepository.atualizarAdministrador(id, administrador);

        return AdministradorMapper.toDto(administrador);
    }

    @Override
    public void removerAdministrador(Long id) {

        Administrador administrador = administradorRepository.buscarAdministradorPorId(id);

        if (administrador == null) {
            throw new ResourceNotFoundException("Administrador de ID " + id + "     inexistente.");
        }

        administradorRepository.removerAdministrador(id);
    }

    @Override
    public List<Cargo> buscarCargos() {
        return Arrays.asList(Cargo.values());
    }
}
