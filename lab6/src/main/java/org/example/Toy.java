package org.example;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Якщо це той самий об'єкт
        if (obj == null || getClass() != obj.getClass()) return false;
        Toy toy = (Toy) obj;
        return ageGroup == toy.ageGroup &&
                Double.compare(toy.price, price) == 0 &&
                Objects.equals(name, toy.name);
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
