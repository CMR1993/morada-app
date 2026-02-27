package com.moradaapp.dto.encomenda;

import java.time.LocalDateTime;

public record EncomendaResponseDTO(
        Long id,
        String descricao,
        String apartamento,
        String recebidoPor,
        String entreguePara,
        LocalDateTime dataRecebimento,
        LocalDateTime dataEntrega,
        String status
) {
}
