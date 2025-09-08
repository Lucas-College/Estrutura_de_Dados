package Atividade_2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ListTester {
    private static final int NUM_OPERACOES = 150000;

    public static Map<String, Long> runAllTestsAndCollectData(List<Integer> list) {
        // Usando LinkedHashMap para manter a ordem de inserção das operações
        Map<String, Long> results = new LinkedHashMap<>();

        results.put("Adicionar no FINAL", testarAdicaoNoFinal(list));
        results.put("Adicionar no INÍCIO", testarAdicaoNoInicio(list)); // Lista fica cheia
        results.put("Acesso Aleatório", testarAcessoAleatorio(list));
        results.put("Remover do FINAL", testarRemocaoDoFinal(list)); // Lista fica vazia

        repopularLista(list); // Repopula para o último teste
        results.put("Remover do INÍCIO", testarRemocaoDoInicio(list));

        return results;
    }

    private static void repopularLista(List<Integer> list) {
        list.clear();
        for (int i = 0; i < NUM_OPERACOES; i++) {
            list.add(i);
        }
    }

    // --- MÉTODOS DE TESTE MODIFICADOS PARA RETORNAR O TEMPO ---

    private static long testarAdicaoNoFinal(List<Integer> list) {
        list.clear();
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_OPERACOES; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    private static long testarAdicaoNoInicio(List<Integer> list) {
        list.clear();
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_OPERACOES; i++) {
            list.add(0, i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    private static long testarAcessoAleatorio(List<Integer> list) {
        if (list.isEmpty()) return -1; // Retorna -1 se não puder rodar

        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_OPERACOES; i++) {
            list.get(random.nextInt(list.size()));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    private static long testarRemocaoDoInicio(List<Integer> list) {
        if (list.isEmpty()) return -1;

        long startTime = System.nanoTime();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.remove(0);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    private static long testarRemocaoDoFinal(List<Integer> list) {
        if (list.isEmpty()) return -1;

        long startTime = System.nanoTime();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.remove(list.size() - 1);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }
}