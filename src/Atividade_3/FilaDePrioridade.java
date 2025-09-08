package Atividade_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FilaDePrioridade<T> {

    private final List<T> lista;
    private final Comparator<T> comparator;

    public FilaDePrioridade() {
        this.lista = new ArrayList<>();
        this.comparator = null;
    }

    public FilaDePrioridade(Comparator<T> comparator) {
        this.lista = new ArrayList<>();
        this.comparator = comparator;
    }

    public void enfileirar(T elemento) {
        int n = lista.size();
        for (int i = 0; i < n; i++) {
            T atual = lista.get(i);
            if (comparar(elemento, atual) > 0) { // elemento tem prioridade MAIOR -> entra antes
                lista.add(i, elemento);
                return;
            }
        }
        lista.add(elemento); // se não achou posição, é o menor => vai ao final
    }

    public T desenfileirar() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        return lista.remove(0); // primeiro é o de maior prioridade
    }

    public T espiar() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        return lista.get(0);
    }

    public boolean estaVazia() {
        return lista.isEmpty();
    }

    public int tamanho() {
        return lista.size();
    }

    private int comparar(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        }
        if (a instanceof Comparable) {
            @SuppressWarnings("unchecked")
            Comparable<? super T> ca = (Comparable<? super T>) a;
            return ca.compareTo(b);
        }
        throw new IllegalStateException("Elementos não comparáveis e nenhum Comparator fornecido");
    }
}
