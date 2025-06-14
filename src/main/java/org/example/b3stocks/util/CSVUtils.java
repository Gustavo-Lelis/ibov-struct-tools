package org.example.b3stocks.util;

import com.opencsv.CSVWriter;
import org.example.b3stocks.model.DataBovespa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class CSVUtils {

    public static DataBovespa[] readFromCSV(String resourceName) throws IOException {
        DataBovespa[] data = new DataBovespa[1000];
        int index = 0;

        InputStream is = CSVUtils.class.getClassLoader().getResourceAsStream(resourceName);

        if (is == null) {
            throw new FileNotFoundException("Arquivo " + resourceName + " não encontrado no classpath");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            br.readLine(); // Pula o cabeçalho
            String linha;
            while ((linha = br.readLine()) != null) {

                DataBovespa dado = ParseUtils.parseLinha(linha, index);
                if (dado != null) {
                    if (index == data.length) {
                        data = ArrayUtils.aumentarCapacidade(data);
                    }
                    data[index++] = dado;
                }
            }
        }

        return Arrays.copyOf(data, index);
    }

    public static void writeToCSV(String outFileName, DataBovespa[] dados) {
        writeToCSV(outFileName, Arrays.asList(dados)); // reaproveita o novo método
    }

    public static void writeToCSV(String outFileName, Iterable<DataBovespa> dados) {
        try {
            Path outputPath = Paths.get(outFileName);
            Files.createDirectories(outputPath.getParent());

            try (CSVWriter writer = new CSVWriter(new FileWriter(outFileName))) {
                writer.writeNext(new String[]{"dataTime", "ticket", "open", "close", "high", "low", "volume"});
                for (DataBovespa d : dados) {
                    if (d != null) {
                        writer.writeNext(d.toCSV());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
