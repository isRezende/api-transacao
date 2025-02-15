package com.isRezende.api_transacao.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.isRezende.api_transacao.controllers.dtos.TransacaoRequestDTO;
import com.isRezende.api_transacao.utils.TransacaoValidador;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();
    private final TransacaoValidador transacaoValidador;

    public void adicionarTransacao(TransacaoRequestDTO dtoTransacao) {
        log.info("Adicionando transação: {}", dtoTransacao);
        transacaoValidador.validadorTransacao(dtoTransacao);
        listaTransacoes.add(dtoTransacao);
        log.info("Transação adicionada: {}", dtoTransacao);
    }

    public void deletarTransacoes() {
        log.info("Deletando transações");
        listaTransacoes.clear();
        log.info("Transações deletadas com sucesso");
    }

    public List<TransacaoRequestDTO> listarTransacoes(Integer intervaloTempoBusca) {
        log.info("Iniciadas buscas de transações por tempo: {} " + intervaloTempoBusca);

        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloTempoBusca);

        log.info("Retorno de transações com sucesso");
        return listaTransacoes.stream()
                .filter(transacao -> transacao.dataHora()
                        .isAfter(dataHoraIntervalo))
                .toList();
    }

}
