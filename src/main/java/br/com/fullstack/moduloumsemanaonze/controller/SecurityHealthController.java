package br.com.fullstack.moduloumsemanaonze.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class SecurityHealthController {

    @GetMapping
    public ResponseEntity<?> testeSeguranca() {
        return ResponseEntity.ok("TESTE");
    }
}
