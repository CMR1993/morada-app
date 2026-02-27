package com.moradaapp.dto.usuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String cpf,
        String telefone,
        String email,
        String apartamento
) {
}
