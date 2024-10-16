/*
C3=1 C17=8
Створити клас який складається з виконавчого методу,
що виконує дію з текстовим рядком
(Відсортувати слова заданого тексту за зростанням
кількості в них заданої літери.)
використовуючи для цього тип даних String.

Задані значення змінюються в CONST_INPUT_TEXT та CONST_TARGET_CHAR
 */
package org.example;

public class Main {
    public static final String CONST_INPUT_TEXT = "Вилиці пиво килими";  // Константа для тексту
    public static final char CONST_TARGET_CHAR = 'и';  // Константа, за якою сортуємо текст

    public static void main(String[] args) {
        try {
            System.out.println("Заданий текст: " + CONST_INPUT_TEXT);
            System.out.println("Задана літера для сортування: " + CONST_TARGET_CHAR);

            String sortedText = sortWordsByCharCount(CONST_INPUT_TEXT, CONST_TARGET_CHAR);
            System.out.println("Відсортований текст: " + sortedText);
        } catch (Exception e) {
            System.out.println("Виникла помилка при обробці тексту: " + e.getMessage());
        }
    }

    public static String sortWordsByCharCount(String inputText, char targetChar) {
        if (inputText == null || inputText.isEmpty()) {
            throw new IllegalArgumentException("Текст не може бути порожнім.");
        }
        if (!Character.isLetter(targetChar)) {
            throw new IllegalArgumentException("Символ для сортування повинен бути літерою.");
        }

        String[] words = inputText.split("\\s+");

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - i - 1; j++) {
                if (countCharOccurrences(words[j], targetChar) > countCharOccurrences(words[j + 1], targetChar)) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }

        return String.join(" ", words);
    }

    public static int countCharOccurrences(String word, char targetChar) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c == targetChar) {
                count++;
            }
        }
        return count;
    }
}
