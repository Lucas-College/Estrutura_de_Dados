package atividade_6;

import java.util.Arrays;

public class SortingAlgorithms {

    private static void swap(int[] arr, int index1, int index2) {
        int swapValue = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = swapValue;
    }

    public static void bubbleSort(int[] arr) {
        int arrayLength = arr.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void selectionSort(int[] arr) {
        int arrayLength = arr.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (arr[j] < arr[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            swap(arr, minimumIndex, i);
        }
    }

    public static void insertionSort(int[] arr) {
        int arrayLength = arr.length;
        for (int i = 1; i < arrayLength; ++i) {
            int currentElement = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > currentElement) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = currentElement;
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] leftArray = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArray = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(arr, leftArray, rightArray);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                arr[mergedIndex++] = left[leftIndex++];
            } else {
                arr[mergedIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            arr[mergedIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            arr[mergedIndex++] = right[rightIndex++];
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
}