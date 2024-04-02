package br.com.fullstack.moduloumsemanaonze.service;

import br.com.fullstack.moduloumsemanaonze.model.Nota;
import br.com.fullstack.moduloumsemanaonze.model.Usuario;
import br.com.fullstack.moduloumsemanaonze.model.Caderno;
import br.com.fullstack.moduloumsemanaonze.repository.NotaRepository;
import br.com.fullstack.moduloumsemanaonze.repository.UsuarioRepository;
import br.com.fullstack.moduloumsemanaonze.repository.CadernoRepository;
import br.com.fullstack.moduloumsemanaonze.request.NotaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> listarNota(){
        return notaRepository.findAll();
    }

    public ResponseEntity<?> buscarNotaPorId(Long notaId){
        if (!notaRepository.existsById(notaId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nota não encontrada com ID: " + notaId);
        }

        return ResponseEntity.ok(notaRepository.findById(notaId));
    }

    public ResponseEntity<?> deletarNota(Long id) {
        if(!notaRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A nota com ID " + id + " não foi encontrado.");
        }

        notaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<?> atualizarNota(NotaRequest notaRequest) {
        if(!notaRepository.existsById(notaRequest.getNotaId())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nota com ID " + notaRequest.getNotaId() + " não encontrado.");
        }

        Optional<Nota> nota = notaRepository.findById(notaRequest.getNotaId());
        if(notaRequest.getTitulo() != null){
            nota.get().setTitulo(notaRequest.getTitulo());
        }
        if(notaRequest.getConteudo() != null){
            nota.get().setTitulo(notaRequest.getConteudo());
        }

        notaRepository.save(nota.get());

        return ResponseEntity.ok(notaRepository.findById(notaRequest.getNotaId()));
    }
}
