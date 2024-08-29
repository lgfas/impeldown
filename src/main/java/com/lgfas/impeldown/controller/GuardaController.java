package com.lgfas.impeldown.controller;

import com.lgfas.impeldown.dto.GuardaDto;
import com.lgfas.impeldown.model.enums.Posto;
import com.lgfas.impeldown.service.GuardaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/guardas")
public class GuardaController {

    private final GuardaService guardaService;

    public GuardaController(GuardaService guardaService) {
        this.guardaService = guardaService;
    }

    @PostMapping
    public ResponseEntity<GuardaDto> cadastrarGuarda(@RequestBody GuardaDto guardaDto) {
        guardaService.cadastraGuarda(guardaDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuardaDto> buscarGuardaPorId(@PathVariable Long id) {
        GuardaDto guardaDto = guardaService.buscaGuardaPorId(id);
        return ResponseEntity.ok(guardaDto);
    }

    @GetMapping
    public ResponseEntity<List<GuardaDto>> buscarGuardas() {
        List<GuardaDto> guardas = guardaService.buscarGuardas();
        return ResponseEntity.ok(guardas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuardaDto> atualizarGuarda(@PathVariable Long id, @RequestBody GuardaDto guardaAtualizado) {
        GuardaDto guardaDto = guardaService.atualizarGuarda(id, guardaAtualizado);
        return ResponseEntity.ok(guardaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerGuarda(@PathVariable Long id) {
        guardaService.removerGuarda(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/postos")
    public ResponseEntity<List<Posto>> buscarPostos() {
        List<Posto> postos = guardaService.buscarPostos();
        return ResponseEntity.ok(postos);
    }
}
