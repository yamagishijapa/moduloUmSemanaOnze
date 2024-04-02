package br.com.fullstack.moduloumsemanaonze.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Caderno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Caderno(Usuario usuario, String nome) {
        this.usuario = usuario;
        this.nome = nome;
    }
}
