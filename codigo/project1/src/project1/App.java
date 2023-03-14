package project1;

import java.util.Scanner;

public class App {
    static Mercearia mercearia = new Mercearia();
    
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);

        int opcaoMenu;

        exibirMenu();

        opcaoMenu = leitor.nextInt();
        while(opcaoMenu != 11) {
            if (opcaoMenu < 1 || opcaoMenu > 11) {
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
                System.out.println("Por gentileza, digite a descriçãÃ£o do produto:");
                desc = leitor.nextLine();
                System.out.println("Agora digite o total adquirido do produto:");
                qntTotalAdquirido = leitor.nextInt();
                System.out.println("O preç§o de custo do produto:");
                precoCusto = leitor.nextDouble();
                System.out.println("E por fim a margem de lucro: ");
                margemLucro = leitor.nextDouble();
                System.out.println("Criando produto!");
                mercearia.adicionarProduto(desc, precoCusto, margemLucro, qntTotalAdquirido);
                break;
            case 2:
                System.out.println("Produtos disponiveis na mercearia: ");
                System.out.println(mercearia.listarProdutos());

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
               mercearia.adicionarProduto(produto);
               System.out.println(produto.getDescricao());
                break;
            case 5:
                // mercearia.removerProduto(produto2);
                break;
            case 6:
                System.out.println(mercearia.receberQtdProdutosCadastradosEstoque()+ "\n" + mercearia.listarProdutos());
                break;
            case 7:

                System.out.println(mercearia.receberValorTotalEmEstoque());
                
                break;
            case 8:

                System.out.println(mercearia.receberNomesProdutosAbaixoMinimoEstoque());

                break;
            case 9:
                System.out.println("Digite a descricao do produto que deseja pesquisar: ");
                desc = leitor.nextLine();
                mercearia.receberProdutoPorDescricao(desc);
                
                break;
            case 10:
                // mercearia.receberProdutoPorID(produto.getID());

                break;
            case 11:
                break;
        }
    }

    public static void exibirMenu() {
        System.out.println("Bem vindo a Mercaria do Jhon Jhon");
        System.out.println("Abaixo temos opções de funcionamento da mercearia!");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1) Criar produtos novos no estoque.\n");
        System.out.println("2) Efetuar venda.\n");
        System.out.println("3) Efetuar compra de produtos para repor o estoque.\n");
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