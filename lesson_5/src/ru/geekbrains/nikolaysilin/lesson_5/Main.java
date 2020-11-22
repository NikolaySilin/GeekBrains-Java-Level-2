package ru.geekbrains.nikolaysilin.lesson_5;

import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int quarter_size = size / 4;


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

        System.out.println("Время выполнения программы с одним потоком: " + (end - start) + " миллисекунд.");
        System.out.println("Завершение метода 1.");
        System.out.println();

    }

    protected void hasMultiThread() throws InterruptedException {

        System.out.println("2. Старт метода с четыремя потоками.");

        float[] arr = new float[size];
        float[] arr1 = new float[quarter_size];
        float[] arr2 = new float[quarter_size];
        float[] arr3 = new float[quarter_size];
        float[] arr4 = new float[quarter_size];

        Arrays.fill(arr, 1.0f);

        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, quarter_size);
        System.arraycopy(arr, quarter_size, arr2, 0, quarter_size);
        System.arraycopy(arr, quarter_size, arr3, 0, quarter_size);
        System.arraycopy(arr, quarter_size, arr4, 0, quarter_size);
        long split = System.currentTimeMillis();
        System.out.println("Время выполнения разделения одного массива на четыре: " + (split - start) + " миллисекунд.");

        Thread t_1 = new Thread(() -> this.fourThread(arr1, 1));
        Thread t_2 = new Thread(() -> this.fourThread(arr2, 2));
        Thread t_3 = new Thread(() -> this.fourThread(arr3, 3));
        Thread t_4= new Thread(() -> this.fourThread(arr4, 4));

        t_1.start();
        t_2.start();
        t_3.start();
        t_4.start();

        if (t_1.isAlive()) t_1.join();
        if (t_2.isAlive()) t_2.join();
        if (t_3.isAlive()) t_3.join();
        if (t_4.isAlive()) t_4.join();

        long connect = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, quarter_size);
        System.arraycopy(arr2, 0, arr, quarter_size, quarter_size);
        System.arraycopy(arr3, 0, arr, quarter_size, quarter_size);
        System.arraycopy(arr4, 0, arr, quarter_size, quarter_size);
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения на склеивание четырех массивов в один: " + (end - connect) + " миллисекунд.");

        System.out.println("Время выполнения программы с четыремя потоками: " + (end - start) + " миллисекунд.");
        System.out.println("Завершение метода 2.");

    }

    protected void fourThread(float[] arr, int number) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        long end = System.currentTimeMillis();

        System.out.println(String.format("Время выполнения потока: %d, равно: %s", number, String.valueOf(end - start) + " миллисекунд."));
    }

}
