package org.example.b3stocks.sorting;

import org.example.b3stocks.model.DataBovespa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class QuickSortMediana {
    private final DataBovespa[] vetor;
    private final Random random = new Random();

    public QuickSortMediana(DataBovespa[] vetor) {
        if (vetor == null) {
            throw new IllegalArgumentException("Vetor não pode ser nulo");
        }
        this.vetor = vetor;
    }


    public DataBovespa[] ordenarPor(Comparator<DataBovespa> comparator) {
        DataBovespa[] copia = Arrays.copyOf(this.vetor, this.vetor.length);
        quickSort(copia, 0, copia.length - 1, comparator);
        return copia;
    }

    // QuickSort com uso de mediana de três como pivô
    private void quickSort(DataBovespa[] array, int left, int right, Comparator<DataBovespa> comp) {
        if (left < right) {
            int pivotIndex = medianaDeTres(array, left, right, comp);
            swap(array, pivotIndex, right); // move o pivô para o final
            int partitionIndex = partition(array, left, right, comp);

            // Chamada recursiva balanceada
            quickSort(array, left, partitionIndex - 1, comp);
            quickSort(array, partitionIndex + 1, right, comp);
        }
    }

    // Mediana de três: retorna o índice da mediana entre left, mid e right
    private int medianaDeTres(DataBovespa[] array, int left, int right, Comparator<DataBovespa> comp) {
        int mid = (left + right) / 2;

        if (comp.compare(array[left], array[mid]) > 0) swap(array, left, mid);
        if (comp.compare(array[left], array[right]) > 0) swap(array, left, right);
        if (comp.compare(array[mid], array[right]) > 0) swap(array, mid, right);

        return mid; // o índice da mediana está no meio
    }

    private int partition(DataBovespa[] array, int left, int right, Comparator<DataBovespa> comp) {
        DataBovespa pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (comp.compare(array[j], pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private void swap(DataBovespa[] array, int i, int j) {
        DataBovespa temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private DataBovespa[] embaralharArray(DataBovespa[] array) {
        DataBovespa[] copia = Arrays.copyOf(array, array.length);
        for (int i = copia.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(copia, i, j);
        }
        return copia;
    }


    public DataBovespa[] quickSortPorVolumeMelhorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vetor, vetor.length);
        Arrays.sort(ordenado, Comparator.comparingDouble(DataBovespa::getVolume));
        return new QuickSortMediana(ordenado).ordenarPor(Comparator.comparingDouble(DataBovespa::getVolume));
    }

    public DataBovespa[] quickSortPorVolumePiorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vetor, vetor.length);
        Arrays.sort(ordenado, Comparator.comparingDouble(DataBovespa::getVolume).reversed());
        return new QuickSortMediana(ordenado).ordenarPor(Comparator.comparingDouble(DataBovespa::getVolume));
    }

    public DataBovespa[] quickSortPorVolumeMedioCaso() {
        DataBovespa[] embaralhado = embaralharArray(vetor);
        return new QuickSortMediana(embaralhado).ordenarPor(Comparator.comparingDouble(DataBovespa::getVolume));
    }


    public DataBovespa[] quickSortPorTickerMelhorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vetor, vetor.length);
        Arrays.sort(ordenado, Comparator.comparing(DataBovespa::getTicker));
        return new QuickSortMediana(ordenado).ordenarPor(Comparator.comparing(DataBovespa::getTicker));
    }

    public DataBovespa[] quickSortPorTickerPiorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vetor, vetor.length);
        Arrays.sort(ordenado, Comparator.comparing(DataBovespa::getTicker).reversed());
        return new QuickSortMediana(ordenado).ordenarPor(Comparator.comparing(DataBovespa::getTicker));
    }

    public DataBovespa[] quickSortPorTickerMedioCaso() {
        DataBovespa[] embaralhado = embaralharArray(vetor);
        return new QuickSortMediana(embaralhado).ordenarPor(Comparator.comparing(DataBovespa::getTicker));
    }


    public DataBovespa[] quickSortPorFlutuacaoMelhorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vetor, vetor.length);
        Arrays.sort(ordenado, Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
        return new QuickSortMediana(ordenado).ordenarPor(Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
    }

    public DataBovespa[] quickSortPorFlutuacaoPiorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vetor, vetor.length);
        Arrays.sort(ordenado, Comparator.comparingDouble(DataBovespa::getFlutuacao));
        return new QuickSortMediana(ordenado).ordenarPor(Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
    }

    public DataBovespa[] quickSortPorFlutuacaoMedioCaso() {
        DataBovespa[] embaralhado = embaralharArray(vetor);
        return new QuickSortMediana(embaralhado).ordenarPor(Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
    }
}
