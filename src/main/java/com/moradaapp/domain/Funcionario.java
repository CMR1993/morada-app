package com.moradaapp.domain;

import com.moradaapp.enums.TipoFuncionario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String telefone;

    private String email;

    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "condominio_id", nullable = false)
    private Condominio condominio;

    private Boolean ativo;
}
