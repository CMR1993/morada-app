package com.moradaapp.dto.condominio;

import com.moradaapp.domain.Apartamento;
import com.moradaapp.domain.Endereco;
import java.time.LocalDateTime;
import java.util.List;

public record CondominioResponseDTO(

        Long id,
        String nome,
        String cnpj,
        EnderecoDTO endereco,
        LocalDateTime dataCriacao,
        int totalApartamentos
) {
}
