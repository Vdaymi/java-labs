package org.example;

// Клас для представлення тексту, що складається з масиву речень
class Text {
    private final Sentence[] sentences; // Масив речень у тексті

    // Конструктор, що розбиває текст на речення
    public Text(String text) {
        // Розбиття тексту на речення за розділовими знаками
        String[] sentenceStrings = text.split("(?<=[.!?])\\s*");
        this.sentences = new Sentence[sentenceStrings.length];
        for (int i = 0; i < sentenceStrings.length; i++) {
            this.sentences[i] = new Sentence(sentenceStrings[i]);
        }
    }

    // Повертає масив речень у тексті
    public Sentence[] getSentences() {
        return sentences;
    }

    // Повертає текстове представлення тексту
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Sentence sentence : sentences) {
            text.append(sentence).append(" ");
        }
        return text.toString().trim();
    }
}
