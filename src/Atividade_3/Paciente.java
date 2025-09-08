package Atividade_3;

public class Paciente implements Comparable<Paciente> {
    private String nome;
    private int gravidade;

    public Paciente(String nome, int gravidade) {
        this.nome = nome;
        this.gravidade = gravidade;
    }

    public String getNome() {
        return nome;
    }

    public int getGravidade() {
        return gravidade;
    }

    @Override
    public int compareTo(Paciente outro) {
        return Integer.compare(this.gravidade, outro.gravidade);
    }

    @Override
    public String toString() {
        return "Paciente{nome='" + nome + "', gravidade=" + gravidade + "}";
    }
}

