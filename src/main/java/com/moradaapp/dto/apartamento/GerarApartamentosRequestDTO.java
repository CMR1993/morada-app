package com.moradaapp.dto.apartamento;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record GerarApartamentosRequestDTO(

        @NotNull
        Long condominioId,

        @Min(1)
        int blocos,

        @Min(1)
        int andares,

        @Min(1)
        int apartamentosPorAndar,

        boolean temGarden,

        @Min(1)
        int gardensPorBloco,

        boolean temCobertura,

        @Min(1)
        int coberturasPorBloco

) {
}
