package org.example;

import org.example.b3stocks.service.B3StocksProcessor;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        B3StocksProcessor processor = new B3StocksProcessor();
        processor.executarTodasTransformacoes();

    }
}