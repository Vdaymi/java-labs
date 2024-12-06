package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Клас "Ігрова кімната".
 * Зберігає список іграшок та бюджет на їх придбання.
 */
class PlayRoom {
    private final List<Toy> toys; // Список іграшок
    private double budget; // Бюджет ігрової кімнати

    /**
     * Конструктор для створення ігрової кімнати.
     * @param budget початковий бюджет
     * @throws IllegalArgumentException якщо бюджет від'ємний
     */
    public PlayRoom(double budget) {
        if (budget < 0) {
            throw new IllegalArgumentException("Бюджет не може бути від'ємним!");
        }
        this.budget = budget;
        this.toys = new ArrayList<>();
    }

    /**
     * Додає іграшку до ігрової кімнати.
     * @param toy об'єкт іграшки
     * @throws IllegalArgumentException якщо ціна іграшки перевищує бюджет
     */
    public void addToy(Toy toy) {
        if (toy.getPrice() > budget) {
            throw new IllegalArgumentException("Недостатньо коштів для додавання іграшки: " + toy.getName());
        }
        toys.add(toy);
        budget -= toy.getPrice();
    }

    /**
     * Сортує іграшки за ціною у зростаючому порядку.
     * @return відсортований список іграшок
     */
    public List<Toy> sortToysByPrice() {
        return toys.stream()
                .sorted(Comparator.comparingDouble(Toy::getPrice))
                .collect(Collectors.toList());
    }

    /**
     * Знаходить іграшки в заданому ціновому діапазоні.
     * @param minPrice мінімальна ціна
     * @param maxPrice максимальна ціна
     * @return список іграшок у діапазоні
     */
    public List<Toy> findToysByPriceRange(double minPrice, double maxPrice) {
        return toys.stream()
                .filter(toy -> toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    /**
     * Виводить список усіх іграшок.
     */
    public void printToys() {
        if (toys.isEmpty()) {
            System.out.println("Ігрова кімната порожня!");
        } else {
            toys.forEach(System.out::println);
        }
    }
}
