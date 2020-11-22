package ru.geekbrains.nikolaysilin.lesson_5;

import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int half_size = size / 2;


    public static void main(String[] args) throws InterruptedException {

        Main Main = new Main();

        hasNoMultiThread();

        Main.hasMultiThread();

    }

    protected static void hasNoMultiThread() {

        System.out.println("1. Старт метода с одним потоком.");

        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);

        long start = System.currentTimeMillis();
        for(int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();

            System.out.println("Завершение метода 1. Время выполнения программы с одним потоком: " + (end - start) + " миллисекунд.");
        System.out.println();

    }

    protected void hasMultiThread() throws InterruptedException {

        System.out.println("2. Старт метода с двумя потоками.");

        float[] arr = new float[size];
        float[] arr1 = new float[half_size];
        float[] arr2 = new float[half_size];
        Arrays.fill(arr, 1.0f);

        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, half_size);
        System.arraycopy(arr, half_size, arr2, 0, half_size);
        long split = System.currentTimeMillis();
        System.out.println("Время выполнения на разделение массива: " + (split - start) + " миллисекунд.");

        Thread t_1 = new Thread(() -> this.twoThread(arr1, 1));
        Thread t_2 = new Thread(() -> this.twoThread(arr2, 2));

        t_1.start();
        t_2.start();

        t_1.join();
        t_2.join();

        long connect = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, half_size);
        System.arraycopy(arr2, 0, arr, half_size, half_size);
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения на склеивание двух массивов в один: " + (end - connect) + " миллисекунд.");

        System.out.println("Завершение метода 2. Время выполнения программы с двумя потоками: " + (end - start) + " миллисекунд.");

    }

    protected void twoThread(float[] arr, int number) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        long end = System.currentTimeMillis();

        System.out.println(String.format("Время выполнения потока: %d, равно: %s", number, String.valueOf(end - start) + " миллисекунд."));
    }

}
