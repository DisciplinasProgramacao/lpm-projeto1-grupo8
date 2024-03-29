package project1;

import java.util.Scanner;

public class App {
    static Scanner leitor = new Scanner(System.in);
    static Produto produto;
    static String descricaoProduto;
    static int qntProduto;
    static double precoCusto;
    static double margemLucro;
    static Mercearia mercearia = new Mercearia();
    
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);

        int opcaoMenu;
        adicionarProdutos();
        exibirMenu();

        opcaoMenu = leitor.nextInt();
        while(opcaoMenu != 10) {
            if (opcaoMenu < 1 || opcaoMenu > 10) {
                System.out.println("Opcao invalida do Menu!");
            } else {
                executaOpcaoMenu(opcaoMenu);
                awaitMenu();
            }
            exibirMenu();
            opcaoMenu = leitor.nextInt();
        }
        System.out.println("Ate a proxima!");

    }

    private static void awaitMenu() {
        System.out.println("\n10) Voltar ao menu.\n");
        Scanner leitor = new Scanner(System.in);
        int opcaoMenu = leitor.nextInt();
        while (opcaoMenu != 10){
            opcaoMenu = leitor.nextInt();
        }
    }

    private static void executaOpcaoMenu(int opcaoMenu) throws Exception {
       
        produto = new Produto("Banana Doce", 100, 2, 50);
        switch (opcaoMenu) {
            case 1:
                criarProdutos();
                break;
            case 2:
            	listarProdutos();
                venderProduto();
                break;
            case 3:
                listarProdutos();
                comprarProduto();
                break;
            case 4:
            	listarProdutos();
                pesquisarProduto();
                break;
            case 5:
                mercearia.chamapercorrerListaEncadeada();
                break;
            case 6:
                exibirBalancoEmpresa();
                break;
            case 7:
                listarProdutos();
                removerProduto();
                break;
            case 8:
                System.out.println("Quantidade total de produtos distintos em estoque: " + mercearia.receberQtdProdutosCadastradosEstoque());
                break;
            case 9:
                System.out.println("Produtos com estoque abaixo do minimo: " + mercearia.receberNomesProdutosAbaixoMinimoEstoque());             
                break;
            case 10:
                break;
            default:
                break;
        }
    }

    private static void exibirBalancoEmpresa() {
        System.out.println("Valor do estoque atual: R$" + mercearia.receberValorTotalEmEstoque());
        System.out.println("Valor total vendido: R$" + mercearia.receberValorTotalVendido());
        System.out.println("Valor total gasto em pedidos de reposicao: R$" + mercearia.receberValorTotalReposicao());
    }

    private static void removerProduto() throws Exception {
        System.out.println("Digite qual produto sera removido do estoque: ");
        String prodRem = leitor.nextLine();
        mercearia.removerProduto(prodRem); 
    }

    private static void pesquisarProduto() throws Exception {
        System.out.println("Digite qual produto sera consultado: ");
        String prodCons = leitor.nextLine();
        System.out.println(mercearia.receberInfosProduto(prodCons));
    }

    private static void comprarProduto() {
        System.out.println("Digite qual produto esta sendo comprado: ");
        descricaoProduto = leitor.nextLine();

        System.out.println("Digite a quantidade: ");
        qntProduto = leitor.nextInt();

        mercearia.comprar(descricaoProduto, qntProduto);
    }

    private static void venderProduto() throws Exception {
        System.out.println("Digite qual produto esta sendo vendido: ");
        String descricaoProduto = leitor.nextLine();

        System.out.println("Digite a quantidade: ");
        int quantidade = leitor.nextInt();

        mercearia.vender(descricaoProduto, quantidade);

    }

    private static void criarProdutos() {
        System.out.println("Por gentileza, digite a descricao do produto:");
        descricaoProduto = leitor.nextLine();
        System.out.println("Agora digite o total adquirido do produto:");
        qntProduto = leitor.nextInt();
        System.out.println("O preco de custo do produto:");
        precoCusto = leitor.nextDouble();
        System.out.println("E por fim a margem de lucro: ");
        margemLucro = leitor.nextDouble();
        System.out.println("Criando produto!");
        mercearia.adicionarProduto(descricaoProduto, precoCusto, margemLucro, qntProduto);
    }

    public static void exibirMenu() {
        System.out.println("Bem vindo a Mercaria do Jhon Jhon");
        System.out.println("Abaixo temos opcoes de funcionamento da mercearia!");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1) Adicionar novos produtos a mercearia.\n");
        System.out.println("2) Vender produtos.\n");
        System.out.println("3) Efetuar compra de produtos para repor o estoque.\n");
        System.out.println("4) Consultar dados de um produto especifico.\n");
        System.out.println("5) Consultar todos os produtos.\n");
        System.out.println("6) Exibir balanço da empresa (valor do estoque atual, valor vendido e gasto em pedidos de reposicao).\n");    
        System.out.println("7) Remover produto da mercearia.\n");
        System.out.println("8) Exibir quantidade total de tipos de produtos no estoque.\n");
        System.out.println("9) Listar produtos com estoque abaixo do minimo.\n");
        System.out.println("10) Sair.\n");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Digite qual deseja executar: ");
    }
    
    public static void adicionarProdutos() {
    	Produto produto = new Produto("Banana Doce", 100, 2, 50);
    	Produto produto2 = new Produto("Ovo caipira", 20, 8, 35);
    	Produto produto3 = new Produto("Leite de cabra", 50, 1.5, 50);
    	mercearia.adicionarProduto(produto);
    	mercearia.adicionarProduto(produto2);
    	mercearia.adicionarProduto(produto3);
    }
    
    
    public static void listarProdutos() {
    	System.out.println("Produtos disponiveis na mercearia: ");
        System.out.println(mercearia.listarProdutos());
    }
}