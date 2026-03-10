package com.moradaapp.controller;

import com.moradaapp.dto.condominio.CondominioRequestDTO;
import com.moradaapp.dto.condominio.CondominioResponseDTO;
import com.moradaapp.service.CondominioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/condominios")
@RequiredArgsConstructor
public class CondominioController {

    private final CondominioService service;

    @PostMapping
    public ResponseEntity<CondominioResponseDTO> criar(
            @RequestBody @Valid CondominioRequestDTO request) {

        CondominioResponseDTO response = service.salvar(request);
        URI uri = URI.create("/condominios/" + response.id());

        return ResponseEntity.created(uri).body(response);
    }
}
