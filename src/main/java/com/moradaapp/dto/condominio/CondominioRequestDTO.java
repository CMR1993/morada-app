package com.moradaapp.dto.condominio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CondominioRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "CNPJ é obrigatório")
        String cnpj,

        @NotNull(message = "Endereço é obrigatório")
        @Valid
        EnderecoDTO endereco
) {
}
