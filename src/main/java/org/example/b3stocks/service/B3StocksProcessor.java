package org.example.b3stocks.service;


import org.example.b3stocks.model.DataBovespa;
import org.example.b3stocks.transform.F1VolumeMaxFilter;
import org.example.b3stocks.transform.F2VolumeAboveAverage;
import org.example.b3stocks.util.CSVUtils;


import java.io.IOException;

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
}
