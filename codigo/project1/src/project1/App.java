package project1;

import java.util.Scanner;

public class App {
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
            }
            exibirMenu();
            opcaoMenu = leitor.nextInt();
        }

    }

    private static void executaOpcaoMenu(int opcaoMenu) throws Exception {
        Scanner leitor = new Scanner(System.in);
        Produto produto;
        String desc;
        int qntTotalAdquirido;
        double precoCusto;
        double margemLucro;
        produto = new Produto("Banana Doce", 100, 2, 50);
        switch (opcaoMenu) {
            case 1:
                System.out.println("Por gentileza, digite a descricao do produto:");
                desc = leitor.nextLine();
                System.out.println("Agora digite o total adquirido do produto:");
                qntTotalAdquirido = leitor.nextInt();
                System.out.println("O preco de custo do produto:");
                precoCusto = leitor.nextDouble();
                System.out.println("E por fim a margem de lucro: ");
                margemLucro = leitor.nextDouble();
                System.out.println("Criando produto!");
                mercearia.adicionarProduto(desc, precoCusto, margemLucro, qntTotalAdquirido);
                break;
            case 2:
            	listarProdutos();

                System.out.println("Digite qual produto esta sendo vendido: ");
                String descricaoProduto = leitor.nextLine();

                System.out.println("Digite a quantidade: ");
                int quantidade = leitor.nextInt();

                mercearia.vender(descricaoProduto, quantidade);

                break;
            case 3:
            	produto.efetuarCompra(6);

                break;
            case 4:
                //Consultar dados de um produto especifico.
            	listarProdutos();
            	System.out.println("Digite qual produto sera consultado: ");
            	String prodCons = leitor.nextLine();
            	System.out.println(mercearia.receberInfosProduto(prodCons));
                break;
            case 5:
                //5) Consultar todos os produtos.
            	listarProdutos();
                break;
            case 6:
                //6) Exibir balanço da empresa (valor do estoque atual, valor vendido e gasto em pedidos de reposicao).
                break;
            case 7:
                //7) Remover produto da mercearia.
                listarProdutos();
            	System.out.println("Digite qual produto sera removido do estoque: ");
                String prodRem = leitor.nextLine();
                mercearia.removerProduto(prodRem);                
                break;
            case 8:
                //8) Exibir quantidade total de produtos em estoque.
                break;
            case 9:
                //9) Listar produtos com estoque abaixo do mínimo.                
                break;
            case 10:
            	listarProdutos();
                break;
        }
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
        System.out.println("8) Exibir quantidade total de produtos em estoque.\n");
        System.out.println("9) Listar produtos com estoque abaixo do minimo.\n");
        System.out.println("10) Sair.\n");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Digite qual deseja executar: ");
    }
    
    public static void adicionarProdutos() {
    	Produto produto = new Produto("Banana Doce", 100, 2, 50);
    	Produto produto2 = new Produto("Duzia ovo", 20, 8, 35);
    	Produto produto3 = new Produto("Leite", 50, 1.5, 50);
    	mercearia.adicionarProduto(produto);
    	mercearia.adicionarProduto(produto2);
    	mercearia.adicionarProduto(produto3);
    }
    
    public static void listarProdutos() {
    	System.out.println("Produtos disponiveis na mercearia: ");
        System.out.println(mercearia.listarProdutos());
    }
}