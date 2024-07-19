package com.lgfas.impeldown.service.impl;

import com.lgfas.impeldown.dto.PrisioneiroDto;
import com.lgfas.impeldown.exception.ResourceNotFoundException;
import com.lgfas.impeldown.mapper.PrisioneiroMapper;
import com.lgfas.impeldown.model.Prisioneiro;
import com.lgfas.impeldown.repository.PrisioneiroRepository;
import com.lgfas.impeldown.service.PrisioneiroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrisioneiroServiceImpl implements PrisioneiroService {

    private final PrisioneiroRepository prisioneiroRepository;

    public PrisioneiroServiceImpl(PrisioneiroRepository prisioneiroRepository) {
        this.prisioneiroRepository = prisioneiroRepository;
    }


    @Override
    public PrisioneiroDto cadastrarPrioneiro(PrisioneiroDto prisioneiroDto) {

        Prisioneiro prisioneiro = PrisioneiroMapper.fromDto(prisioneiroDto);
        Prisioneiro prisioneiroCadastrado = prisioneiroRepository.save(prisioneiro);
        return PrisioneiroMapper.toDto(prisioneiroCadastrado);
    }

    @Override
    public PrisioneiroDto buscarPrisioneiroPorId(Long id) {

        Prisioneiro prisioneiro = prisioneiroRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Prisioneiro de ID " + id + " inexistente.")
                );
        return PrisioneiroMapper.toDto(prisioneiro);
    }

    @Override
    public List<PrisioneiroDto> buscarPrisioneiros() {

        List<Prisioneiro> prisioneiros = prisioneiroRepository.findAll();
        return prisioneiros.stream()
                .map(PrisioneiroMapper::toDto)
                .collect(Collectors.toList());
    }
}
