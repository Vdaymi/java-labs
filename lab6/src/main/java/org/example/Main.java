package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Порожній набір
        ToySet<Toy> emptySet = new ToySet<>();
        System.out.println("Порожній набір: " + emptySet.size());

        // Набір із одного елемента
        ToySet<Toy> singleSet = new ToySet<>(new Car("Машинка", 1, 15.5, "Червоний"));
        System.out.println("Набір з однієї машинки: " + singleSet.size());

        // Набір із колекції
        ToySet<Toy> collectionSet = new ToySet<>(Arrays.asList(
                new Doll("Лялька Барбі", 2, 20.0, "Пластик"),
                new Ball("М'яч", 3, 10.0, "Футбольний"),
                new Car("Вантажівка", 2, 18.0, "Чорний")
        ));
        System.out.println("Набір із колекції: " + collectionSet.size());

        // Додавання елементів
        collectionSet.add(new Cube("Кубик", 3, 5.0, "Дерево"));
        System.out.println("Після додавання: " + collectionSet.size());

        // Перевірка наявності елемента
        Toy exampleToy = collectionSet.get(2);
        boolean containsCar = collectionSet.contains(exampleToy);
        System.out.println("Колекція містить елемент " + exampleToy +"?: " + containsCar);

        // Видалення елемента
        collectionSet.deleteAtIndex(1); // Видаляємо елемент за індексом
        System.out.println("Після видалення елемента за індексом: " + collectionSet.size());

        // Очищення набору
        collectionSet.clear();
        System.out.println("Після очищення: " + collectionSet.size());
    }
}
