package ru.geekbrains.nikolaysilin.lesson_3;

import java.util.HashMap;
import java.util.HashSet;

// Написать простой класс телефонный справочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи.
// С помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

public class PhoneBook {

    HashMap<String, HashSet<String>> phonebook;

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        HashSet<String> book = phonebook.getOrDefault(name, new HashSet<>());
        book.add(phone);
        phonebook.put(name, book);
    }

    public void getFind(String name) {
        System.out.println("Contact name: " + name + " / Phone number: " + phonebook.getOrDefault(name, new HashSet<>()));

    }
}
