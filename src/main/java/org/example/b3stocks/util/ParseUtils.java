package org.example.b3stocks.util;


import org.example.b3stocks.model.DataBovespa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParseUtils {
    public static DataBovespa parseLinha(String linha, int index) {
        String[] colunas = linha.split(",");
        if (colunas.length < 7) return null;

        try {
            LocalDate dataOriginal = LocalDate.parse(colunas[0].trim());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataFormatadaStr = dataOriginal.format(formatter);

            return new DataBovespa(
                    index,
                    dataFormatadaStr,
                    colunas[1].trim(),
                    Double.parseDouble(colunas[2].trim()),
                    Double.parseDouble(colunas[3].trim()),
                    Double.parseDouble(colunas[4].trim()),
                    Double.parseDouble(colunas[5].trim()),
                    Double.parseDouble(colunas[6].trim())
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
