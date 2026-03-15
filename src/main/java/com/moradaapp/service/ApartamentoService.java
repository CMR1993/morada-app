package com.moradaapp.service;

import com.moradaapp.domain.Apartamento;
import com.moradaapp.domain.Condominio;
import com.moradaapp.domain.EstruturaCondominio;
import com.moradaapp.dto.apartamento.GerarApartamentosRequestDTO;
import com.moradaapp.repository.ApartamentoRepository;
import com.moradaapp.repository.CondominioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartamentoService {

    private final ApartamentoRepository apartamentoRepository;
    private final CondominioRepository condominioRepository;
    private final GeradorDeApartamentosService geradorService;

    @Transactional
    public void gerarApartamentos(GerarApartamentosRequestDTO requestDTO) {
        Condominio condominio = condominioRepository.findById(requestDTO.condominioId())
                .orElseThrow(() -> new RuntimeException("Condomínio não encontrado"));

        // Deletar apartamentos existentes para regenerar
        apartamentoRepository.deleteByCondominioId(condominio.getId());

        // Criar estrutura temporária para geração
        EstruturaCondominio estrutura = new EstruturaCondominio();
        estrutura.setBlocos(requestDTO.blocos());
        estrutura.setAndares(requestDTO.andares());
        estrutura.setApartamentosPorAndar(requestDTO.apartamentosPorAndar());
        estrutura.setTemGarden(requestDTO.temGarden());
        estrutura.setGardenPorBloco(requestDTO.gardensPorBloco());
        estrutura.setTemCobertura(requestDTO.temCobertura());
        estrutura.setCoberturaPorBloco(requestDTO.coberturasPorBloco());

        List<Apartamento> apartamentos = geradorService.gerarApartamentos(estrutura, condominio);

        apartamentoRepository.saveAll(apartamentos);
    }

    @Transactional
    public int salvar(Condominio condominio, EstruturaCondominio estrutura) {
        List<Apartamento> apartamentos = geradorService.gerarApartamentos(estrutura, condominio);
        apartamentoRepository.saveAll(apartamentos);
        return apartamentos.size();
    }
}
