package com.lgfas.impeldown.service.impl;

import com.lgfas.impeldown.dto.PrisioneiroDto;
import com.lgfas.impeldown.exception.ResourceNotFoundException;
import com.lgfas.impeldown.mapper.PrisioneiroMapper;
import com.lgfas.impeldown.model.Prisioneiro;
import com.lgfas.impeldown.repository.CrimeRepository;
import com.lgfas.impeldown.repository.PrisioneiroRepository;
import com.lgfas.impeldown.service.PrisioneiroService;
import org.springframework.stereotype.Service;

@Service
public class PrisioneiroServiceImpl implements PrisioneiroService {

    private final PrisioneiroRepository prisioneiroRepository;
    private final CrimeRepository crimeRepository;

    public PrisioneiroServiceImpl(PrisioneiroRepository prisioneiroRepository, CrimeRepository crimeRepository) {
        this.prisioneiroRepository = prisioneiroRepository;
        this.crimeRepository = crimeRepository;
    }

    @Override
    public PrisioneiroDto cadastrarPrioneiro(PrisioneiroDto prisioneiroDto) {
        crimeRepository.saveAll(prisioneiroDto.getCrimes());

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
}
