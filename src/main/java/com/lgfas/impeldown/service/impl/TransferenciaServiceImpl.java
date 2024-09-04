package com.lgfas.impeldown.service.impl;

import com.lgfas.impeldown.dto.TransferenciaDto;
import com.lgfas.impeldown.exception.ResourceNotFoundException;
import com.lgfas.impeldown.mapper.TransferenciaMapper;
import com.lgfas.impeldown.model.Prisioneiro;
import com.lgfas.impeldown.model.Transferencia;
import com.lgfas.impeldown.model.enums.NivelSeguranca;
import com.lgfas.impeldown.repository.PrisioneiroRepository;
import com.lgfas.impeldown.repository.TransferenciaRepository;
import com.lgfas.impeldown.service.TransferenciaService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final PrisioneiroRepository prisioneiroRepository;

    public TransferenciaServiceImpl(TransferenciaRepository transferenciaRepository, PrisioneiroRepository prisioneiroRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.prisioneiroRepository = prisioneiroRepository;
    }

    @Override
    public void cadastrarTransferencia(TransferenciaDto transferenciaDto) {
        Transferencia transferencia = TransferenciaMapper.fromDto(transferenciaDto);

        try {
            Prisioneiro prisioneiro = prisioneiroRepository.buscarPrisioneiroPorId(transferencia.getPrisioneiro().getId());
            prisioneiro.setNivelSeguranca(transferencia.getNivelDestino());
            prisioneiroRepository.autalizarPrisioneiro(transferencia.getPrisioneiro().getId(), prisioneiro);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Prisioneiro de ID " + transferencia.getPrisioneiro().getId() + " inexistente.");
        }

        transferencia.setDataTransferencia(LocalDateTime.now());

        transferenciaRepository.cadastrarTransferencia(transferencia);
    }

    @Override
    public TransferenciaDto buscarTransferenciaPorId(Long id) {
        try {
            Transferencia transferencia = transferenciaRepository.buscarTransferenciaPorId(id);
            return TransferenciaMapper.toDto(transferencia);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Transferencia de ID " + id + " inexistente.");
        }
    }

    @Override
    public List<TransferenciaDto> buscarTransferencias(int pagina, int tamanhoPagina) {

        List<Transferencia> transferencias = transferenciaRepository.buscarTransferencias(pagina, tamanhoPagina);
        return transferencias.stream()
                .map(TransferenciaMapper::toDto)
                .sorted(Comparator.comparing(TransferenciaDto::id).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public TransferenciaDto atualizarTransferencia(Long id, TransferenciaDto transferenciaDto) {

        Transferencia transferencia = transferenciaRepository.buscarTransferenciaPorId(id);

        if (transferencia == null) {
            throw new ResourceNotFoundException("Transferencia de ID " + id + " inexistente.");
        }

        Prisioneiro prisioneiro = prisioneiroRepository.buscarPrisioneiroPorId(transferencia.getPrisioneiro().getId());

        if (prisioneiro == null) {
            throw new ResourceNotFoundException("Prisioneiro de ID " + transferencia.getPrisioneiro().getId() + " inexistente.");
        }

        prisioneiro.setNivelSeguranca(transferencia.getNivelDestino());
        prisioneiroRepository.autalizarPrisioneiro(transferencia.getPrisioneiro().getId(), prisioneiro);

        transferencia.setPrisioneiro(prisioneiro);
        transferencia.setNivelOrigem(transferenciaDto.nivelOrigem());
        transferencia.setNivelDestino(transferenciaDto.nivelDestino());
        transferencia.setDataTransferencia(transferenciaDto.dataTransferencia());

        transferenciaRepository.atualizarTransferencia(id, transferencia);

        return TransferenciaMapper.toDto(transferencia);
    }

    @Override
    public void removerTransferencia(Long id) {

        Transferencia transferencia = transferenciaRepository.buscarTransferenciaPorId(id);

        if (transferencia == null) {
            throw new ResourceNotFoundException("Transferencia de ID " + id + " inexistente.");
        }

        transferenciaRepository.removerTransferencia(id);
    }

    @Override
    public List<NivelSeguranca> buscarNiveisSeguranca() {
        return Arrays.asList(NivelSeguranca.values());
    }
}
