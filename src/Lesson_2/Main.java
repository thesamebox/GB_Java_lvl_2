package Lesson_2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[][] testArr = new String[][]{
                {"перец", "7", "мама", "2"},//, "2"},
                {"перец", "баклажан", "12", "привет"},//, "1"},
                {"перец", "7", "марковь", ";"},//, "15"},
                {"перец", "7", "мама", "сосиска"},//, "2"},
////                {"перец", "7", "мама", "с", "яблоко"}
            /* или */
//                {"1", "7", "3", "2"},//, "2"},
//                {"5", "12", "12", "13"},//, "1"},
//                {"56", "7", "7", "89"},//, "15"},
//                {"17", "7", "67", "11"},//, "2"},
////                {"перец", "7", "мама", "с", "яблоко"}
        };
        int count = 0;

        try {
            count = convertIntoInt(testArr);
        } catch (MyArraySizeException mase) {
            System.out.println(mase);
        } catch (MyArrayDataException made) {
            System.out.println(made);
        }
        System.out.println(count);

    }

    public static int convertIntoInt(String[][] homeTaskArr) throws MyArraySizeException, MyArrayDataException {
        if (homeTaskArr[0].length != 4 && homeTaskArr.length != 4) {
            throw new MyArraySizeException("Принимаю массивы размерностью 4х4 и только!");
        }
        int count = 0;
        for (int i = 0; i < homeTaskArr[0].length; i++) {
            for (int j = 0; j < homeTaskArr.length; j++) {
                try {
                    count = count + Integer.parseInt(homeTaskArr[i][j]);
                } catch (NumberFormatException nfe) {
                    throw new MyArrayDataException("Элемент массива в строке " + i +" под номером " + j +" не может быть конверитрован в число");
                }
            }
        }
        return count;
    }
}
class MyArraySizeException extends Exception {
    public  MyArraySizeException (String message) {
        super(message);
    }
}
class MyArrayDataException extends Exception {
    public  MyArrayDataException (String message) {
        super(message);
    }
}
