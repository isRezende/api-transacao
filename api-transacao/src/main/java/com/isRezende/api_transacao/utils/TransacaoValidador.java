package com.isRezende.api_transacao.utils;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Component;

import com.isRezende.api_transacao.controllers.dtos.TransacaoRequestDTO;
import com.isRezende.api_transacao.exceptions.UnprocessableEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TransacaoValidador {

    public void validadorTransacao(TransacaoRequestDTO dtoTransacao) {
        log.info("Validando transação: {}", dtoTransacao);
        validaDataTransacao(dtoTransacao.dataHora());
        validaValorTransacao(dtoTransacao.valor());
    }

    private static void validaValorTransacao(Double valor) {
        log.info("Validando valor da transação: {}", valor);
        if (valor < 0) {
            log.error("Valor da transação não pode ser menor que zero");
            throw new UnprocessableEntity("Valor não pode ser menor que zero");
        }

    }

    private static void validaDataTransacao(OffsetDateTime dataHora) {
        if (dataHora.isAfter(OffsetDateTime.now())) {
            log.error("Data e hora da transação não pode ser maior que a data e hora atuais");
            throw new UnprocessableEntity("Data e hora maiores que a data e hora atuais");

        }
    }

}
