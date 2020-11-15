package ru.geekbrains.nikolaysilin.lesson_1.trials;

import ru.geekbrains.nikolaysilin.lesson_1.actions.*;

public class Wall extends Obstacles {

    private double heigth;

    public Wall(String name, double heigth) {
        super(name);

        this.heigth = heigth;
    }

    public double getHeigth() {
        return heigth;
    }

    @Override
    public boolean moving(Actions actions) {
        System.out.println("Стена " + "высота: " + this.heigth);

        actions.jump();

        if (getHeigth() <= actions.getJumpHeight()) {
            System.out.println("Перепрыгнул");
            System.out.println();

            return true;
        } else {
            System.out.println("Не перепрыгнул");


            return false;
        }
    }
}