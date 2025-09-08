package Atividade_2;

import java.util.*;

public class ListPerformanceLab {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====================ED-ATIVIDADE-02====================");
            System.out.println("==================Aluno: Lucas Silva===================");
            System.out.println("===================Professor: Rafael===================");
            System.out.println("=======================================================\n");
            System.out.println("=======Laboratório de Performance de Listas Java=======");
            System.out.println("1. Testar ArrayList");
            System.out.println("2. Testar LinkedList");
            System.out.println("3. Testar Vector");
            System.out.println("4. Testar Stack");
            System.out.println("5. Rodar todos e exibir tabela comparativa");
            System.out.println("0. Sair");
            System.out.print("Sua opção: ");

            int escolha;
            try {
                escolha = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, insira um número válido.");
                continue;
            }

            if (escolha == 0) {
                System.out.println("Encerrando o programa.");
                break;
            }

            // NOVA OPÇÃO
            if (escolha == 5) {
                runAllAndPrintTable();
                continue; // Volta para o menu
            }

            List<Integer> listaEscolhida = null;
            String nomeDaLista = "";

            switch (escolha) {
                case 1: listaEscolhida = new ArrayList<>(); nomeDaLista = "ArrayList"; break;
                case 2: listaEscolhida = new LinkedList<>(); nomeDaLista = "LinkedList"; break;
                case 3: listaEscolhida = new Vector<>(); nomeDaLista = "Vector"; break;
                case 4: listaEscolhida = new Stack<>(); nomeDaLista = "Stack"; break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;
            }

            System.out.println("\n--- Iniciando testes com " + nomeDaLista + " ---");
            // Coleta os dados e imprime na hora para as opções 1 a 4
            Map<String, Long> results = ListTester.runAllTestsAndCollectData(listaEscolhida);
            for (Map.Entry<String, Long> entry : results.entrySet()) {
                System.out.printf("%-20s: \t%,10d ms\n", entry.getKey(), entry.getValue());
            }
            System.out.println("--- Testes com " + nomeDaLista + " finalizados ---\n");
        }

        scanner.close();
    }


    private static void runAllAndPrintTable() {
        System.out.println("\nExecutando todos os testes... Isso pode levar alguns segundos.");

        Map<String, Map<String, Long>> allResults = new LinkedHashMap<>();

        allResults.put("ArrayList", ListTester.runAllTestsAndCollectData(new ArrayList<>()));
        System.out.println("ArrayList... concluído.");
        allResults.put("LinkedList", ListTester.runAllTestsAndCollectData(new LinkedList<>()));
        System.out.println("LinkedList... concluído.");
        allResults.put("Vector", ListTester.runAllTestsAndCollectData(new Vector<>()));
        System.out.println("Vector... concluído.");
        allResults.put("Stack", ListTester.runAllTestsAndCollectData(new Stack<>()));
        System.out.println("Stack... concluído.\n");

        System.out.printf("%-22s", "Operação");
        for (String listName : allResults.keySet()) {
            System.out.printf("%-18s", listName + " (ms)");
        }
        System.out.println();
        System.out.println("==========================================================================================");



        Set<String> operations = allResults.get("ArrayList").keySet();
        for (String opName : operations) {
            System.out.printf("%-22s", opName);
            for (String listName : allResults.keySet()) {
                System.out.printf("%,-18d", allResults.get(listName).get(opName));
            }
            System.out.println();
        }
    }
}

