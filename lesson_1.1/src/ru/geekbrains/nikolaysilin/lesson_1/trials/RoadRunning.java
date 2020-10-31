package ru.geekbrains.nikolaysilin.lesson_1.trials;

import ru.geekbrains.nikolaysilin.lesson_1.actions.Actions;

public class RoadRunning extends Obstacles {

    private int length;

    public RoadRunning(String name, int length) {
        super(name);

        this.length = length;

    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean moving(Actions actions) {
        System.out.println("Дорога " + " дистанция: " + this.length);

        actions.run();

        if(getLength() <= actions.getRunDistance()) {
            System.out.println("Пробежал");

            return true;
        } else {
            System.out.println("Не пробежал");
            return false;
        }

    }
}
