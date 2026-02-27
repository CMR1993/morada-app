package com.moradaapp.domain;

import com.moradaapp.enums.StatusEncomenda;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_encomendas")
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apartamento_id", nullable = false)
    private Apartamento apartamento;

    @ManyToOne
    @JoinColumn(name = "recebido_por_id", nullable = false)
    private Funcionario recebidoPor;

    @ManyToOne
    @JoinColumn(name = "entregue_para_id", nullable = false)
    private Usuario entreguePara;

    private String descricao;

    private LocalDateTime dataEntrega;

    @Column(nullable = false)
    private LocalDateTime dataRecebimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEncomenda status;

    @Column(nullable = false)
    private String assinatura;
}
