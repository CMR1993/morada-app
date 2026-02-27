package com.moradaapp.dto.encomenda;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EncomendaRequestDTO(

        @NotBlank(message = "Descrição é obrigatória")
        String descricao,

        @NotNull(message = "Apartamento é obrigatório")
        Long apartamentoId,

        @NotNull(message = "Funcionário é obrigatório")
        Long recebidoPorId,

        @NotNull(message = "Morador é obrigatório")
        Long entregueParaId
) {
}
