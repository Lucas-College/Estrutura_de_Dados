package Atividade_3;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        FilaDePrioridade<Paciente> filaAtendimento = new FilaDePrioridade<>();

        System.out.println("---------------------------");
        System.out.println("--- ED-ATIVIDADE-03 -------");
        System.out.println("--- Aluno: Lucas Silva ----");
        System.out.println("--- Professor: Rafael -----");
        System.out.println("---------------------------");

        System.out.println("Cenário 1: Atendimento de Pacientes (Lista Ordenada)\n");

        filaAtendimento.enfileirar(new Paciente("Carlos", 3));
        filaAtendimento.enfileirar(new Paciente("Maria", 5));
        filaAtendimento.enfileirar(new Paciente("Ana", 8));
        filaAtendimento.enfileirar(new Paciente("Sofia", 10));

        System.out.println("Próximo paciente: " + filaAtendimento.espiar());
        while (!filaAtendimento.estaVazia()) {
            System.out.println("Atendendo: " + filaAtendimento.desenfileirar());
        }

        System.out.println("\nCenário 2: Tarefas (Comparator por prioridade)");
        Comparator<Tarefa> cmpTarefas = Comparator.comparingInt(Tarefa::getPrioridade);
        FilaDePrioridade<Tarefa> filaTarefas = new FilaDePrioridade<>(cmpTarefas);

        filaTarefas.enfileirar(new Tarefa("Responder e-mails", 2));
        filaTarefas.enfileirar(new Tarefa("Corrigir bug crítico", 10));
        filaTarefas.enfileirar(new Tarefa("Escrever documentação", 4));
        filaTarefas.enfileirar(new Tarefa("Reunião com cliente", 7));

        System.out.println("Próxima tarefa: " + filaTarefas.espiar());
        while (!filaTarefas.estaVazia()) {
            System.out.println("Executando: " + filaTarefas.desenfileirar());
        }
    }
}

