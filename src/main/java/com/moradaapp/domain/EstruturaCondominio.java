package com.moradaapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstruturaCondominio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "condominio_id", nullable = false)
    private Condominio condominio;

    @Column(nullable = false)
    private int blocos;

    @Column(nullable = false)
    private int andares;

    @Column(nullable = false)
    private int apartamentosPorAndar;

    @Column(nullable = false)
    private boolean temGarden;

    @Column(nullable = false)
    private boolean temCobertura;

    @Column(nullable = false)
    private int gardenPorBloco;

    @Column(nullable = false)
    private int coberturaPorBloco;

}
