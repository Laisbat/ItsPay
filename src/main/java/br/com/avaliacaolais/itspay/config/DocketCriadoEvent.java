package br.com.avaliacaolais.itspay.config;


import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import springfox.documentation.spring.web.plugins.Docket;

@Getter
public class DocketCriadoEvent extends ApplicationEvent {

    private final transient Docket docket;

    public DocketCriadoEvent(Object source, Docket docket) {
        super(source);
        this.docket = docket;
    }
}