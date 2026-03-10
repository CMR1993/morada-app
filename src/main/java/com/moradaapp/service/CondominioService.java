package com.moradaapp.service;

import com.moradaapp.domain.Condominio;
import com.moradaapp.dto.condominio.CondominioRequestDTO;
import com.moradaapp.dto.condominio.CondominioResponseDTO;
import com.moradaapp.enums.StatusCondominio;
import com.moradaapp.repository.CondominioRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CondominioService {

    private final CondominioRepository repository;

    @Transactional
    public CondominioResponseDTO salvar(CondominioRequestDTO request) {

        Condominio condominio = new Condominio();

        condominio.setNome(request.nome());
        condominio.setCnpj(request.cnpj());
        condominio.setEndereco(request.endereco().toEntity());
        condominio.setDataCriacao(LocalDateTime.now());
        condominio.setStatus(StatusCondominio.ATIVO);

        repository.save(condominio);

        return new CondominioResponseDTO(
                condominio.getId(),
                condominio.getNome(),
                condominio.getCnpj(),
                condominio.getEndereco().toDTO(),
                condominio.getDataCriacao()
        );
    }
}
