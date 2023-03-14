package project1.testes;

import org.junit.jupiter.api.Test;

import project1.Produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ProdutoTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    Produto produtoInicial;
    Produto produtoMargemLucroMinima, produtoMargemLucroMaxima;

    @BeforeEach
    public void prepare() throws UnsupportedEncodingException{
        PrintStream novoFluxoDeImpressao = new PrintStream(output, true, "UTF-8");
        System.setOut(novoFluxoDeImpressao);

         produtoInicial = new Produto("Descricao", 10, 10, 35);    
    }

    @AfterEach
    public void limparSaida()  {
        output.reset();
    }    

    @Test
    public void devePermitirDescricaoComMaisDeTresCaracteres(){
        produtoInicial.alterarDescricao("Maça");
        assertEquals(produtoInicial.getDescricao(), "Maça");
    }

    @Test
    public void deveExibirMensagemCasoDescricaoTenhaMenosDeTresCaracteres(){
        produtoInicial.alterarDescricao("a");
        assertEquals(output.toString(), "A descrição é obrigatória e deve possuir no mínimo 3 caracteres");
    }

    @Test
    public void deveCalcularPrecoVendaDeAcordoComMargemDeLucroInformada(){
        assertEquals(produtoInicial.calcularPrecoDeVendaUnitario(), 15.93);
    }
   
    @Test
    public void deveCalcularPrecoVendaComMargemDeLucroMinimaCasoValorSejaMenorQueTrinta(){
        produtoMargemLucroMinima = new Produto("Laranja", 10, 10, 10);    
        assertEquals(produtoMargemLucroMinima.calcularPrecoDeVendaUnitario(), 15.34);
    }

    @Test
    public void deveCalcularPrecoVendaComMargemDeLucroMinimaCasoValorSejaMaiorQueOitenta(){
        produtoMargemLucroMaxima = new Produto("Pitaya", 10, 10, 85);    
        assertEquals(produtoMargemLucroMaxima.calcularPrecoDeVendaUnitario(), 15.34);
    }

    @Test
    public void deveEfetuarVendaCasoPossuaItensNoEstoqueEQuantidadeInformadaSejaValida(){
        assertEquals(produtoInicial.efetuarVenda(9), 143.37);
    }

    @Test
    public void naoDeveEfetuarVendaCasoQuantidadeInformadaSejaMenorQueZero(){
        assertEquals(produtoInicial.efetuarVenda(-5), 0.0);
    }

    @Test
    public void naoDeveEfetuarVendaCasoQuantidadeEmEstoqueSejaInsuficiente(){
        assertEquals(produtoInicial.efetuarVenda(15), 0.0);
    }

    @Test
    public void deveRetornarValorTotalArrecadadoCorretoComVendas(){
        produtoInicial.efetuarVenda(2);
        produtoInicial.efetuarVenda(5);
        produtoInicial.efetuarVenda(1);
        assertEquals(produtoInicial.getValorVendaTotal(), 127.44);
    }

    @Test
    public void deveRetornarCorretamenteQuantidadeTotalDeProdutosVendidos(){
        produtoInicial.efetuarVenda(2);
        produtoInicial.efetuarVenda(5);
        produtoInicial.efetuarVenda(1);
        assertEquals(produtoInicial.getQuantidadeTotalVendas(), 8);
    }

    @Test
    public void deveEfetuarCompraCasoValorInformadoSejaValido(){
        assertEquals(produtoInicial.efetuarCompra(5), 50);
    }

    @Test
    public void naoDeveEfetuarCompraCasoQuantidadeInformadaSejaMenorQueZero(){
        assertEquals(produtoInicial.efetuarCompra(-1), 0.0);
    }

    //Valida o valor total arrecada com os produtos comprados, o valor dos 10 produtos de quando o produto foi comprado pela primeira vez + o valor das novas compras
    @Test
    public void deveRetornarValorTotalArrecadadoCorretoComCompras(){
        produtoInicial.efetuarCompra(2);
        produtoInicial.efetuarCompra(5);
        produtoInicial.efetuarCompra(1);
        assertEquals(produtoInicial.getValorTotalReposicao(), 180);
    }

    //Valida a quantidade total de produtos comprados, os 10 produtos de quando o produto foi comprado pela primeira vez, mais as novas quantidades
    @Test
    public void deveRetornarCorretamenteQuantidadeTotalDeProdutosComprados(){
        produtoInicial.efetuarCompra(2);
        produtoInicial.efetuarCompra(5);
        produtoInicial.efetuarCompra(1);
        assertEquals(produtoInicial.getQuantidadeTotalComprada(), 18);
    }

    @Test
    public void deveRetornarVerdadeiroCasoEstoqueAtualEstejaAbaixoDoMinimo(){
        produtoInicial.efetuarVenda(8);
        assertTrue(produtoInicial.estoqueAbaixoDoMinimo());
    }

    @Test
    public void deveRetornarFalsoCasoEstoqueAtualEstejaAcimaDoMinimo(){
        produtoInicial.efetuarVenda(8);
        produtoInicial.efetuarCompra(9);
        assertFalse(produtoInicial.estoqueAbaixoDoMinimo());
    }

    @Test
    public void deveListarInformacoesDoProduto(){
        String textoEsperado = "ID: "+ produtoInicial.getID() + "\nDescricao: Descricao\nQuantidade em estoque: 10\nQuantidade total comprada: 10\nQuantidade total vendida: 0\nValorTotalVendas: 0.0\nPreco custo: 10.0\nPreco venda: 15.93";
        assertEquals(textoEsperado, produtoInicial.listarInformacoesProduto());
    }
}
