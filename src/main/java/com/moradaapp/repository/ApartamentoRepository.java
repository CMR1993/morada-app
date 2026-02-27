package com.moradaapp.repository;

import com.moradaapp.domain.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentoRepository extends JpaRepository <Apartamento, Long> {
}
