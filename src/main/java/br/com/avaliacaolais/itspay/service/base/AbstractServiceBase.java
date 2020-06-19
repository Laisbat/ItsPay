package br.com.avaliacaolais.itspay.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public abstract class AbstractServiceBase {

    @Autowired
    private MessageSource messageSource;

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }
}