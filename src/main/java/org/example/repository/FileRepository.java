package org.example.repository;

import com.opencsv.CSVWriter;
import org.example.entity.DateBovespa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileRepository {

    public DateBovespa[] getDateBovespa(String fileName) throws FileNotFoundException {
        DateBovespa[] data = new DateBovespa[1000];
        int index = 0;

        InputStream is = getClass().getClassLoader().getResourceAsStream("b3_stocks_1994_2020.csv");

        if (is == null) {
            throw new FileNotFoundException("Arquivo b3_stocks_1994_2020.csv não encontrado no classpath");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
        {
            br.readLine(); // Pular o cabecalho
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] line = linha.split(",");
                if (line.length >= 7) {
                    try {
                        LocalDate dataFormatada = LocalDate.parse(line[0].trim());
                        //Formatar para o estilo desejado (dd-MM-yyyy)
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        String dataFormatadaStr = dataFormatada.format(formatter);

                        double open = Double.parseDouble(line[2].trim());
                        double close = Double.parseDouble(line[3].trim());
                        double high = Double.parseDouble(line[4].trim());
                        double low = Double.parseDouble(line[5].trim());
                        double volume = Double.parseDouble(line[6].trim());

                        if (index == data.length) {
                            data = aumentarCapacidade(data);
                        }

                        data[index] = new DateBovespa(index, dataFormatadaStr, line[1], open, close, high, low, volume);
                        index++;
                    } catch (NumberFormatException e) {
                        System.out.println(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public void writeToFile(String outFileName, DateBovespa[] dataBovespa) {
        try {
            Path outputPath = Paths.get(outFileName);
            Path outputDir = outputPath.getParent();

            if (outputDir != null && !Files.exists(outputDir)) {
                Files.createDirectories(outputDir);
            }

            try (CSVWriter writer = new CSVWriter(new FileWriter(outFileName))) {
                String[] head = {"dataTime", "ticket", "open", "close", "high", "low", "volume"};
                writer.writeNext(head);
                for (DateBovespa c : dataBovespa) {
                    if (c != null) {
                        writer.writeNext(c.toCSV());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public DateBovespa[] aumentarCapacidade(DateBovespa[] dateOrigin){
        DateBovespa[] novoArray = new DateBovespa[dateOrigin.length * 2];
        System.arraycopy(dateOrigin, 0, novoArray, 0, dateOrigin.length);
        return novoArray;
    }
}
