package com.isRezende.api_transacao.services;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

import com.isRezende.api_transacao.controllers.dtos.EstatisticasResponseDTO;
import com.isRezende.api_transacao.controllers.dtos.TransacaoRequestDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {

    private final TransacaoService transacaoService;

    public EstatisticasResponseDTO buscarEstatisticas(Integer intervaloTempoBusca) {
        log.info("Iniciando busca de estatísticas");
        List<TransacaoRequestDTO> listaTransacoes = transacaoService.listarTransacoes(intervaloTempoBusca);

        if (listaTransacoes.isEmpty()) {
            return new EstatisticasResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }
        DoubleSummaryStatistics estatisticas = listaTransacoes.stream()
                .map(TransacaoRequestDTO::valor)
                .mapToDouble(Double::doubleValue)
                .summaryStatistics();
        log.info("Estatísticas encontradas com sucesso");
        return new EstatisticasResponseDTO(estatisticas.getCount(), estatisticas.getSum(), estatisticas.getAverage(),
                estatisticas.getMax(), estatisticas.getMin());

    }
}
