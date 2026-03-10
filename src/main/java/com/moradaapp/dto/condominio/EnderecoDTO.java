package com.moradaapp.dto.condominio;

import com.moradaapp.domain.Endereco;
import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(

        @NotBlank(message = "Logradouro é obrigatório")
        String logradouro,

        @NotBlank(message = "Número é obrigatório")
        String numero,

        String complemento,

        @NotBlank(message = "Bairro é obrigatório")
        String bairro,

        @NotBlank(message = "Cidade é obrigatória")
        String cidade,

        @NotBlank(message = "Estado é obrigatório")
        String estado,

        @NotBlank(message = "CEP é obrigatório")
        String cep
) {
    public Endereco toEntity() {
        return new Endereco(
                logradouro,
                numero,
                complemento,
                bairro,
                cidade,
                estado,
                cep
        );
    }
}
