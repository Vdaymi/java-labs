package org.example;

/**
 * Абстрактний клас "Іграшка".
 * Описує базові властивості та методи іграшки.
 */
abstract class Toy {
    private final String name; // Назва іграшки
    private final int ageGroup; // Вікова група
    private final double price; // Ціна іграшки

    /**
     * Конструктор для створення іграшки.
     * @param name назва
     * @param ageGroup вікова група
     * @param price ціна
     * @throws IllegalArgumentException якщо ціна від'ємна
     */
    public Toy(String name, int ageGroup, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ціна іграшки не може бути від'ємною!");
        }
        this.name = name;
        this.ageGroup = ageGroup;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Іграшка: %s, Вікова група: %d, Ціна: %.2f", name, ageGroup, price);
    }
}
