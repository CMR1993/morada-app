package com.moradaapp.dto.apartamento;

import com.moradaapp.domain.Condominio;
import com.moradaapp.domain.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ApartamentoRequestDTO(

        @NotBlank(message = "Número é obrigatório")
        String numero,

        @NotBlank(message = "Bloco é obrigatório")
        String bloco,

        @NotNull(message = "Condominio é obrigatório")
        Long condominioId,

        Long moradorId
) {
}
