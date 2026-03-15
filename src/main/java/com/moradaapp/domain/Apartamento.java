package com.moradaapp.domain;

import com.moradaapp.enums.TipoApartamento;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_apartamentos")
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String bloco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoApartamento tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condominio_id", nullable = false)
    private Condominio condominio;

    @OneToMany(mappedBy = "apartamento")
    private List<Usuario> moradores;
}
