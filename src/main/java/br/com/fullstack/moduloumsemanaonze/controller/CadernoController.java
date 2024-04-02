package br.com.fullstack.moduloumsemanaonze.controller;

import br.com.fullstack.moduloumsemanaonze.model.Caderno;
import br.com.fullstack.moduloumsemanaonze.service.CadernoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caderno")
public class CadernoController {

    @Autowired
    private CadernoService cadernoService;

    @GetMapping
    public List<Caderno> listarCaderno() {
        return cadernoService.listarCaderno();
    }

    @GetMapping("/caderno-id/{cadernoId}")
    public ResponseEntity<?> buscarCadernoPorId(@PathVariable Long cadernoId) {
        return cadernoService.buscarCadernoPorId(cadernoId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return cadernoService.deletarCaderno(id);
    }

    @PutMapping("/{cadernoId}")
    public ResponseEntity<?> atualizarCaderno(@PathVariable Long cadernoId,
                                             @RequestParam(value = "nome", required = false) String nome) {
        return cadernoService.atualizarCaderno(cadernoId, nome);
    }
}
