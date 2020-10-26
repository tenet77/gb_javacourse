package lesson2;

import java.util.Arrays;

public class HomeWork {

    public static boolean checkBalance(int[] arr) {

        int leftSum = arr[0], rightSum = arr[arr.length-1];
        int leftIndex = 0, rightIndex = arr.length - 1;

        while (rightIndex > leftIndex + 1) {
            if (leftSum > rightSum) {
                rightIndex --;
                rightSum += arr[rightIndex];
            } else {
                leftIndex ++;
                leftSum += arr[leftIndex];
            }
        }
        System.out.printf("index left - %d index right - %d Sum - %d \n", leftIndex, rightIndex, leftSum);
        return (leftSum == rightSum);
    }

    public static void shiftArray(int[] arr, int s) {

        int step = s % arr.length;

        if (step < 0) {
            step = arr.length + step;
        }

        if (step == 0) return;

        for (int i = 0; i < step; i++) {
            for (int j = arr.length-1; j > 0; j--) {
                int tmpMove = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmpMove;
                }
            }
    }

    public static void main(String[] args) {
//      1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//      С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arr1 = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (arr1[i] == 1) ? 0 : 1 ;
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println("-------------------");

//      2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr2));
        System.out.println("-------------------");

//      3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

        int[] arr3 = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3));
        System.out.println("-------------------");

//      4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
//      цикла(-ов) заполнить его диагональные элементы единицами;

        int[][] arr4 = new int[5][5];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i][i] = 1;
            arr4[i][arr4[i].length - i - 1] = 1;
        }
        for (int[] ints : arr4) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("-------------------");

//      5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

        int[] arr5 = new int[20];
        int min5 = -1;
        int max5 = -1;

        for (int i = 0; i < arr5.length; i++) {

            arr5[i] = (int) (Math.random() * 1000);

            if (i == 0) {
                min5 = arr5[i];
                max5 = arr5[i];
            } else {
                if (arr5[i] > max5) {
                    max5 = arr5[i];
                }
                if (arr5[i] < min5) {
                    min5 = arr5[i];
                }
            }

        }
        System.out.println(Arrays.toString(arr5));
        System.out.printf("min - %d, max - %d \n", min5, max5);
        System.out.println("-------------------");

//      6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
//      если в массиве есть место, в котором сумма левой и правой части массива равны.
//      Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
//      граница показана символами ||, эти символы в массив не входят.

        int[] arr6 = new int[10];

        for (int i = 0; i < arr6.length; i++) {
            arr6[i] = (int) (Math.random() * 5);
        }
        System.out.println(Arrays.toString(arr6));
        System.out.printf("balanced - %b \n", checkBalance(arr6));
        System.out.println("-------------------");

//      7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
//      или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения
//      задачи нельзя пользоваться вспомогательными массивами.

        int[] arr7 = new int[10];

        for (int i = 0; i < arr7.length; i++) {
            arr7[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr7));
        shiftArray(arr7, -1);
        System.out.println(Arrays.toString(arr7));
        System.out.println("-------------------");



    }
}

