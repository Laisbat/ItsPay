package br.com.avaliacaolais.itspay.controller.v1;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/requisicao")
@Api("Serviços relacionados a requisição")
public class RequisicaoController {

    //Será cobrado R$0.10 por cada requisição feita ao seu serviço.
    // Assim, deve ser disponibilizada uma maneira de verificar a quantidade e o custo das requisiçõesfeitas
    // em certo mês para cada cliente

//    public float calculaRequisicao( ){
//        quantidadeDeRequisicoes = ???
//        calculoRequisicao = quantidadeDeRequisicoes * 0,10;
//        return calculoRequisicao;
//    }
}
