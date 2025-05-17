package org.example.b3stocks.service;


import org.example.b3stocks.model.DataBovespa;
import org.example.b3stocks.sorting.*;
import org.example.b3stocks.transform.F1VolumeMaxFilter;
import org.example.b3stocks.transform.F2VolumeAboveAverage;
import org.example.b3stocks.util.ArrayUtils;
import org.example.b3stocks.util.CSVUtils;


import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class B3StocksProcessor {
    private static final String INPUT_FILE = "b3_stocks_1994_2020.csv";
    private static final String INPUT_FILE_T1 = "src\\main\\resources\\b3stocks_T1.csv";
    private static final String INPUT_FILE_F1 = "src\\main\\resources\\b3stocks_F1.csv";
    private static final String INPUT_FILE_AT1 = "src\\main\\resources\\b3stocks_AT1.csv";

    public void executarTodasTransformacoes() throws IOException {

        DataBovespa[] dados = CSVUtils.readFromCSV(INPUT_FILE);
        CSVUtils.writeToCSV(INPUT_FILE_T1, dados);

        DataBovespa[] dadosFiltradosF1 = F1VolumeMaxFilter.getMaxVolumeRecordPerDay(dados);
        CSVUtils.writeToCSV(INPUT_FILE_F1, dadosFiltradosF1);

        DataBovespa[] dadosFiltradosF2 = F2VolumeAboveAverage.getHigherValueDailyAverage(dados);
        CSVUtils.writeToCSV(INPUT_FILE_AT1, dadosFiltradosF2);
    }

    public void executandoInsertionSort() throws IOException {
        DataBovespa[] dados = CSVUtils.readFromCSV(INPUT_FILE);
        long tempoInicial;
        long tempoFinal;

        System.out.println("=============================================================================");
        System.out.println("Insertion Sort por Volume");

        // MÉDIO CASO
        InsertionSort sortVolumeMedio = new InsertionSort(dados);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumeMedio = sortVolumeMedio.insertionSortPorVolumeMedioCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Medio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources/b3stocks_volume_insertionSort_medioCaso.csv", resultadoVolumeMedio);

        // MELHOR CASO
        InsertionSort sortVolumeMelhor = new InsertionSort(dados);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumeMelhor = sortVolumeMelhor.insertionSortPorVolumeMelhorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_insertionSort_melhorCaso.csv", resultadoVolumeMelhor);

        // PIOR CASO
        InsertionSort sortVolumePior = new InsertionSort(dados);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumePior = sortVolumePior.insertionSortPorVolumePiorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_insertionSort_piorCaso.csv", resultadoVolumePior);

        System.out.println("=============================================================================");
        System.out.println("Insertion Sort por Ticker");

        InsertionSort sortTickerMedio = new InsertionSort(dados);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerMedio = sortTickerMedio.insertionSortPorTickerMedioCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Medio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_insertionSort_medioCaso.csv", resultadoTickerMedio);

        InsertionSort sortTickerMelhor = new InsertionSort(dados);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerMelhor = sortTickerMelhor.insertionSortPorTickerMelhorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_insertionSort_melhorCaso.csv", resultadoTickerMelhor);

        InsertionSort sortTickerPior = new InsertionSort(dados);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerPior = sortTickerPior.insertionSortPorTickerPiorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_insertionSort_piorCaso.csv", resultadoTickerPior);

        System.out.println("=============================================================================");
        System.out.println("Insertion Sort por Flutuação");

        InsertionSort sortFlutMedio = new InsertionSort(dados);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutMedio = sortFlutMedio.insertionSortPorFlutuacaoMedioCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Medio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_insertionSort_medioCaso.csv", resultadoFlutMedio);

        InsertionSort sortFlutMelhor = new InsertionSort(dados);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutMelhor = sortFlutMelhor.insertionSortPorFlutuacaoMelhorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_insertionSort_melhorCaso.csv", resultadoFlutMelhor);

        InsertionSort sortFlutPior = new InsertionSort(dados);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutPior = sortFlutPior.insertionSortPorFlutuacaoPiorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_insertionSort_piorCaso.csv", resultadoFlutPior);

        System.out.println("=============================================================================");
    }

    public void executandoSelectionSort() throws IOException {
        DataBovespa[] dados = CSVUtils.readFromCSV(INPUT_FILE);
        long tempoInicial;
        long tempoFinal;

        System.out.println("=============================================================================");
        System.out.println("Selection Sort por Volume");

        // MELHOR CASO (ordenado crescente)
        DataBovespa[] volumeOrdenado = Arrays.copyOf(dados, dados.length);
        Arrays.sort(volumeOrdenado, Comparator.comparingDouble(DataBovespa::getVolume));
        SelectionSort sortVolumeMelhor = new SelectionSort(volumeOrdenado);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumeMelhor = sortVolumeMelhor.selectionSortPorVolume();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_selectionSort_melhorCaso.csv", resultadoVolumeMelhor);

        // PIOR CASO (ordenado decrescente)
        DataBovespa[] volumeReverso = Arrays.copyOf(volumeOrdenado, volumeOrdenado.length);
        ArrayUtils.inverterArray(volumeReverso);
        SelectionSort sortVolumePior = new SelectionSort(volumeReverso);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumePior = sortVolumePior.selectionSortPorVolume();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_selectionSort_piorCaso.csv", resultadoVolumePior);

        // MÉDIO CASO (embaralhado)
        DataBovespa[] volumeMedio = ArrayUtils.embaralharArray(Arrays.copyOf(dados, dados.length));
        SelectionSort sortVolumeMedio = new SelectionSort(volumeMedio);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumeMedio = sortVolumeMedio.selectionSortPorVolume();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_selectionSort_medioCaso.csv", resultadoVolumeMedio);

        System.out.println("=============================================================================");
        System.out.println("Selection Sort por Ticker");

        DataBovespa[] tickerOrdenado = Arrays.copyOf(dados, dados.length);
        Arrays.sort(tickerOrdenado, Comparator.comparing(DataBovespa::getTicker));
        SelectionSort sortTickerMelhor = new SelectionSort(tickerOrdenado);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerMelhor = sortTickerMelhor.selectionSortPorTicker();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_selectionSort_melhorCaso.csv", resultadoTickerMelhor);

        DataBovespa[] tickerReverso = ArrayUtils.inverterArray(tickerOrdenado);
        SelectionSort sortTickerPior = new SelectionSort(tickerReverso);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerPior = sortTickerPior.selectionSortPorTicker();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_selectionSort_piorCaso.csv", resultadoTickerPior);

        DataBovespa[] tickerMedio = ArrayUtils.embaralharArray(Arrays.copyOf(dados, dados.length));
        SelectionSort sortTickerMedio = new SelectionSort(tickerMedio);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerMedio = sortTickerMedio.selectionSortPorTicker();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_selectionSort_medioCaso.csv", resultadoTickerMedio);

        System.out.println("=============================================================================");
        System.out.println("Selection Sort por Flutuação");

        DataBovespa[] flutOrdenado = Arrays.copyOf(dados, dados.length);
        Arrays.sort(flutOrdenado, Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
        SelectionSort sortFlutMelhor = new SelectionSort(flutOrdenado);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutMelhor = sortFlutMelhor.selectionSortPorFlutuacao();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_selectionSort_melhorCaso.csv", resultadoFlutMelhor);

        DataBovespa[] flutReverso = ArrayUtils.inverterArray(flutOrdenado);
        SelectionSort sortFlutPior = new SelectionSort(flutReverso);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutPior = sortFlutPior.selectionSortPorFlutuacao();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_selectionSort_piorCaso.csv", resultadoFlutPior);

        DataBovespa[] flutMedio = ArrayUtils.embaralharArray(Arrays.copyOf(dados, dados.length));
        SelectionSort sortFlutMedio = new SelectionSort(flutMedio);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutMedio = sortFlutMedio.selectionSortPorFlutuacao();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_selectionSort_medioCaso.csv", resultadoFlutMedio);

        System.out.println("=============================================================================");
    }


    public void executandoMergeSort() throws IOException {
        DataBovespa[] dados = CSVUtils.readFromCSV(INPUT_FILE);
        long tempoInicial;
        long tempoFinal;

        System.out.println("=============================================================================");
        System.out.println("Merge Sort por Volume");

        // MÉDIO CASO
        MergeSort mergeSortMedio = new MergeSort(dados);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumeMedio = mergeSortMedio.mergeSortPorVolume();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_mergeSort_medioCaso.csv", resultadoVolumeMedio);

        // MELHOR CASO
        MergeSort mergeSortMelhor = new MergeSort(resultadoVolumeMedio);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumeMelhor = mergeSortMelhor.mergeSortPorVolume();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_mergeSort_melhorCaso.csv", resultadoVolumeMelhor);

        // PIOR CASO
        DataBovespa[] volumeReverso = ArrayUtils.inverterArray(resultadoVolumeMedio);
        MergeSort mergeSortPior = new MergeSort(volumeReverso);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumePior = mergeSortPior.mergeSortPorVolume();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_mergeSort_piorCaso.csv", resultadoVolumePior);

        System.out.println("=============================================================================");
        System.out.println("Merge Sort por Ticker");

        // MÉDIO CASO
        MergeSort mergeSortTickerMedio = new MergeSort(dados);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerMedio = mergeSortTickerMedio.mergeSortPorTicker();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_mergeSort_medioCaso.csv", resultadoTickerMedio);

        // MELHOR CASO
        MergeSort mergeSortTickerMelhor = new MergeSort(resultadoTickerMedio);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerMelhor = mergeSortTickerMelhor.mergeSortPorTicker();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_mergeSort_melhorCaso.csv", resultadoTickerMelhor);

        // PIOR CASO
        DataBovespa[] tickerReverso = ArrayUtils.inverterArray(resultadoTickerMedio);
        MergeSort mergeSortTickerPior = new MergeSort(tickerReverso);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerPior = mergeSortTickerPior.mergeSortPorTicker();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_mergeSort_piorCaso.csv", resultadoTickerPior);

        System.out.println("=============================================================================");
        System.out.println("Merge Sort por Flutuação");

        // MÉDIO CASO
        MergeSort mergeSortFlutMedio = new MergeSort(dados);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutMedio = mergeSortFlutMedio.mergeSortPorFlutuacao();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_mergeSort_medioCaso.csv", resultadoFlutMedio);

        // MELHOR CASO
        MergeSort mergeSortFlutMelhor = new MergeSort(resultadoFlutMedio);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutMelhor = mergeSortFlutMelhor.mergeSortPorFlutuacao();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_mergeSort_melhorCaso.csv", resultadoFlutMelhor);

        // PIOR CASO
        DataBovespa[] flutReverso = ArrayUtils.inverterArray(resultadoFlutMedio);
        MergeSort mergeSortFlutPior = new MergeSort(flutReverso);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutPior = mergeSortFlutPior.mergeSortPorFlutuacao();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_mergeSort_piorCaso.csv", resultadoFlutPior);

        System.out.println("=============================================================================");
    }

    public void executandoQuickSort() throws IOException {
        DataBovespa[] dados = CSVUtils.readFromCSV(INPUT_FILE);
        long tempoInicial;
        long tempoFinal;

        System.out.println("=============================================================================");
        System.out.println("Quick Sort por Volume");

        // MELHOR CASO (ordenado crescente)
        DataBovespa[] volumeOrdenado = Arrays.copyOf(dados, dados.length);
        Arrays.sort(volumeOrdenado, Comparator.comparingDouble(DataBovespa::getVolume));
        QuickSort quickSortMelhorVolume = new QuickSort(volumeOrdenado);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumeMelhor = quickSortMelhorVolume.quickSortPorVolume();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_quickSort_melhorCaso.csv", resultadoVolumeMelhor);

        // PIOR CASO (ordenado decrescente)
        DataBovespa[] volumeInvertido = Arrays.copyOf(volumeOrdenado, volumeOrdenado.length);
        ArrayUtils.inverterArray(volumeInvertido);
        QuickSort quickSortPiorVolume = new QuickSort(volumeInvertido);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumePior = quickSortPiorVolume.quickSortPorVolume();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_quickSort_piorCaso.csv", resultadoVolumePior);

        // MÉDIO CASO (embaralhado)
        DataBovespa[] volumeMedio = ArrayUtils.embaralharArray(Arrays.copyOf(dados, dados.length));
        QuickSort quickSortMedioVolume = new QuickSort(volumeMedio);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumeMedio = quickSortMedioVolume.quickSortPorVolume();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_quickSort_medioCaso.csv", resultadoVolumeMedio);

        System.out.println("=============================================================================");
        System.out.println("Quick Sort por Ticker");

        // MELHOR CASO (ordenado alfabeticamente)
        DataBovespa[] tickerOrdenado = Arrays.copyOf(dados, dados.length);
        Arrays.sort(tickerOrdenado, Comparator.comparing(DataBovespa::getTicker));
        QuickSort quickSortMelhorTicker = new QuickSort(tickerOrdenado);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerMelhor = quickSortMelhorTicker.quickSortPorTicker();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_quickSort_melhorCaso.csv", resultadoTickerMelhor);

        // PIOR CASO (ordenado reverso)
        DataBovespa[] tickerInvertido = Arrays.copyOf(tickerOrdenado, tickerOrdenado.length);
        ArrayUtils.inverterArray(tickerInvertido);
        QuickSort quickSortPiorTicker = new QuickSort(tickerInvertido);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerPior = quickSortPiorTicker.quickSortPorTicker();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_quickSort_piorCaso.csv", resultadoTickerPior);

        // MÉDIO CASO (embaralhado)
        DataBovespa[] tickerMedio = ArrayUtils.embaralharArray(Arrays.copyOf(dados, dados.length));
        QuickSort quickSortMedioTicker = new QuickSort(tickerMedio);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerMedio = quickSortMedioTicker.quickSortPorTicker();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_quickSort_medioCaso.csv", resultadoTickerMedio);

        System.out.println("=============================================================================");
        System.out.println("Quick Sort por Flutuação");

        // MELHOR CASO (ordenado decrescente)
        DataBovespa[] flutOrdenado = Arrays.copyOf(dados, dados.length);
        Arrays.sort(flutOrdenado, Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
        QuickSort quickSortMelhorFlut = new QuickSort(flutOrdenado);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutMelhor = quickSortMelhorFlut.quickSortPorFlutuacao();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_quickSort_melhorCaso.csv", resultadoFlutMelhor);

        // PIOR CASO (ordenado crescente)
        DataBovespa[] flutInvertido = Arrays.copyOf(flutOrdenado, flutOrdenado.length);
        ArrayUtils.inverterArray(flutInvertido);
        QuickSort quickSortPiorFlut = new QuickSort(flutInvertido);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutPior = quickSortPiorFlut.quickSortPorFlutuacao();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_quickSort_piorCaso.csv", resultadoFlutPior);

        // MÉDIO CASO (embaralhado)
        DataBovespa[] flutMedio = ArrayUtils.embaralharArray(Arrays.copyOf(dados, dados.length));
        QuickSort quickSortMedioFlut = new QuickSort(flutMedio);
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutMedio = quickSortMedioFlut.quickSortPorFlutuacao();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_quickSort_medioCaso.csv", resultadoFlutMedio);

        System.out.println("=============================================================================");
    }

    public void executandoCountingSort() throws IOException {

            DataBovespa[] dados = CSVUtils.readFromCSV(INPUT_FILE);
            CountingSort countingSort = new CountingSort(dados);

            countingSort.gerarcountingSort(dados);


    }

    public void executandoHeapSort() throws IOException {
        DataBovespa[] dados = CSVUtils.readFromCSV(INPUT_FILE);
        long tempoInicial;
        long tempoFinal;

        System.out.println("=============================================================================");
        System.out.println("Heap Sort por Volume");

        HeapSort sortVolume = new HeapSort(dados);

        // MÉDIO
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumeMedio = sortVolume.heapSortPorVolumeMedioCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_heapSort_medioCaso.csv", resultadoVolumeMedio);

        // MELHOR
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumeMelhor = sortVolume.heapSortPorVolumeMelhorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_heapSort_melhorCaso.csv", resultadoVolumeMelhor);

        // PIOR
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumePior = sortVolume.heapSortPorVolumePiorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_heapSort_piorCaso.csv", resultadoVolumePior);

        System.out.println("=============================================================================");
        System.out.println("Heap Sort por Ticker");

        HeapSort sortTicker = new HeapSort(dados);

        // MÉDIO
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerMedio = sortTicker.heapSortPorTickerMedioCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_heapSort_medioCaso.csv", resultadoTickerMedio);

        // MELHOR
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerMelhor = sortTicker.heapSortPorTickerMelhorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_heapSort_melhorCaso.csv", resultadoTickerMelhor);

        // PIOR
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerPior = sortTicker.heapSortPorTickerPiorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_heapSort_piorCaso.csv", resultadoTickerPior);

        System.out.println("=============================================================================");
        System.out.println("Heap Sort por Flutuação");

        HeapSort sortFlut = new HeapSort(dados);

        // MÉDIO
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutMedio = sortFlut.heapSortPorFlutuacaoMedioCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_heapSort_medioCaso.csv", resultadoFlutMedio);

        // MELHOR
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutMelhor = sortFlut.heapSortPorFlutuacaoMelhorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_heapSort_melhorCaso.csv", resultadoFlutMelhor);

        // PIOR
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutPior = sortFlut.heapSortPorFlutuacaoPiorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_heapSort_piorCaso.csv", resultadoFlutPior);

        System.out.println("=============================================================================");
    }

    public void executandoQuickSortMediana() throws IOException {
        DataBovespa[] dados = CSVUtils.readFromCSV(INPUT_FILE);
        long tempoInicial;
        long tempoFinal;

        System.out.println("=============================================================================");
        System.out.println("QuickSort com Mediana de 3 por Volume");

        QuickSortMediana sortVolume = new QuickSortMediana(dados);

        // MELHOR CASO (ordenado)
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumeMelhor = sortVolume.quickSortPorVolumeMelhorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_quickSortMediana_melhorCaso.csv", resultadoVolumeMelhor);

        // PIOR CASO (ordenado reverso)
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumePior = sortVolume.quickSortPorVolumePiorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_quickSortMediana_piorCaso.csv", resultadoVolumePior);

        // MÉDIO CASO (embaralhado)
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoVolumeMedio = sortVolume.quickSortPorVolumeMedioCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_volume_quickSortMediana_medioCaso.csv", resultadoVolumeMedio);

        System.out.println("=============================================================================");
        System.out.println("QuickSort com Mediana de 3 por Ticker");

        QuickSortMediana sortTicker = new QuickSortMediana(dados);

        // MELHOR CASO
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerMelhor = sortTicker.quickSortPorTickerMelhorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_quickSortMediana_melhorCaso.csv", resultadoTickerMelhor);

        // PIOR CASO
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerPior = sortTicker.quickSortPorTickerPiorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_quickSortMediana_piorCaso.csv", resultadoTickerPior);

        // MÉDIO CASO
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoTickerMedio = sortTicker.quickSortPorTickerMedioCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_ticker_quickSortMediana_medioCaso.csv", resultadoTickerMedio);

        System.out.println("=============================================================================");
        System.out.println("QuickSort com Mediana de 3 por Flutuação");

        QuickSortMediana sortFlut = new QuickSortMediana(dados);

        // MELHOR CASO (ordenado do maior para o menor)
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutMelhor = sortFlut.quickSortPorFlutuacaoMelhorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Melhor caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_quickSortMediana_melhorCaso.csv", resultadoFlutMelhor);

        // PIOR CASO (ordenado do menor para o maior)
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutPior = sortFlut.quickSortPorFlutuacaoPiorCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Pior caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_quickSortMediana_piorCaso.csv", resultadoFlutPior);

        // MÉDIO CASO (embaralhado)
        tempoInicial = System.currentTimeMillis();
        DataBovespa[] resultadoFlutMedio = sortFlut.quickSortPorFlutuacaoMedioCaso();
        tempoFinal = System.currentTimeMillis();
        System.out.println("Executado o Médio caso em = " + (tempoFinal - tempoInicial) + " ms");
        CSVUtils.writeToCSV("src\\main\\resources\\b3stocks_flutuation_quickSortMediana_medioCaso.csv", resultadoFlutMedio);

        System.out.println("=============================================================================");
    }


}


