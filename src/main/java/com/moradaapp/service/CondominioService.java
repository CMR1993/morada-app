package com.moradaapp.service;

import com.moradaapp.domain.Condominio;
import com.moradaapp.domain.EstruturaCondominio;
import com.moradaapp.dto.condominio.CondominioRequestDTO;
import com.moradaapp.dto.condominio.CondominioResponseDTO;
import com.moradaapp.enums.StatusCondominio;
import com.moradaapp.repository.CondominioRepository;
import com.moradaapp.repository.EstruturaCondominioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CondominioService {

    private final CondominioRepository condominioRepository;
    private final EstruturaCondominioRepository estruturaRepository;
    private final ApartamentoService apartamentoService;

    @Transactional
    public CondominioResponseDTO salvar(CondominioRequestDTO condominioRequest) {

        Condominio condominio = new Condominio();

        condominio.setNome(condominioRequest.nome());
        condominio.setCnpj(condominioRequest.cnpj());
        condominio.setEndereco(condominioRequest.endereco().toEntity());
        condominio.setDataCriacao(LocalDateTime.now());
        condominio.setStatus(StatusCondominio.ATIVO);

        condominioRepository.save(condominio);

        EstruturaCondominio estrutura = getEstruturaCondominio(condominioRequest, condominio);

        estruturaRepository.save(estrutura);

        int totalApartamentos = apartamentoService.salvar(condominio, estrutura);

        return new CondominioResponseDTO(
                condominio.getId(),
                condominio.getNome(),
                condominio.getCnpj(),
                condominio.getEndereco().toDTO(),
                condominio.getDataCriacao(),
                totalApartamentos
        );
    }

    private static EstruturaCondominio getEstruturaCondominio(CondominioRequestDTO condominioRequest, Condominio condominio) {
        EstruturaCondominio estrutura = new EstruturaCondominio();

        estrutura.setCondominio(condominio);
        estrutura.setBlocos(condominioRequest.estrutura().getBlocos());
        estrutura.setAndares(condominioRequest.estrutura().getAndares());
        estrutura.setApartamentosPorAndar(condominioRequest.estrutura().getApartamentosPorAndar());
        estrutura.setTemGarden(condominioRequest.estrutura().isTemGarden());
        estrutura.setGardenPorBloco(condominioRequest.estrutura().getGardenPorBloco());
        estrutura.setTemCobertura(condominioRequest.estrutura().isTemCobertura());
        estrutura.setCoberturaPorBloco(condominioRequest.estrutura().getCoberturaPorBloco());
        return estrutura;
    }
}
