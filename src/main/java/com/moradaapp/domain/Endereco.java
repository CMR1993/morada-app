package com.moradaapp.domain;

import com.moradaapp.dto.condominio.EnderecoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String numero;

    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cep;

    public EnderecoDTO toDTO() {
        return new EnderecoDTO(
                logradouro,
                numero,
                complemento,
                bairro,
                cidade,
                estado,
                cep
        );
    }
}
