package com.moradaapp.domain;

import com.moradaapp.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false, unique = true)
    String cpf;

    String email;
    String telefone;

    @Column(nullable = false)
    String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Role role;

    @ManyToOne
    @JoinColumn(name = "condominio_id")
    Condominio condominio;

    @Column(nullable = false)
    Boolean ativo;
}
