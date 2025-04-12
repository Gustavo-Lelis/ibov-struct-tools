package org.example.b3stocks.transform;

import org.example.b3stocks.model.DataBovespa;
import org.example.b3stocks.util.CSVUtils;

import java.io.FileNotFoundException;

public class F1VolumeMaxFilter {

    public static DataBovespa[] getMaxVolumeRecordPerDay(DataBovespa[] dados) throws FileNotFoundException {
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
            for (int j = 0; j < index; j++) {
                resultado[j] = dataAux[j];
            }
            return resultado;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
