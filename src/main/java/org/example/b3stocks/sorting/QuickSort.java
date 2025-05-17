package org.example.b3stocks.sorting;

import org.example.b3stocks.model.DataBovespa;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSort {
    private final DataBovespa[] vetor;

    public QuickSort(DataBovespa[] vetor){
        if(vetor == null){
            throw new IllegalArgumentException("Vetor não pode ser nulo");
        }
        this.vetor = vetor;
    }

    public DataBovespa[] ordenarPor(Comparator<DataBovespa> comparator) {
        DataBovespa[] copia = Arrays.copyOf(this.vetor, this.vetor.length);
        quickSort(copia, 0, copia.length - 1, comparator);
        return copia;
    }

    private void quickSort(DataBovespa[] array, int left, int right, Comparator<DataBovespa> comp) {
        while (left < right) {
            int pivotIndex = partition(array, left, right, comp);

            // Recursão na menor partição, iteração na maior
            if (pivotIndex - left < right - pivotIndex) {
                quickSort(array, left, pivotIndex - 1, comp);
                left = pivotIndex + 1;
            } else {
                quickSort(array, pivotIndex + 1, right, comp);
                right = pivotIndex - 1;
            }
        }
    }


    private int partition(DataBovespa[] array, int left, int right, Comparator<DataBovespa> comp) {
        DataBovespa pivot = array[right];  // usa o último como pivô (simples)
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (comp.compare(array[j], pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);  // coloca o pivô na posição correta
        return i + 1;
    }

    private void swap(DataBovespa[] array, int i, int j) {
        DataBovespa temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public DataBovespa[] quickSortPorVolume() {
        return ordenarPor(Comparator.comparingDouble(DataBovespa::getVolume));
    }
    public DataBovespa[] quickSortPorTicker() {
        return ordenarPor(Comparator.comparing(DataBovespa::getTicker));
    }
    public DataBovespa[] quickSortPorFlutuacao() {
        return ordenarPor(Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
    }

}
