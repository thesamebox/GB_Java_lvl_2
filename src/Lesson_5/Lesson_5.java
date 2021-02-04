package Lesson_5;

import java.util.Arrays;

public class Lesson_5 {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        createArr(arr);
        System.out.println("Заполнили массив расчетными данными за " + (System.currentTimeMillis() - a) + " мили ceк.");
        System.out.println("Элемент массива №" + h + "= " + arr[h]);

        Arrays.fill(arr, 1);
        long b = System.currentTimeMillis();
        doMagic(arr);
        System.out.println("Заполнили массив расчетными данными, поделив его на 2 потока, за " + (System.currentTimeMillis() - b) + " мили ceк.");
        System.out.println("Элемент массива после дележки №" + h + "= " + arr[h]);

    }

    private static void createArr(float[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void doMagic(float[] arr) {

        float[] a1 = new float[h];
        float[] a2 = new float[h];


        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread threadA1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread threadA2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
            }
        });

        threadA1.start();
        threadA2.start();

    try {
        threadA1.join();
        threadA2.join();
    } catch (InterruptedException e){
    }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
    }
}
