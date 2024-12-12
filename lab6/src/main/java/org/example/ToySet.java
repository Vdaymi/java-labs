package org.example;

import java.util.*;

/**
 * Типізована колекція ToySet, що реалізує інтерфейс Set та використовує
 * внутрішню структуру на основі однозв’язного списку.
 * @param <T> узагальнений тип (має наслідувати Toy)
 */
public class ToySet<T extends Toy> {
    private Node<T> head; // Початок однозв’язного списку
    private int size;     // Кількість елементів у колекції

    /**
     * Внутрішній клас Node, що представляє вузол однозв’язного списку.
     * Зберігає дані та посилання на наступний елемент.
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    /**
     * Порожній конструктор.
     * Створює порожню колекцію.
     */
    public ToySet() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Конструктор, що приймає один об’єкт узагальненого класу.
     * @param toy об’єкт для додавання
     */
    public ToySet(T toy) {
        this();
        add(toy);
    }

    /**
     * Конструктор, що приймає стандартну колекцію об’єктів.
     * Додає всі елементи колекції до набору.
     * @param collection колекція об’єктів
     */
    public ToySet(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    /**
     * Отримує елемент за індексом.
     * Повертає елемент за індексом або null, якщо індекс виходить за межі колекції.
     * @param index індекс елемента
     * @return елемент за індексом або null, якщо індекс не існує
     */
    public T get(int index) {
        if(index >= size || index < 0) return null; // Якщо індекс поза межами
        Node<T> node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node == null ? null : node.data;
    }

    /**
     * Додає елемент на початок списку.
     * Це змінює голову списку, роблячи новий елемент першим.
     * @param val значення, яке додається в колекцію
     * @return true, якщо елемент успішно додано
     */

    public boolean add(T val) {
        Node<T> node = new Node<>(val);
        node.next = head;
        head = node;
        size++;
        return true;
    }

    /**
     * Додає всі елементи з колекції в набір.
     * @param collection колекція об’єктів для додавання
     * @return true, якщо елементи успішно додано
     */
    public boolean addAll(Collection<? extends T> collection) {
        if (collection == null || collection.isEmpty()) return false;
        for (T val : collection) {
            add(val); // Додаємо кожен елемент по черзі
        }
        return true;
    }

    /**
     * Видаляє елемент за індексом.
     * Якщо індекс поза межами колекції, елемент не видаляється.
     * @param index індекс елемента для видалення
     */
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0) return; // Якщо індекс виходить за межі
        Node<T> current = head;
        Node<T> previous = null;
        for(int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }
        if(previous == null) {
            head = head.next; // Видаляємо перший елемент
        } else {
            previous.next = current.next; // Пропускаємо поточний елемент
        }
        size--;
    }

    /**
     * Перевіряє чи колекція порожня.
     * @return true, якщо колекція порожня
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Повертає кількість елементів у колекції.
     * @return кількість елементів
     */
    public int size() {
        return size;
    }

    /**
     * Перевіряє чи міститься елемент у колекції.
     * @param obj елемент для перевірки
     * @return true, якщо елемент міститься
     */
    public boolean contains(Object obj) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(obj)) return true;
            current = current.next;
        }
        return false;
    }

    /**
     * Видаляє всі елементи з колекції.
     */

    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Ітератор для перебору елементів колекції.
     * @return ітератор для колекції
     */

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    // Решта методів інтерфейсу Set, якщо потрібно, можуть бути реалізовані в подальшому.
}
