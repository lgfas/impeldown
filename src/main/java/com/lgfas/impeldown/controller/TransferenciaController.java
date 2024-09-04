package com.lgfas.impeldown.controller;

import com.lgfas.impeldown.dto.TransferenciaDto;
import com.lgfas.impeldown.model.enums.NivelSeguranca;
import com.lgfas.impeldown.service.TransferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public ResponseEntity<TransferenciaDto> cadastrarTransferencia(@RequestBody TransferenciaDto transferenciaDto) {
        transferenciaService.cadastrarTransferencia(transferenciaDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferenciaDto> buscarTransferenciaPorId(@PathVariable("id") Long id) {
        TransferenciaDto transferenciaDto = transferenciaService.buscarTransferenciaPorId(id);
        return ResponseEntity.ok(transferenciaDto);
    }

    @GetMapping
    public ResponseEntity<List<TransferenciaDto>> buscarTransferencias(
            @RequestParam(required = false, defaultValue = "1") int pagina,
            @RequestParam(required = false, defaultValue = "10") int tamanhoPagina) {

        List<TransferenciaDto> transferencias = transferenciaService.buscarTransferencias(pagina, tamanhoPagina);

        return ResponseEntity.ok(transferencias);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransferenciaDto> atualizarTransferencia(@PathVariable Long id, @RequestBody TransferenciaDto transferenciaAtualizada) {
        TransferenciaDto transferenciaDto = transferenciaService.atualizarTransferencia(id, transferenciaAtualizada);
        return ResponseEntity.ok(transferenciaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTransferencia(@PathVariable Long id) {
        transferenciaService.removerTransferencia(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/niveisSeguranca")
    public ResponseEntity<List<NivelSeguranca>> buscarNiveisSeguranca() {
        List<NivelSeguranca> nivelSegurancas = transferenciaService.buscarNiveisSeguranca();
        return ResponseEntity.ok(nivelSegurancas);
    }
}
