package com.example.apodflow.utils;

import android.icu.text.SimpleDateFormat;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class ToolKit {

    private String apiKey = "izoRrxyHkhsOyStArzrV6bWRyNKrSjZx7EBFqycG";

    public ToolKit(){}

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String formatDate(String date) {

        // Verifica se a data possui o tamanho correto (8 caracteres)
        if (date.length() != 8) {
            return null; // Retorna null se o tamanho da data estiver incorreto
        }

        try {
            // Converte a entrada para um objeto Date usando o formato de entrada do usuário
            SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
            inputFormat.setLenient(false); // Desabilita a leniência para que datas inválidas não sejam aceitas
            Date dateObj = inputFormat.parse(date);

            if (dateObj == null) {
                return null; // Retorna null se a conversão falhar
            }

            // Converte para o formato desejado (yyyy-MM-dd)
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            return outputFormat.format(dateObj);

        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Retorna null em caso de erro (data inválida)
        }

    }

}
