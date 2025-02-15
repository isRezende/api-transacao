package com.isRezende.api_transacao.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isRezende.api_transacao.controllers.dtos.EstatisticasResponseDTO;
import com.isRezende.api_transacao.services.EstatisticasService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/estatisticas")
@RequiredArgsConstructor
public class EstatisticasController {

    private final EstatisticasService estatisticasService;

    @GetMapping
    @Operation(summary = "Endpoint Busca Estatísticas de Transações", description = "Busca estatísticas de transações de acordo com o intervalo de tempo informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estatísticas de transações retornadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Intervalo de tempo inválido"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<EstatisticasResponseDTO> buscarEstatisticas(
            @RequestParam(value = "intervaloTempoBusca", required = false, defaultValue = "60") Integer intervaloTempoBusca) {
        return ResponseEntity.ok(estatisticasService.buscarEstatisticas(intervaloTempoBusca));
    }
}
