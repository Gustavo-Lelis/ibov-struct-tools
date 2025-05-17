package org.example.b3stocks.sorting;

import org.example.b3stocks.model.DataBovespa;

import java.util.Arrays;
import java.util.Comparator;

public class HeapSort {
    private final DataBovespa[] vector;

    public HeapSort(DataBovespa[] vector) {
        if (vector == null) {
            throw new IllegalArgumentException("Vetor não pode ser nulo");
        }
        this.vector = vector;
    }

    public DataBovespa[] ordenarPor(Comparator<DataBovespa> comparator) {
        DataBovespa[] copia = Arrays.copyOf(vector, vector.length);
        int n = copia.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(copia, n, i, comparator);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(copia, 0, i);
            heapify(copia, i, 0, comparator);
        }

        return copia;
    }

    private void heapify(DataBovespa[] array, int n, int i, Comparator<DataBovespa> comp) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comp.compare(array[left], array[largest]) > 0) {
            largest = left;
        }

        if (right < n && comp.compare(array[right], array[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest, comp);
        }
    }

    private void swap(DataBovespa[] array, int i, int j) {
        DataBovespa temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // ===== Volume =====
    public DataBovespa[] heapSortPorVolumeMedioCaso() {
        return ordenarPor(Comparator.comparingDouble(DataBovespa::getVolume));
    }

    public DataBovespa[] heapSortPorVolumeMelhorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vector, vector.length);
        Arrays.sort(ordenado, Comparator.comparingDouble(DataBovespa::getVolume));
        HeapSort sort = new HeapSort(ordenado);
        return sort.heapSortPorVolumeMedioCaso();
    }

    public DataBovespa[] heapSortPorVolumePiorCaso() {
        DataBovespa[] reverso = Arrays.copyOf(vector, vector.length);
        Arrays.sort(reverso, Comparator.comparingDouble(DataBovespa::getVolume).reversed());
        HeapSort sort = new HeapSort(reverso);
        return sort.heapSortPorVolumeMedioCaso();
    }

    // ===== Ticker =====
    public DataBovespa[] heapSortPorTickerMedioCaso() {
        return ordenarPor(Comparator.comparing(DataBovespa::getTicker));
    }

    public DataBovespa[] heapSortPorTickerMelhorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vector, vector.length);
        Arrays.sort(ordenado, Comparator.comparing(DataBovespa::getTicker));
        HeapSort sort = new HeapSort(ordenado);
        return sort.heapSortPorTickerMedioCaso();
    }

    public DataBovespa[] heapSortPorTickerPiorCaso() {
        DataBovespa[] reverso = Arrays.copyOf(vector, vector.length);
        Arrays.sort(reverso, Comparator.comparing(DataBovespa::getTicker).reversed());
        HeapSort sort = new HeapSort(reverso);
        return sort.heapSortPorTickerMedioCaso();
    }

    // ===== Flutuação =====
    public DataBovespa[] heapSortPorFlutuacaoMedioCaso() {
        return ordenarPor(Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
    }

    public DataBovespa[] heapSortPorFlutuacaoMelhorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vector, vector.length);
        Arrays.sort(ordenado, Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
        HeapSort sort = new HeapSort(ordenado);
        return sort.heapSortPorFlutuacaoMedioCaso();
    }

    public DataBovespa[] heapSortPorFlutuacaoPiorCaso() {
        DataBovespa[] reverso = Arrays.copyOf(vector, vector.length);
        Arrays.sort(reverso, Comparator.comparingDouble(DataBovespa::getFlutuacao));
        HeapSort sort = new HeapSort(reverso);
        return sort.heapSortPorFlutuacaoMedioCaso();
    }
}
