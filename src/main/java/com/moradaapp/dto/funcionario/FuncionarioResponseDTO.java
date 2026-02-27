package com.moradaapp.dto.funcionario;

public record FuncionarioResponseDTO(
        Long id,
        String nome,
        String cpf,
        String telefone,
        String email,
        String cargo,
        String condominio
) {
}
