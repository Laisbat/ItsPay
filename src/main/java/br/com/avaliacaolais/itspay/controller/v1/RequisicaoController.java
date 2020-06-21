package br.com.avaliacaolais.itspay.controller.v1;

import br.com.avaliacaolais.itspay.service.RequisicaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/requisicao")
@Api("Serviços relacionados a requisição")
public class RequisicaoController {

    @Autowired
    RequisicaoService requisicaoService;

    @GetMapping("/{cpfUsuarioLogado}")
    @ApiOperation("Recuperar histórico de requisições")
    public void recuperarHistorico(@PathVariable final String cpfUsuarioLogado){

//        GregorianCalendar dataCal = new GregorianCalendar();
//        dataCal.setTime(data);
//        int mes = dataCal.get(Calendar.MONTH);
        requisicaoService.recuperarQuantidade(cpfUsuarioLogado);
    }

    //Será cobrado R$0.10 por cada requisição feita ao seu serviço.
    // Assim, deve ser disponibilizada uma maneira de verificar a quantidade e o custo das requisiçõesfeitas
    // em certo mês para cada cliente

//    public float calculaRequisicao( ){
//        quantidadeDeRequisicoes = ???
//        calculoRequisicao = quantidadeDeRequisicoes * 0,10;
//        return calculoRequisicao;
//    }
}
