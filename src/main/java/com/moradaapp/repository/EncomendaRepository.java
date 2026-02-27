package com.moradaapp.repository;

import com.moradaapp.domain.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncomendaRepository extends JpaRepository <Encomenda, Long> {
}
