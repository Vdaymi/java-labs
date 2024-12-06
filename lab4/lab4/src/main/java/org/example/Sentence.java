package org.example;

// Клас для представлення речення, що складається з масиву слів
class Sentence {
    private final Word[] words; // Масив слів у реченні

    // Конструктор, що розбиває рядок на слова
    public Sentence(String sentence) {
        // Замінюємо зайві пробіли одним пробілом
        String normalizedSentence = sentence.replaceAll("\\s+", " ");
        String[] wordStrings = normalizedSentence.split(" ");
        this.words = new Word[wordStrings.length];
        for (int i = 0; i < wordStrings.length; i++) {
            this.words[i] = new Word(wordStrings[i]);
        }
    }

    // Повертає масив слів у реченні
    public Word[] getWords() {
        return words;
    }

    // Повертає текстове представлення речення
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Word word : words) {
            sentence.append(word).append(" ");
        }
        return sentence.toString().trim();
    }
}
