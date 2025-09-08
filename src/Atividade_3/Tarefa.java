package Atividade_3;

public class Tarefa {
    private final String descricao;
    private final int prioridade; // quanto maior, mais prioritária

    public Tarefa(String descricao, int prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public String toString() {
        return "Tarefa{descricao='" + descricao + "', prioridade=" + prioridade + "}";
    }
}

