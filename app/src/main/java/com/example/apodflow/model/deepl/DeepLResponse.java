package com.example.apodflow.model.deepl;

import java.util.List;

public class DeepLResponse {

    private List<Translation> translations;

    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    public static class Translation {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }

}
