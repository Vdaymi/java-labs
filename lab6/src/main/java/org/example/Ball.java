package org.example;

/**
 * Клас "М'яч".
 * Наслідує базовий клас Toy та додає властивість тип м'яча.
 */
class Ball extends Toy {
    private final String type; // Тип м'яча (наприклад, футбольний, баскетбольний)

    /**
     * Конструктор для створення м'яча.
     * @param name назва
     * @param ageGroup вікова група
     * @param price ціна
     * @param type тип м'яча
     */
    public Ball(String name, int ageGroup, double price, String type) {
        super(name, ageGroup, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + ", Тип м'яча: " + type;
    }
}
