package br.com.fullstack.moduloumsemanaonze.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadernoRequest {

    @NotNull
    private Long cadernoId;

    @NotNull
    private Long usuarioId;

    @NotNull
    private String nome;
}
