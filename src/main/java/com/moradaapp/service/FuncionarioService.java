package com.moradaapp.service;

import com.moradaapp.domain.Condominio;
import com.moradaapp.domain.Funcionario;
import com.moradaapp.dto.funcionario.FuncionarioRequestDTO;
import com.moradaapp.dto.funcionario.FuncionarioResponseDTO;
import com.moradaapp.repository.CondominioRepository;
import com.moradaapp.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final CondominioRepository condominioRepository;

    public FuncionarioResponseDTO salvar(FuncionarioRequestDTO funcionarioRequest) {

        Condominio condominio = condominioRepository.findById(funcionarioRequest.condominioId())
                .orElseThrow(() -> new RuntimeException("Condomínio não encontrado"));

        Funcionario funcionario = new Funcionario();

        funcionario.setNome(funcionarioRequest.nome());
        funcionario.setCpf(funcionarioRequest.cpf());
        funcionario.setTelefone(funcionarioRequest.telefone());
        funcionario.setEmail(funcionarioRequest.email());
        funcionario.setCargo(funcionarioRequest.cargo());
        funcionario.setCondominio(condominio);
        funcionario.setAtivo(true);

        funcionarioRepository.save(funcionario);

        return new FuncionarioResponseDTO(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCpf(),
                funcionario.getTelefone(),
                funcionario.getEmail(),
                funcionario.getCargo().name(),
                funcionario.getCondominio().getNome()
        );
    }
}
