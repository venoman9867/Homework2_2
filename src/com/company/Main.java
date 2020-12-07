package com.company;

public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] Array1 = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "щ", "11", "12"}, {"К", "14", "15", "16"}};//Ошибки все должны указываться, или первая попавшаяся?
        try {
            try {
                int result = Task1(Array1);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Неправильный раазмер массива!");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива!");
            System.out.println("Неправильное значение в массиве, координаты ошибки: " + e.i + "x" + e.j);
        }
    }
    public static int Task1(String[][] Array1) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (Array1.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < Array1.length; i++) {
            if (Array1[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < Array1[i].length; j++) {
                try {
                    count = count + Integer.parseInt(Array1[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }

}

