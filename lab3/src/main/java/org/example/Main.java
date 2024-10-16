/*
С11=3
Створити клас із виконавчим методом, в якому створити масив з об’єктів
класу (Визначити клас морський човен, який складається як мінімум з 5-и полів).
Відсортувати масив, за одним з полів за зростанням,
а за іншим — за спаданням, використовуючи при цьому стандартні засоби сортування ().
Після цього знайти в масиві об’єкт, який ідентичний заданому.
*/
package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        // Створення масиву човнів
        Boat[] boats = {
                new Boat("Sun Odyssey 410", 12.5, 10000, Boat.MovementType.SAILING, 18),
                new Boat("Buster L", 4.2, 400, Boat.MovementType.MOTOR, 40),
                new Boat("Чайка", 6.0, 150, Boat.MovementType.ROWING_SAILING, 15),
                new Boat("Bayliner VR5", 5.5, 800, Boat.MovementType.MOTOR, 50)
        };

        // Виклик методу для сортування човнів
        sortBoats(boats);

        // Задані човни для пошуку
        Boat searchBoat1 = new Boat("Чайка", 6.0, 150, Boat.MovementType.ROWING_SAILING, 15);
        Boat searchBoat2 = new Boat("Чайка", 10.0, 170, Boat.MovementType.ROWING_SAILING, 15);

        // Виклик методу для пошуку човна
        findBoat(boats, searchBoat1);
        findBoat(boats, searchBoat2);
    }

    // Метод для сортування масиву човнів за довжиною (зростання) і вагою (спадання)
    public static void sortBoats(Boat[] boats) {
        Arrays.sort(boats, Comparator.comparingDouble(Boat::getLength)
                .thenComparing(Comparator.comparingDouble(Boat::getWeight).reversed()));
        System.out.println("Відсортовані човни:");
        for (Boat boat : boats) {
            System.out.println(boat);
        }
    }

    // Метод для пошуку човна в масиві
    public static void findBoat(Boat[] boats, Boat searchBoat) {
        boolean found = false;
        for (Boat boat : boats) {
            if (boat.equals(searchBoat)) {
                found = true;
                System.out.println("Знайдено човен: " + boat);
                break;
            }
        }
        if (!found) {
            System.out.println("Човен не знайдено.");
        }
    }
}