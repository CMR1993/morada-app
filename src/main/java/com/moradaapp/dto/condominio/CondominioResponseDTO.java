package com.moradaapp.dto.condominio;

import java.time.LocalDateTime;

public record CondominioResponseDTO(

        Long id,
        String nome,
        String cnpj,
        String endereco,
        LocalDateTime dataCriacao
) {
}
