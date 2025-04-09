package org.example.repository;

import com.opencsv.CSVWriter;
import org.example.entity.DataBovespa;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileRepository {

    public DataBovespa[] getDataBovespa() throws FileNotFoundException {
        DataBovespa[] data = new DataBovespa[1000];
        int index = 0;

        InputStream is = getClass().getClassLoader().getResourceAsStream("b3_stocks_1994_2020.csv");

        if (is == null) {
            throw new FileNotFoundException("Arquivo b3_stocks_1994_2020.csv não encontrado no classpath");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
        {
            br.readLine();
            String linha;
            while ((linha = br.readLine()) != null) {
                DataBovespa dado = parseLinhaParaDataBovespa(linha, index);
                if (dado != null) {
                    if (index == data.length) {
                        data = aumentarCapacidade(data);
                    }
                    data[index] = dado;
                    index++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }


    private DataBovespa parseLinhaParaDataBovespa(String linha, int index) {
        String[] colunas = linha.split(",");

        if (colunas.length < 7) {
            return null;
        }

        try {
            // Converte a data para o formato desejado
            LocalDate dataOriginal = LocalDate.parse(colunas[0].trim());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String dataFormatadaStr = dataOriginal.format(formatter);

            String ticket = colunas[1].trim();
            double open = Double.parseDouble(colunas[2].trim());
            double close = Double.parseDouble(colunas[3].trim());
            double high = Double.parseDouble(colunas[4].trim());
            double low = Double.parseDouble(colunas[5].trim());
            double volume = Double.parseDouble(colunas[6].trim());


            return new DataBovespa(index, dataFormatadaStr, ticket, open, close, high, low, volume);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToFile(String outFileName, DataBovespa[] dataBovespa) {
        try {
            Path outputPath = Paths.get(outFileName);
            Path outputDir = outputPath.getParent();

            if (outputDir != null && !Files.exists(outputDir)) {
                Files.createDirectories(outputDir);
            }

            try (CSVWriter writer = new CSVWriter(new FileWriter(outFileName))) {
                String[] head = {"dataTime", "ticket", "open", "close", "high", "low", "volume"};
                writer.writeNext(head);
                for (DataBovespa c : dataBovespa) {
                    if (c != null) {
                        writer.writeNext(c.toCSV());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataBovespa[] getMaxVolumeRecordPerDay(String outfile, DataBovespa[] dados) throws FileNotFoundException {
        DataBovespa[] dataAux = new DataBovespa[dados.length];
        int index = 0;

        try{
            int i = 0;
            while (i < dados.length) {
                if (dados[i] == null) {
                    i++;
                    continue;
                }
                DataBovespa registroAtual = dados[i];
                DataBovespa maxRegistro = registroAtual; // inicializa com o primeiro registro do dia
                String dataAtual = registroAtual.getDateTime(); // pega a data corrente

                // Percorre todos os registros com a mesma data
                int j = i + 1;
                while (j < dados.length &&
                        dados[j] != null &&
                        dados[j].getDateTime() != null &&
                        dados[j].getDateTime().equals(dataAtual)) {

                    if (dados[j].getVolume() > maxRegistro.getVolume()) {
                        maxRegistro = dados[j];
                    }
                    j++;
                }
                dataAux[index++] = maxRegistro;
                i = j;
            }
            DataBovespa[] resultado = new DataBovespa[index];
            System.arraycopy(dataAux, 0, resultado, 0, index);

            writeToFile(outfile, resultado);

            return resultado;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public DataBovespa[] aumentarCapacidade(DataBovespa[] dateOrigin){
        DataBovespa[] novoArray = new DataBovespa[dateOrigin.length * 2];
        System.arraycopy(dateOrigin, 0, novoArray, 0, dateOrigin.length);
        return novoArray;
    }
}
