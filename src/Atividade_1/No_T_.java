package Atividade_1;

class No<T> {
    T dado;
    No<T> proximo;
    public No(T dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

class ListaEncadeada<T> {
    No<T> inicio;
    private int tamanhoTotal = 0;

    public ListaEncadeada() {
        this.inicio = null;
    }

    public void inserirNoInicio(T dado) {
        No<T> novoNo = new No<>(dado);
        novoNo.proximo = this.inicio;
        this.inicio = novoNo;
    }

    public boolean buscar(T alvo) {
        No<T> atual = this.inicio;
        while (atual != null) {
            if (alvo.equals(atual.dado)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public void removerDuplicatasSimples() {
        No<T> noExterno = this.inicio;
        while (noExterno != null) {
            No<T> corredor = noExterno;
            while (corredor.proximo != null) {
                if (corredor.proximo.dado.equals(noExterno.dado)) {
                    corredor.proximo = corredor.proximo.proximo;
                } else {
                    corredor = corredor.proximo;
                }
            }
            noExterno = noExterno.proximo;
        }
    }

    public void exibir() {
        if (this.inicio == null) {
            System.out.println("Lista Vazia");
            return;
        }
        No<T> atual = this.inicio;
        StringBuilder sb = new StringBuilder();
        while (atual != null) {
            sb.append(String.valueOf(atual.dado)).append(" -> ");
            atual = atual.proximo;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

    public void inserirNoFinal(T dado) {
        No<T> novoNo = new No<>(dado);
        if (this.inicio == null) {
            this.inicio = novoNo;
            return;
        }
        No<T> atual = this.inicio;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public void removerDoInicio(){
        if (this.inicio != null) {
            this.inicio = this.inicio.proximo;
            this.tamanhoTotal--;
        }
    }

    public T obterEm(int indice){
        if (indice < 0 || indice >= tamanhoTotal) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        No<T> atual = this.inicio;
        int contador = 0;
        while (contador < indice) {
            atual = atual.proximo;
            contador++;
        }
        return atual.dado;
    }

    public void removerValor(T dado) {
        if (this.inicio == null) {
            return;
        }
        if (this.inicio.dado.equals(dado)) {
            this.inicio = this.inicio.proximo;
            this.tamanhoTotal--;
            return;
        }
        No<T> anterior = this.inicio;
        No<T> atual = this.inicio.proximo;
        while (atual != null && !atual.dado.equals(dado)) {
            anterior = atual;
            atual = atual.proximo;
        }
        if (atual != null) {
            anterior.proximo = atual.proximo;
            this.tamanhoTotal--;
        }
    }

    public void inserirNoFim(T dado) {
        No<T> novoNo = new No<>(dado);
        if (this.inicio == null) {
            this.inicio = novoNo;
        } else {
            No<T> atual = this.inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
        this.tamanhoTotal++;
    }

    public int tamanho() {
        return this.tamanhoTotal;
    }

}
