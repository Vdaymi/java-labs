package org.example;

// Головний клас, що виконує сортування тексту
public class Main {
    // Константа, що зберігає вхідний текст
    public static final String CONST_INPUT_TEXT = "Вилиці пиво килими";
    // Константа, що задає літеру для сортування
    public static final char CONST_TARGET_CHAR = 'и';

    public static void main(String[] args) {
        try {
            // Ініціалізація тексту
            Text text = new Text(CONST_INPUT_TEXT);
            System.out.println("Заданий текст: " + text);
            System.out.println("Задана літера для сортування: " + CONST_TARGET_CHAR);

            // Сортування тексту за кількістю входжень символа
            String sortedText = sortTextByCharCount(text, CONST_TARGET_CHAR);
            System.out.println("Відсортований текст: " + sortedText);
        } catch (Exception e) {
            // Обробка виключень, якщо виникла помилка
            System.out.println("Виникла помилка при обробці тексту: " + e.getMessage());
        }
    }

    /**
     * Сортує слова в тексті за кількістю входжень заданої літери.
     *
     * @param text       текст, який потрібно відсортувати
     * @param targetChar літера, за якою виконується сортування
     * @return відсортований текст
     */
    public static String sortTextByCharCount(Text text, char targetChar) {
        StringBuilder sortedText = new StringBuilder();

        // Проходимо по кожному реченню в тексті
        for (Sentence sentence : text.getSentences()) {
            Word[] words = sentence.getWords();

            // Сортування слів у реченні за кількістю входжень символа
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = 0; j < words.length - i - 1; j++) {
                    if (words[j].countMatches(targetChar) > words[j + 1].countMatches(targetChar)) {
                        Word temp = words[j];
                        words[j] = words[j + 1];
                        words[j + 1] = temp;
                    }
                }
            }

            // Додаємо відсортовані слова до результату
            for (Word word : words) {
                sortedText.append(word).append(" ");
            }
        }

        // Повертаємо результат як рядок
        return sortedText.toString().trim();
    }
}
