package project1;
public class App {
    public static void main(String[] args) throws Exception{
        Produto produto;
        Produto produto2;
        Mercearia mercearia;

        produto = new Produto("banana doce", 23, 9.50, 66);
        produto2 = new Produto("maça azeda", 10, 10, 70);
        mercearia = new Mercearia();

        produto.efetuarVenda(5);
        produto.efetuarCompra(6);

        mercearia.adicionarProduto(produto.getDescricao(), 9.50, 66, produto.getQuantidadeEstoque());
        mercearia.adicionarProduto(produto2.getDescricao(), 10, 70, produto2.getQuantidadeEstoque());
        mercearia.receberQtdProdutosCadastradosEstoque();
        mercearia.removerProduto(produto2);
        mercearia.receberQtdProdutosCadastradosEstoque();
        mercearia.receberNomesProdutosAbaixoMinimoEstoque();
        mercearia.receberValorTotalEmEstoque();
        mercearia.receberProdutoPorID(produto.getID());
        mercearia.receberProdutoPorDescricao(produto.getDescricao());
         

    }
}