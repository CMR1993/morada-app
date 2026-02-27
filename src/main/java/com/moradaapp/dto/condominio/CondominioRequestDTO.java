package com.moradaapp.dto.condominio;
import jakarta.validation.constraints.NotBlank;

public record CondominioRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "CNPJ é obrigatório")
        String cnpj,

        @NotBlank(message = "Endereço é obrigatório")
        String endereco
) {
}
