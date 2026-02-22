package com.moradaapp.domain;

import com.moradaapp.enums.StatusCondominio;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_condominios")
public class Condominio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String endereco;

    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "condominio")
    private List<Apartamento> apartamentos;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCondominio status;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }

}
