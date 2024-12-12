package org.example;

/**
 * Клас "Лялька".
 * Наслідує базовий клас Toy та додає властивість матеріал.
 */
class Doll extends Toy {
    private final String material; // Матеріал ляльки

    /**
     * Конструктор для створення ляльки.
     * @param name назва
     * @param ageGroup вікова група
     * @param price ціна
     * @param material матеріал ляльки
     */
    public Doll(String name, int ageGroup, double price, String material) {
        super(name, ageGroup, price);
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + ", Матеріал: " + material;
    }
}
