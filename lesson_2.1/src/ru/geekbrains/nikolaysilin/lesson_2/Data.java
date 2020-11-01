package ru.geekbrains.nikolaysilin.lesson_2;

public class Data {

// Метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.

    public static void main(String[] args) {

        String[][] correct = {{"1", "1", "1", "1"},
                              {"1", "1", "1", "1"},
                              {"1", "1", "1", "1"},
                              {"1", "1", "1", "1"}};



        String[][] incorrect = {{"1", "1", "1", "1"},
                                {"1", "1", "1", "1"},
                                {"1", "ccc", "1", "1"},
                                {"1", "1", "1", "1"}};

        try {
            System.out.println(sumOfArray(correct));
            System.out.println(sumOfArray(incorrect));
        } catch (MyArrayDataException ex) {
            ex.printStackTrace();
        }


    }

    private static int sumOfArray(String[][] matrix) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

    static class MyArrayDataException extends NumberFormatException {
        MyArrayDataException(int row, int col) {
            super(String.format("Неправильные данные в %d строке, в %d колонне", row, col));
        }
    }
}
