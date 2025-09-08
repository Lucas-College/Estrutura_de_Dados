package Atividade_1;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------");
        System.out.println("--- ED-ATIVIDADE-01 -------");
        System.out.println("--- Aluno: Lucas Silva ----");
        System.out.println("--- Professor: Rafael -----");
        System.out.println("---------------------------");

        ListaEncadeada<String> agenda = new ListaEncadeada<>();

        agenda.inserirNoInicio("Marcar reunião");
        agenda.inserirNoFim("Preparar apresentação");
        agenda.inserirNoInicio("Revisar e-mails");
        agenda.inserirNoFim("Enviar relatório");

        System.out.print("Estado da lista: ");
        agenda.exibir();

        System.out.println("Tamanho atual (O(1)): " + agenda.tamanho());

        System.out.println("\n--- Testando obterEm(indice) ---");
        try {
            System.out.println("Elemento no índice 0: " + agenda.obterEm(0));
            System.out.println("Elemento no índice 2: " + agenda.obterEm(2));
            System.out.println("Elemento no último índice (" + (agenda.tamanho() - 1) + "): " + agenda.obterEm(agenda.tamanho() - 1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n--- Testando Remoções ---");
        agenda.removerDoInicio();
        System.out.print("Após remover do início: ");
        agenda.exibir();

        System.out.println("Tamanho: " + agenda.tamanho());
        agenda.removerValor("Preparar apresentação");
        System.out.print("Após remover 'Preparar apresentação': ");
        agenda.exibir();

        System.out.println("Tamanho: " + agenda.tamanho());
        agenda.removerValor("Enviar relatório");
        System.out.print("Após remover o último elemento: ");
        agenda.exibir();

        System.out.println("Tamanho: " + agenda.tamanho());
    }
}