package br.com.fullstack.moduloumsemanaonze.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotaRequest {

    @NotNull
    private Long notaId;

    private Long usuarioId;

    private Long cadernoId;

    private String titulo;

    private String conteudo;
}
