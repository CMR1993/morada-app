package com.moradaapp.controller;

import com.moradaapp.dto.funcionario.FuncionarioRequestDTO;
import com.moradaapp.dto.funcionario.FuncionarioResponseDTO;
import com.moradaapp.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioResponseDTO> criar(
            @RequestBody @Valid FuncionarioRequestDTO request) {

        FuncionarioResponseDTO response = service.salvar(request);
        URI uri = URI.create("/funcionarios/" + response.id());

        return ResponseEntity.created(uri).body(response);
    }
}
