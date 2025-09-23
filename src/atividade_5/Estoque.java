package atividade_5;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private final Map<String, Produto> produtos = new HashMap<>();

    public void adicionarProduto(Produto produto) {
        String key = produto.getSku();
        if (produtos.containsKey(key)) {
            System.out.println("Erro: SKU já cadastrado (" + key + ")");
            return;
        }
        produtos.put(key, produto);
        System.out.println("Produto adicionado: " + key);
    }

    public Produto buscarProduto(String sku) {
        return produtos.get(sku);
    }

    public void atualizarQuantidade(String sku, int novaQuantidade) {
        if (novaQuantidade < 0) {
            System.out.println("Erro: quantidade não pode ser negativa.");
            return;
        }
        Produto p = produtos.get(sku);
        if (p == null) {
            System.out.println("Erro: produto não encontrado para SKU " + sku);
            return;
        }
        p.setQuantidadeEmEstoque(novaQuantidade);
        System.out.println("Quantidade atualizada para SKU " + sku + ": " + novaQuantidade);
    }

    public void removerProduto(String sku) {
        Produto removido = produtos.remove(sku);
        if (removido != null) {
            System.out.println("Produto removido: " + removido);
        } else {
            System.out.println("Erro: produto com SKU " + sku + " não encontrado.");
        }
    }

    public void listarTodosOsProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }
        for (Produto p : produtos.values()) {
            System.out.println(p);
        }
    }

    public void listarProdutosComEstoqueBaixo(int limite) {
        boolean encontrou = false;
        for (Produto p : produtos.values()) {
            if (p.getQuantidadeEmEstoque() <= limite) {
                System.out.println(p);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum produto com quantidade <= " + limite);
    }

    public double calcularValorTotalEstoque() {
        double total = 0.0;
        for (Produto p : produtos.values()) {
            total += p.getPreco() * p.getQuantidadeEmEstoque();
        }
        return total;
    }
}
