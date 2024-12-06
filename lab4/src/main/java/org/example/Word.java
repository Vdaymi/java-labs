package org.example;

// Клас для представлення слова, що складається з масиву літер
class Word {
    private final Letter[] letters; // Масив літер, що утворюють слово

    // Конструктор, що ініціалізує слово на основі рядка
    public Word(String word) {
        this.letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            this.letters[i] = new Letter(word.charAt(i));
        }
    }

    /**
     * Підраховує кількість входжень заданої літери в слові.
     *
     * @param targetChar літера для підрахунку
     * @return кількість входжень
     */
    public int countMatches(char targetChar) {
        int count = 0;
        for (Letter letter : letters) {
            if (letter.getValue() == targetChar) {
                count++;
            }
        }
        return count;
    }

    // Повертає текстове представлення слова
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getValue());
        }
        return word.toString();
    }
}
