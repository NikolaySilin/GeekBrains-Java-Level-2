package ru.geekbrains.nikolaysilin.lesson_5;

public class Main {

    static final int size = 10000000;
    static final int half_size = size / 2;


    public static void main(String[] args) throws InterruptedException {

        hasNoMultiThread();

        hasMultiThread();

    }

    protected static void hasNoMultiThread() {

        long a = System.currentTimeMillis();
        float[] arr = new float[size];
        for(int i = 0; i < size; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        System.out.println("Время выполнения программы без многопоточности: " + (System.currentTimeMillis() - a));

    }

    protected static void hasMultiThread () throws InterruptedException {

        float[] a1 = new float[half_size];
        float[] a2 = new float[half_size];


        long a = System.currentTimeMillis();

        float[] arr = new float[size];
        for(int i = 0; i < size; i++);

        System.arraycopy(arr, 0, a1, 0, half_size);
        System.arraycopy(arr, half_size, a2, 0, half_size);

        Thread t_1 = new Thread(() -> {

            for(int i = 0; i < half_size; i++)
            a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        });

        Thread t_2 = new Thread(() -> {

            for(int i = 0; i < half_size; i++)
            a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        });

        System.arraycopy(a1, 0, arr, 0, half_size);
        System.arraycopy(a2, 0, arr, half_size, half_size);

        t_1.start();
        t_2.start();

        if (t_1.isAlive()) t_1.join();
        if (t_2.isAlive()) t_2.join();

        System.out.println("Время выполнения программы c многопоточностью: " + (System.currentTimeMillis() - a));






    }

}
