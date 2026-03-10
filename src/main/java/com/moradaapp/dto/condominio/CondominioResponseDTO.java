package com.moradaapp.dto.condominio;

import com.moradaapp.domain.Endereco;
import java.time.LocalDateTime;

public record CondominioResponseDTO(

        Long id,
        String nome,
        String cnpj,
        EnderecoDTO endereco,
        LocalDateTime dataCriacao
) {
}
