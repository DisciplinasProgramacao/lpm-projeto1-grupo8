package tests;

import org.junit.jupiter.api.Test;

import project1.Produto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ProdutoTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    Produto produtoInicial;

    @BeforeEach
    public void prepare() throws UnsupportedEncodingException{
        PrintStream novoFluxoDeImpressao = new PrintStream(output, true, "UTF-8");
        System.setOut(novoFluxoDeImpressao);

        produtoInicial = new Produto("Descrição", 10, 2, 30);
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
}