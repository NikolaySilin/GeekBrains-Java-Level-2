package ru.geekbrains.nikolaysilin.lesson_1.trials;

import ru.geekbrains.nikolaysilin.lesson_1.actions.Actions;

public abstract class Obstacles {
        private String name;

        public Obstacles(String name) {
            this.name = name;
        }

        public abstract boolean moving(Actions actions);

}


