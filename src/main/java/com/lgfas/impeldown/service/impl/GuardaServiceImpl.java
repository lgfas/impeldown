package com.lgfas.impeldown.service.impl;

import com.lgfas.impeldown.dto.GuardaDto;
import com.lgfas.impeldown.exception.ResourceNotFoundException;
import com.lgfas.impeldown.mapper.GuardaMapper;
import com.lgfas.impeldown.model.Guarda;
import com.lgfas.impeldown.model.enums.Posto;
import com.lgfas.impeldown.repository.GuardaRepository;
import com.lgfas.impeldown.service.GuardaService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuardaServiceImpl implements GuardaService {

    private final GuardaRepository guardaRepository;

    public GuardaServiceImpl(GuardaRepository guardaRepository) {
        this.guardaRepository = guardaRepository;
    }

    @Override
    public void cadastraGuarda(GuardaDto guardaDto) {
        Guarda guarda = GuardaMapper.fromDto(guardaDto);
        guardaRepository.cadastrarGuarda(guarda);
    }

    @Override
    public GuardaDto buscaGuardaPorId(Long id) {

        try {
            Guarda guarda = guardaRepository.buscarGuardaPorId(id);
            return GuardaMapper.toDto(guarda);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Guarda de ID " + id + " inexistente.");
        }
    }

    @Override
    public List<GuardaDto> buscarGuardas() {
        List<Guarda> guardas = guardaRepository.buscarGuardas();
        return guardas.stream()
                .map(GuardaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public GuardaDto atualizarGuarda(Long id, GuardaDto guardaDto) {

        Guarda guarda = guardaRepository.buscarGuardaPorId(id);

        if (guarda == null) {
            throw new ResourceNotFoundException("Guarda de ID " + id + " inexistente.");
        }

        guarda.setNome(guardaDto.nome());
        guarda.setPosto(guardaDto.posto());

        guardaRepository.atualizarGuarda(id, guarda);

        return GuardaMapper.toDto(guarda);
    }

    @Override
    public void removerGuarda(Long id) {
        Guarda guarda = guardaRepository.buscarGuardaPorId(id);

        if (guarda == null) {
            throw new ResourceNotFoundException("Guarda de ID " + id + " inexistente.");
        }

        guardaRepository.removerGuarda(id);
    }

    @Override
    public List<Posto> buscarPostos() {
        return Arrays.asList(Posto.values());
    }


}
