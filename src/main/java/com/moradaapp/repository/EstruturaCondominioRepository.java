package com.moradaapp.repository;

import com.moradaapp.domain.EstruturaCondominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstruturaCondominioRepository extends JpaRepository <EstruturaCondominio, Long> {
}
