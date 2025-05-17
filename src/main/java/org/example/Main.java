package org.example;

import org.example.b3stocks.service.B3StocksProcessor;
import java.io.IOException;
//classe bem feita
public class Main {
    public static void main(String[] args) throws IOException {
        B3StocksProcessor processor = new B3StocksProcessor();
        //processor.executarTodasTransformacoes();
        //processor.executandoMergeSort();
        //processor.executandoHeapSort();
        processor.executandoQuickSort();
        //processor.executandoSelectionSort();
        //processor.executandoQuickSortMediana();
        //processor.executandoInsertionSort();
        //processor.executandoCountingSort();
    }
}