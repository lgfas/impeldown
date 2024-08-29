package com.lgfas.impeldown.service.impl;

import com.lgfas.impeldown.dto.PrisioneiroDto;
import com.lgfas.impeldown.exception.ResourceNotFoundException;
import com.lgfas.impeldown.mapper.PrisioneiroMapper;
import com.lgfas.impeldown.model.Prisioneiro;
import com.lgfas.impeldown.model.enums.NivelPerigo;
import com.lgfas.impeldown.model.enums.NivelSeguranca;
import com.lgfas.impeldown.repository.PrisioneiroRepository;
import com.lgfas.impeldown.service.PrisioneiroService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrisioneiroServiceImpl implements PrisioneiroService {

    private final PrisioneiroRepository prisioneiroRepository;

    public PrisioneiroServiceImpl(PrisioneiroRepository prisioneiroRepository) {
        this.prisioneiroRepository = prisioneiroRepository;
    }


    @Override
    public void cadastrarPrioneiro(PrisioneiroDto prisioneiroDto) {

        Prisioneiro prisioneiro = PrisioneiroMapper.fromDto(prisioneiroDto);

        verificarIdade(prisioneiro.getIdade());

        prisioneiroRepository.cadastrarPrisioneiro(prisioneiro);
    }

    @Override
    public PrisioneiroDto buscarPrisioneiroPorId(Long id) {

        try {
            Prisioneiro prisioneiro = prisioneiroRepository.buscarPrisioneiroPorId(id);
            return PrisioneiroMapper.toDto(prisioneiro);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Prisioneiro de ID " + id + " inexistente.");
        }
    }

    @Override
    public List<PrisioneiroDto> buscarPrisioneiros(int pagina, int tamanhoPagina) {

        List<Prisioneiro> prisioneiros = prisioneiroRepository.buscarPrisioneiros(pagina,tamanhoPagina);
        return prisioneiros.stream()
                .map(PrisioneiroMapper::toDto)
                .sorted(Comparator.comparing(PrisioneiroDto::id).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public PrisioneiroDto atualizarPrisioneiro(Long id, PrisioneiroDto prisioneiroDto) {

        Prisioneiro prisioneiro = prisioneiroRepository.buscarPrisioneiroPorId(id);

        if (prisioneiro == null) {
            throw new ResourceNotFoundException("Prisioneiro de ID " + id + " inexistente.");
        }

        verificarIdade(prisioneiro.getIdade());

        prisioneiro.setNome(prisioneiroDto.nome());
        prisioneiro.setIdade(prisioneiroDto.idade());
        prisioneiro.setCrime(prisioneiroDto.crime());
        prisioneiro.setNivelPerigo(prisioneiroDto.nivelPerigo());
        prisioneiro.setNivelSeguranca(prisioneiroDto.nivelSeguranca());

        prisioneiroRepository.autalizarPrisioneiro(id, prisioneiro);

        return PrisioneiroMapper.toDto(prisioneiro);
    }

    @Override
    public void removerPrisioneiro(Long id) {

        Prisioneiro prisioneiro = prisioneiroRepository.buscarPrisioneiroPorId(id);

        if (prisioneiro == null) {
            throw new ResourceNotFoundException("Prisioneiro de ID " + id + " inexistente.");
        }

        prisioneiroRepository.removerPrisioneiro(id);
    }

    @Override
    public List<NivelPerigo> buscarNiveisPerigo() {
        return Arrays.asList(NivelPerigo.values());
    }

    @Override
    public List<NivelSeguranca> buscarNiveisSeguranca() {
        return Arrays.asList(NivelSeguranca.values());
    }

    public void verificarIdade(Integer idade) {
        if (idade <= 0) {
            throw new IllegalArgumentException("Idade inválida");
        }
    }
}
