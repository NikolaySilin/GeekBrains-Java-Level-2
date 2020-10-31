package ru.geekbrains.nikolaysilin.lesson_1.members;

import ru.geekbrains.nikolaysilin.lesson_1.actions.Actions;

public class Robot implements Actions {

    protected String type;
    protected String name;
    protected int runDistance;
    protected double jumpHeight;

    public Robot (String type, String name, int distance, double jumpHeight) {

        this.type = type;
        this.name = name;
        this.runDistance = distance;
        this.jumpHeight = jumpHeight;

    }

    @Override
    public void run() {
        System.out.println (this.type + " " + this.name + " способен преодолеть " + this.getRunDistance() + " метров");

    }

    @Override
    public void jump() {
        System.out.println (this.type + " " + this.name + " прыгает на высоту " + this.getJumpHeight());
    }

    @Override
    public int getRunDistance() {
        return this.runDistance;
    }

    @Override
    public double getJumpHeight() {
        return this.jumpHeight;
    }
}