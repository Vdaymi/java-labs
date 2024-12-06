package org.example;

// Головний клас програми
public class Main {
    public static void main(String[] args) {
        try {
            // Ініціалізація ігрової кімнати з певним бюджетом
            PlayRoom playRoom = new PlayRoom(100.0);

            // Додавання іграшок
            playRoom.addToy(new Car("Машина", 1, 15.5, "Червоний"));
            playRoom.addToy(new Doll("Лялька Барбі", 2, 20.0, "Пластик"));
            playRoom.addToy(new Ball("М'яч", 3, 10.0, "Футбольний"));
            playRoom.addToy(new Car("Вантажівка", 2, 18.0, "Чорний"));
            playRoom.addToy(new Cube("Кубик", 3, 5.0, "Дерево"));

            //Виведення усіх іграшок
            printAllToys(playRoom);

            //Виведення іграшок, відсортованих за ціною
            printSortedToysByPrice(playRoom);

            //Виведення іграшок в діапазоні ціни minPrice-maxPrice:
            int minPrice = 13 , maxPrice = 19;
            printToysByPriceRange(playRoom, minPrice, maxPrice);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    /**
     * Виводить усі іграшки з ігрової кімнати.
     * @param playRoom об'єкт ігрової кімнати
     */
    public static void printAllToys(PlayRoom playRoom){
        System.out.println("Усі іграшки:");
        playRoom.printToys();
    };

    /**
     * Виводить список іграшок, відсортованих за ціною.
     * @param playRoom об'єкт ігрової кімнати
     */
    public static void printSortedToysByPrice(PlayRoom playRoom){
        System.out.println("\nІграшки, відсортовані за ціною:");
        playRoom.sortToysByPrice().forEach(System.out::println);
    };

    /**
     * Виводить список іграшок у вказаному ціновому діапазоні.
     * @param playRoom об'єкт ігрової кімнати
     * @param minPrice мінімальна ціна
     * @param maxPrice максимальна ціна
     */
    public static void printToysByPriceRange(PlayRoom playRoom, int minPrice, int maxPrice){
        System.out.printf("\nІграшки в діапазоні ціни %d-%d:\n", minPrice ,maxPrice);
        playRoom.findToysByPriceRange(minPrice, maxPrice).forEach(System.out::println);
    };
}
