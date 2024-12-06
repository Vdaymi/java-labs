package org.example;

/**
 * Клас "Машинка".
 * Наслідує базовий клас Toy та додає властивість колір.
 */
class Car extends Toy {
    private final String color; // Колір машинки

    /**
     * Конструктор для створення машинки.
     * @param name назва
     * @param ageGroup вікова група
     * @param price ціна
     * @param color колір машинки
     */
    public Car(String name, int ageGroup, double price, String color) {
        super(name, ageGroup, price);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", Колір: " + color;
    }
}
