package ru.geekbrains.nikolaysilin.lesson_3;

import java.util.*;

// Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать сколько раз встречается каждое слово.

public class Main {

    public static void main(String[] args) {

        String[] fruit = {"Sorry", "List", "Green", "Mars", "Develop", "Moon", "Fruit",
                          "List", "Appear", "Ground", "Moon", "Sorry", "Moon", "Appear"};

        HashMap<String, Integer> words = new HashMap<>();

        for (String x : fruit) {
            words.put(x, words.getOrDefault(x,0)+1);
        }
        System.out.println(words);
        System.out.println();

//----------------------------------------------------------------------------------------------------------------------

        // Добавляем контакты в телефонный справочник.

        PhoneBook book = new PhoneBook();

        book.addContact("Nikolay", "+79226541212");
        book.addContact("Adam", "+79226541212");
        book.addContact("Oleg", "+79226541212");
        book.addContact("Oleg", "+15552221213");
        book.addContact("Nikita", "+79226541212");
        book.addContact("Sergey", "+79226541212");
        book.addContact("Konstantin", "+79226541212");
        book.addContact("Nikolay", "+13326512233");

        // Ищем по имени.

        book.getFind("Nikolay");
        book.getFind("Adam");
        book.getFind("Konstantin");
        book.getFind("Oleg");

    }
}
