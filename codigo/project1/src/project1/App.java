package project1;

import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception{
        Scanner leitor = new Scanner(System.in);
        Produto produto;
        Produto produto2;
        Mercearia mercearia;

        exibirMenu();
        
        int opcaoMenu = leitor.nextInt();
        while(opcaoMenu != 11) {
            if (opcaoMenu < 1 || opcaoMenu > 11){
                System.out.println("Opcao invalida do Menu!");
            }else{
                executaOpcaoMenu(opcaoMenu);
            }
            exibirMenu();
        }
        
    }

    private static void executaOpcaoMenu(int opcaoMenu) throws Exception {
        Scanner leitor = new Scanner(System.in);
        Produto produto;
        String desc;
        int qntTotalAdquirido;
        double precoCusto;
        double margemLucro;
        Mercearia mercearia = new Mercearia();

        produto = new Produto("banana doce", 23, 9.50, 66);
        mercearia.adicionarProduto(produto);

        switch (opcaoMenu) {
            case 1:

                System.out.println("Por gentileza digitar descrição do produto:");
                desc = leitor.nextLine();
                System.out.println("Agora digite o total adquirido do produto:");
                qntTotalAdquirido = leitor.nextInt();
                System.out.println("o preço de custo do produto:");
                precoCusto = leitor.nextDouble();
                System.out.println("e por fim a margem de custo");
                margemLucro = leitor.nextDouble();
                System.out.println("Criando produto! ");
                produto = new Produto(desc, qntTotalAdquirido, precoCusto, margemLucro);
                break;
            case 2:
                produto.efetuarVenda(5);
            
                break;
            case 3:
                produto.efetuarCompra(6);

                break;
            case 4:
                mercearia.adicionarProduto(produto.getDescricao(), 9.50, 66, produto.getQuantidadeEstoque());
                break;
            case 5:
                //mercearia.removerProduto(produto2);
                break;
            case 6:
                mercearia.receberQtdProdutosCadastradosEstoque();
                break;
            case 7:
                mercearia.receberValorTotalEmEstoque();

                break;
            case 8:
                mercearia.receberNomesProdutosAbaixoMinimoEstoque();

                break;    
            case 9:
                System.out.println("Digite a descricao do produto que deseja pesquisar: ");
                desc = leitor.nextLine();
                mercearia.receberProdutoPorDescricao(desc);

                break;
            case 10:
                //mercearia.receberProdutoPorID(produto.getID());

                break;
        }
    }

    public static void exibirMenu(){
        System.out.println("Bem vindo a Mercaria do Jhon Jhon");
        System.out.println("Abaixo temos opções de funcionamento da mercearia!");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1) Criar produto.\n");
        System.out.println("2) Efetuar venda.\n");
        System.out.println("3) Efetuar compra.\n");
        System.out.println("4) Adicionar produto a mercearia.\n");
        System.out.println("5) Remover produto da mercearia.\n");
        System.out.println("6) Quantidade produtos estoque.\n");
        System.out.println("7) Valor total do estoque.\n");
        System.out.println("8) Produtos abaixo do estoque.\n");
        System.out.println("9) Produtos por descricao.\n");
        System.out.println("10) Produtos por ID.\n");
        System.out.println("11) Sair.\n");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Digite qual deseja executar: ");
    }
}