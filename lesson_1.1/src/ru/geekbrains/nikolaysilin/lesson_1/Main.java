package ru.geekbrains.nikolaysilin.lesson_1;

import ru.geekbrains.nikolaysilin.lesson_1.actions.*;
import ru.geekbrains.nikolaysilin.lesson_1.members.*;
import ru.geekbrains.nikolaysilin.lesson_1.trials.*;

import java.util.Random;

public class Main {

public static void main(String[] args) {

Random rand = new Random();

Actions[] actions = new Actions[3];

int distance = 1000;
double height = 1.5;
actions[0] = new Human("Человек", "Макс", distance, height);

distance = 300;
height = 0.1;
actions[1] = new Robot ("Робот", "Чаппи", distance, height);

distance = 50;
height = 1.2;
actions[2] = new Cat("Кот", "Саймон", distance, height);

Obstacles[] obstacles = new Obstacles[6];


for (int i = 0; i < obstacles.length; i++) {
    distance = rand.nextInt(1000);
    height = rand.nextInt(3);
    boolean isRoadRunning = rand.nextBoolean();
    if (isRoadRunning) {
        obstacles[i] = new RoadRunning("Дорога " + i, distance);
    } else {
        obstacles[i] = new Wall("Стена " + i, height);
    }
}

for (int i = 0; i < actions.length; i++) {
    boolean result = true;
    for (int j = 0; j < obstacles.length; j++) {
        result = obstacles[j].moving(actions[i]);

        if(!result) {
            break;
        }
    }

    if (result) {
        System.out.println("Выполнено");
        System.out.println();
    } else {
        System.out.println("Не выполнено");
    }
}

}

}