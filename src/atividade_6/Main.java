package atividade_6;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] sizes = {100, 500, 1000, 5000, 10000};
        Cabecalho.imprimir();

        System.out.println("--- Análise de Desempenho de Algoritmos de Ordenação em Java ---");
        System.out.println("Medidas em Milissegundos (ms).");

        System.out.println("\n| Tamanho  | Tipo de Lista  | Bubble Sort | Selection Sort | Insertion Sort | Merge Sort | Quick Sort |");
        System.out.println("|----------|----------------|-------------|----------------|----------------|------------|------------|");

        for (int size : sizes) {
            int[] randomArr = ArrayDataGenerator.generateRandomArray(size);
            int[] sortedArr = ArrayDataGenerator.generateSortedArray(size);
            int[] reverseArr = ArrayDataGenerator.generateReverseSortedArray(size);

            runBenchmark(size, "Aleatória", randomArr);
            runBenchmark(size, "Ordenada", sortedArr);
            runBenchmark(size, "Invertida", reverseArr);
        }

        System.out.println("\nAnálise de desempenho concluída!");
    }

    private static double timeSorter(int[] originalArray, Sorter sorter) {
        int[] arrCopy = Arrays.copyOf(originalArray, originalArray.length);

        long startTime = System.nanoTime();
        sorter.sort(arrCopy);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000.0;
    }

    @FunctionalInterface
    interface Sorter {
        void sort(int[] arr);
    }

    public static void runBenchmark(int size, String listType, int[] originalArray) {

        double bubbleTime = timeSorter(originalArray, arr -> SortingAlgorithms.bubbleSort(arr));
        double selectionTime = timeSorter(originalArray, arr -> SortingAlgorithms.selectionSort(arr));
        double insertionTime = timeSorter(originalArray, arr -> SortingAlgorithms.insertionSort(arr));
        double mergeTime = timeSorter(originalArray, arr -> SortingAlgorithms.mergeSort(arr));
        double quickTime = timeSorter(originalArray, arr -> SortingAlgorithms.quickSort(arr, 0, arr.length - 1));

        System.out.printf("| %-8d | %-14s | %-11.4f | %-14.4f | %-14.4f | %-10.4f | %-10.4f |\n",
                size, listType,
                bubbleTime,
                selectionTime,
                insertionTime,
                mergeTime,
                quickTime);
    }
}
