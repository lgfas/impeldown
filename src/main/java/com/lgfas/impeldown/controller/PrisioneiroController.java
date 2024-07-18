package com.lgfas.impeldown.controller;

import com.lgfas.impeldown.dto.PrisioneiroDto;
import com.lgfas.impeldown.service.PrisioneiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<PrisioneiroDto> buscarPrisioneiro(@PathVariable Long id) {
        PrisioneiroDto prisioneiroDto = prisioneiroService.buscarPrisioneiroPorId(id);
        return ResponseEntity.ok(prisioneiroDto);
    }
}
