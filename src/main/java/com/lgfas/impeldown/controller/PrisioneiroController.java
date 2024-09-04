package com.lgfas.impeldown.controller;

import com.lgfas.impeldown.dto.PrisioneiroDto;
import com.lgfas.impeldown.model.enums.NivelPerigo;
import com.lgfas.impeldown.model.enums.NivelSeguranca;
import com.lgfas.impeldown.service.PrisioneiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/prisioneiros")
public class PrisioneiroController {

    private final PrisioneiroService prisioneiroService;

    public PrisioneiroController(PrisioneiroService prisioneiroService) {
        this.prisioneiroService = prisioneiroService;
    }

    @PostMapping
    public ResponseEntity<PrisioneiroDto> cadastrarPrisioneiro(@RequestBody PrisioneiroDto prisioneiroDto) {
        prisioneiroService.cadastrarPrisioneiro(prisioneiroDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrisioneiroDto> buscarPrisioneiroPorId(@PathVariable Long id) {
        PrisioneiroDto prisioneiroDto = prisioneiroService.buscarPrisioneiroPorId(id);
        return ResponseEntity.ok(prisioneiroDto);
    }

    @GetMapping
    public ResponseEntity<List<PrisioneiroDto>> buscarPrisioneiros(
            @RequestParam(required = false, defaultValue = "1") int pagina,
            @RequestParam(required = false, defaultValue = "10") int tamanhoPagina) {

        List<PrisioneiroDto> prisioneiros = prisioneiroService.buscarPrisioneiros(pagina, tamanhoPagina);
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

    @GetMapping("/niveisPerigo")
    public ResponseEntity<List<NivelPerigo>> buscarNiveisPerigo() {
        List<NivelPerigo> nivelPerigos = prisioneiroService.buscarNiveisPerigo();
        return ResponseEntity.ok(nivelPerigos);
    }

    @GetMapping("/niveisSeguranca")
    public ResponseEntity<List<NivelSeguranca>> buscarNiveisSeguranca() {
        List<NivelSeguranca> nivelSegurancas = prisioneiroService.buscarNiveisSeguranca();
        return ResponseEntity.ok(nivelSegurancas);
    }
}
