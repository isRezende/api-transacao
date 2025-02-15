package com.isRezende.api_transacao.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntity extends RuntimeException {
    public UnprocessableEntity(String mensagem) {
        super(mensagem);
    }

}
