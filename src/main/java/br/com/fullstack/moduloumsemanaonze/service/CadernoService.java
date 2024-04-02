package br.com.fullstack.moduloumsemanaonze.service;

import br.com.fullstack.moduloumsemanaonze.model.Caderno;
import br.com.fullstack.moduloumsemanaonze.repository.CadernoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadernoService {

    @Autowired
    private CadernoRepository cadernoRepository;

    public List<Caderno> listarCaderno(){
        return cadernoRepository.findAll();
    }
    public ResponseEntity<?> buscarCadernoPorId(Long cadernoId){
        if (!cadernoRepository.existsById(cadernoId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Caderno não encontrado com ID: " + cadernoId);
        }
        return ResponseEntity.ok(cadernoRepository.findById(cadernoId));
    }

    public ResponseEntity<?> deletarCaderno(Long id) {
        if(!cadernoRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O caderno com ID " + id + " não foi encontrado.");
        }

        cadernoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<?> atualizarCaderno(Long cadernoId, String nome) {
        if (!cadernoRepository.existsById(cadernoId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Caderno com ID " + cadernoId + " não encontrado.");
        }
        Optional<Caderno> caderno = cadernoRepository.findById(cadernoId);
        caderno.get().setNome(nome);

        cadernoRepository.save(caderno.get());

        return ResponseEntity.ok(cadernoRepository.findById(cadernoId));
    }
}
