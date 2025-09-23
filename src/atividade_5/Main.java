package atividade_5;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        Produto p1 = new Produto("CEL-001", "Smartphone X", 1500.00, 20);
        Produto p2 = new Produto("NTB-010", "Notebook Z", 4200.00, 8);
        Produto p3 = new Produto("FON-777", "Fone Pro", 299.90, 50);
        Produto p4 = new Produto("TV-050", "Smart TV 50\"", 2299.00, 5);

        estoque.adicionarProduto(p1);
        estoque.adicionarProduto(p2);
        estoque.adicionarProduto(p3);
        estoque.adicionarProduto(p4);
        estoque.adicionarProduto(new Produto("CEL-001", "Smartphone X 2", 1999.00, 10));

        estoque.listarTodosOsProdutos();

        System.out.println("\nBusca SKU 'NTB-010':");
        Produto buscado = estoque.buscarProduto("NTB-010");
        System.out.println(buscado != null ? buscado : "Não encontrado");

        System.out.println("\nBusca SKU inexistente 'AAA-000':");
        System.out.println(estoque.buscarProduto("AAA-000"));

        System.out.println("\nAtualizando quantidade do SKU 'TV-050' para 3");
        estoque.atualizarQuantidade("TV-050", 3);

        System.out.println("\nRemovendo SKU 'FON-777'");
        estoque.removerProduto("FON-777");

        System.out.println("\nProdutos com estoque baixo (<= 5):");
        estoque.listarProdutosComEstoqueBaixo(5);

        System.out.printf(Locale.US, "\nValor total do estoque: R$%.2f\n", estoque.calcularValorTotalEstoque());

        menuInterativo(estoque);
    }

    private static void menuInterativo(Estoque estoque) {
        while (true) {
            System.out.println("\n=== MENU ESTOQUE ===");
            System.out.println("1) Adicionar produto");
            System.out.println("2) Buscar produto por SKU");
            System.out.println("3) Atualizar quantidade");
            System.out.println("4) Remover produto");
            System.out.println("5) Listar todos os produtos");
            System.out.println("6) Listar produtos com estoque baixo");
            System.out.println("7) Valor total do estoque");
            System.out.println("0) Sair");
            System.out.print("Opção: ");

            String opcao = sc.nextLine().trim();
            switch (opcao) {
                case "1":
                    adicionarUI(estoque);
                    break;
                case "2":
                    System.out.print("SKU: ");
                    System.out.println(estoque.buscarProduto(sc.nextLine().trim()));
                    break;
                case "3":
                    System.out.print("SKU: ");
                    String skuU = sc.nextLine().trim();
                    System.out.print("Nova quantidade: ");
                    int q = leInteiro();
                    estoque.atualizarQuantidade(skuU, q);
                    break;
                case "4":
                    System.out.print("SKU: ");
                    estoque.removerProduto(sc.nextLine().trim());
                    break;
                case "5":
                    estoque.listarTodosOsProdutos();
                    break;
                case "6":
                    System.out.print("Limite (<=): ");
                    int lim = leInteiro();
                    estoque.listarProdutosComEstoqueBaixo(lim);
                    break;
                case "7":
                    System.out.printf(Locale.US, "Valor total: R$%.2f\n", estoque.calcularValorTotalEstoque());
                    break;
                case "0":
                    System.out.println("Encerrado.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarUI(Estoque estoque) {
        try {
            System.out.print("SKU: ");
            String sku = sc.nextLine().trim();
            System.out.print("Nome: ");
            String nome = sc.nextLine().trim();
            System.out.print("Preço (use ponto como separador decimal): ");
            double preco = leDouble();
            System.out.print("Quantidade: ");
            int qtd = leInteiro();
            estoque.adicionarProduto(new Produto(sku, nome, preco, qtd));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static int leInteiro() {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Tente novamente: ");
            }
        }
    }

    private static double leDouble() {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Tente novamente: ");
            }
        }
    }
}

