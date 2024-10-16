package org.example;

public class Boat {
    // Перелічуваний тип для виду руху
    public enum MovementType {
        ROWING, SAILING, MOTOR, ROWING_SAILING, ROWING_SAILING_MOTOR
    }

    // Поля класу морського човна
    private final String name;
    private final double length;
    private final double weight;
    private final MovementType movementType;
    private final int maxSpeed;

    // Конструктор класу
    public Boat(String name, double length, double weight, MovementType movementType, int maxSpeed) {
        this.name = name;
        this.length = length;
        this.weight = weight;
        this.movementType = movementType;
        this.maxSpeed = maxSpeed;
    }

    // Геттери
    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    // Метод equals для порівняння об'єктів
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Boat boat = (Boat) obj;
        return Double.compare(boat.length, length) == 0 &&
                Double.compare(boat.weight, weight) == 0 &&
                maxSpeed == boat.maxSpeed &&
                movementType == boat.movementType &&
                name.equals(boat.name);
    }

    // Метод toString для отримання інформіції про об'єкт
    public String toString() {
        return "Човен: name='" + name + "', length=" + length + ", weight=" + weight +
                ", movementType=" + movementType + ", maxSpeed=" + maxSpeed;
    }
}