package org.example;

/**
 * Клас "Кубик".
 * Наслідує базовий клас Toy та додає властивість матеріал.
 */
class Cube extends Toy {
    private final String material; // Матеріал кубика

    /**
     * Конструктор для створення кубика.
     * @param name назва
     * @param ageGroup вікова група
     * @param price ціна
     * @param material матеріал кубика
     */
    public Cube(String name, int ageGroup, double price, String material) {
        super(name, ageGroup, price);
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + ", Матеріал: " + material;
    }
}
