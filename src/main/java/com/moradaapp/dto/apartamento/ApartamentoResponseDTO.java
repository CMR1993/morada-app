package com.moradaapp.dto.apartamento;

public record ApartamentoResponseDTO(

        Long id,
        String numero,
        String bloco,
        String condominio,
        String morador
) {
}
