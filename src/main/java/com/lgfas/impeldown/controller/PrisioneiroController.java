package com.lgfas.impeldown.controller;

import com.lgfas.impeldown.dto.PrisioneiroDto;
import com.lgfas.impeldown.service.PrisioneiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prisioneiros")
public class PrisioneiroController {

    private final PrisioneiroService prisioneiroService;

    public PrisioneiroController(PrisioneiroService prisioneiroService) {
        this.prisioneiroService = prisioneiroService;
    }

    @PostMapping
    public ResponseEntity<PrisioneiroDto> cadastrarPrisioneiro(@RequestBody PrisioneiroDto prisioneiroDto) {
        PrisioneiroDto prisioneiroCadastrado = prisioneiroService.cadastrarPrioneiro(prisioneiroDto);
        return new ResponseEntity<>(prisioneiroCadastrado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrisioneiroDto> buscarPrisioneiroPorId(@PathVariable Long id) {
        PrisioneiroDto prisioneiroDto = prisioneiroService.buscarPrisioneiroPorId(id);
        return ResponseEntity.ok(prisioneiroDto);
    }

    @GetMapping
    public ResponseEntity<List<PrisioneiroDto>> buscarPrisioneiros() {
        List<PrisioneiroDto> prisioneiros = prisioneiroService.buscarPrisioneiros();
        return ResponseEntity.ok(prisioneiros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrisioneiroDto> atualizarPrisioneiro(@PathVariable Long id, @RequestBody PrisioneiroDto prisioneiroAtualizado) {

        PrisioneiroDto prisioneiroDto = prisioneiroService.atualizarPrisioneiro(id, prisioneiroAtualizado);

        return ResponseEntity.ok(prisioneiroDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPrisioneiro(@PathVariable Long id) {
        prisioneiroService.removerPrisioneiro(id);
        return ResponseEntity.noContent().build();
    }
}
