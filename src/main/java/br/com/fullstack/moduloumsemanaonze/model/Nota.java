package br.com.fullstack.moduloumsemanaonze.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String conteudo;
    @ManyToOne
    @JoinColumn(name = "caderno_id")
    private Caderno caderno;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
