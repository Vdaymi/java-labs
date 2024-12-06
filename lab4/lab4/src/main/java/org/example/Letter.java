package org.example;

// Клас для представлення окремої літери
class Letter {
    private final char value; // Значення літери

    // Конструктор ініціалізує літеру
    public Letter(char value) {
        this.value = value;
    }

    // Повертає значення літери
    public char getValue() {
        return value;
    }
}
