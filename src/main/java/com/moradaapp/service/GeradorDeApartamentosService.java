package com.moradaapp.service;

import com.moradaapp.domain.Apartamento;
import com.moradaapp.domain.Condominio;
import com.moradaapp.domain.EstruturaCondominio;
import com.moradaapp.enums.TipoApartamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeradorDeApartamentosService {

    public List<Apartamento> gerarApartamentos(EstruturaCondominio estrutura, Condominio condominio) {

        List<Apartamento> apartamentos = new ArrayList<>();

        int blocos = estrutura.getBlocos();
        int andares = estrutura.getAndares();
        int apartamentosPorAndar = estrutura.getApartamentosPorAndar();

        // Gerar apartamentos regulares
        for (int bloco = 1; bloco <= blocos; bloco++) {
            for (int andar = 1; andar <= andares; andar++) {
                for (int apt = 1; apt <= apartamentosPorAndar; apt++) {
                    Apartamento apartamento = new Apartamento();
                    apartamento.setBloco("B" + bloco);
                    apartamento.setNumero(String.format("%d%02d", andar, apt));
                    apartamento.setTipo(TipoApartamento.REGULAR);
                    apartamento.setCondominio(condominio);
                    apartamentos.add(apartamento);
                }
            }
        }

        // Gerar gardens, se aplicável
        if (estrutura.isTemGarden()) {
            int gardensPorBloco = estrutura.getGardenPorBloco();
            for (int bloco = 1; bloco <= blocos; bloco++) {
                for (int g = 1; g <= gardensPorBloco; g++) {
                    Apartamento garden = new Apartamento();
                    garden.setBloco("B" + bloco);
                    garden.setNumero(String.format("%02d", g));
                    garden.setTipo(TipoApartamento.GARDEN);
                    garden.setCondominio(condominio);
                    apartamentos.add(garden);
                }
            }
        }

        // Gerar coberturas, se aplicável
        if (estrutura.isTemCobertura()) {
            int coberturasPorBloco = estrutura.getCoberturaPorBloco();
            for (int bloco = 1; bloco <= blocos; bloco++) {
                for (int c = 1; c <= coberturasPorBloco; c++) {
                    Apartamento cobertura = new Apartamento();
                    cobertura.setBloco("B" + bloco);
                    cobertura.setNumero(String.format("%02d", c));
                    cobertura.setTipo(TipoApartamento.COBERTURA);
                    cobertura.setCondominio(condominio);
                    apartamentos.add(cobertura);
                }
            }
        }

        return apartamentos;
    }
}
