package com.lgfas.impeldown.controller;

import com.lgfas.impeldown.dto.AdministradorDto;
import com.lgfas.impeldown.model.enums.Cargo;
import com.lgfas.impeldown.service.AdministradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @PostMapping
    public ResponseEntity<AdministradorDto> cadastrarAdministrador(@RequestBody AdministradorDto administradorDto) {
        administradorService.cadastrarAdministrador(administradorDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDto> buscarAdministradorPorId(@PathVariable Long id) {
        AdministradorDto administradorDto = administradorService.buscarAdministradorPorId(id);
        return ResponseEntity.ok(administradorDto);
    }

    @GetMapping
    public ResponseEntity<List<AdministradorDto>> buscarAdministradores() {
        List<AdministradorDto> administradores = administradorService.buscarAdministradores();
        return ResponseEntity.ok(administradores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministradorDto> atualizarAdministrador(@PathVariable Long id, @RequestBody AdministradorDto administradorAtualizado) {
        AdministradorDto administradorDto = administradorService.atualizarAdministrador(id, administradorAtualizado);
        return ResponseEntity.ok(administradorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdministradorDto> removerAdministrador(@PathVariable Long id) {
        administradorService.removerAdministrador(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cargos")
    public ResponseEntity<List<Cargo>> buscarCargos() {
        List<Cargo> cargos = administradorService.buscarCargos();
        return ResponseEntity.ok(cargos);
    }
}
