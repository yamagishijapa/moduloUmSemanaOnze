package br.com.fullstack.moduloumsemanaonze.controller;

import br.com.fullstack.moduloumsemanaonze.model.Nota;
import br.com.fullstack.moduloumsemanaonze.request.NotaRequest;
import br.com.fullstack.moduloumsemanaonze.service.NotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping
    public List<Nota> listarNota() {
        return notaService.listarNota();
    }

    @GetMapping("/nota-id/{notaId}")
    public ResponseEntity<?> buscarNotaPorId(@PathVariable Long notaId) {
        return notaService.buscarNotaPorId(notaId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return notaService.deletarNota(id);
    }

    @PutMapping()
    public ResponseEntity<?> atualizarNota(@Valid @RequestBody NotaRequest notaRequest) {
        return notaService.atualizarNota(notaRequest);
    }
}
