package ru.geekbrains.nikolaysilin.lesson_2;

public class Size {

    public static void main(String[] args) {

//Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
//при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

        Size main = new Size();

        String[][] correct = {{"1", "1", "1", "1"},
                              {"1", "1", "1", "1"},
                              {"1", "1", "1", "1"},
                              {"1", "1", "1", "1"}};



        String[][] incorrect = {{"1", "1", "1", "1"},
                                {"1", "1", "1", "1"},
                                {"1", "1", "1", "1"},
                                {"1", "1", "1", "1"},
                                {"1", "1", "1", "1"}};

        try {
            main.StringExceptionTest(correct);
            main.StringExceptionTest(incorrect);
        } catch (MyArraySizeException ex) {
            ex.printStackTrace();
        }

    }

    public void StringExceptionTest(String[][] arr) throws MyArraySizeException {
        if (arr.length != 4) throw new MyArraySizeException("Неверное количество строк");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4)
                throw new MyArraySizeException(String.format("Неверное количество столбцов в %d" + " строке", i));
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }


    class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }
}



