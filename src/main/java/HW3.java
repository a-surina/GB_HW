import java.util.Arrays;

public class HW3 {

    public static void main(String[] args) {

        /*1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;*/

        int[] myBinaryArr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < myBinaryArr.length; i++) {
            myBinaryArr[i] = myBinaryArr[i] == 1 ? 0 : 1;
        }
        System.out.println("1. Целочисленный массив из 0 и 1");
        System.out.println((Arrays.toString(myBinaryArr)));

        /*2. Задать пустой целочисленный массив длиной 100.
        С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100; */

        int[] myHundredArr = new int[100];
        for (int i = 0; i < myHundredArr.length; i++) {
            myHundredArr[i] = i + 1;
        }
        System.out.println("2. Пустой целочисленный массив длиной 100");
        System.out.println((Arrays.toString(myHundredArr)));

         /*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        пройти по нему циклом, и числа меньшие 6 умножить на 2; */

        int[] myMultipleByTwo = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("3. Массив исходный: ");
        System.out.println((Arrays.toString(myBinaryArr)));
        for (int i = 0; i < myMultipleByTwo.length; i++) {
            if (myMultipleByTwo[i] < 6) {
                myMultipleByTwo[i] = myMultipleByTwo[i] * 2;
            }
        }
        System.out.println("3. Массив после умножения");
        System.out.println((Arrays.toString(myMultipleByTwo)));

        /*4. Создать квадратный двумерный целочисленный массив
        (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его
        диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
        Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
        то есть [0][0], [1][1], [2][2], …, [n][n];
         */

        System.out.println("4. Создаём двумерный массив с нулями:");
        int[][] nullArr = twoDimensionalArrCreate(5, 5, 0);
        twoDimensionalArrPrinter(nullArr);
        System.out.println("4. Заполняем диагонали:");
        int[][] diagonallyCrossedArr = twoDimensionalArrCross(nullArr, 1);
        twoDimensionalArrPrinter(diagonallyCrossedArr);

        /*5. Написать метод, принимающий на вход два аргумента: len и initialValue,
        и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;*/
        System.out.println("5. Конструктор одномерных массивов:");
        int[] newSimpleArray = oneDimensionalArrCreate(9, 14);
        System.out.println(Arrays.toString(newSimpleArray));

        /*6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы */
        int[] arrMaxAndMin = {7, 5, 0, 2, 11, 7, 5, 2, -3, 8, 9, 8};
        System.out.println("6. Одномерный массив:");
        System.out.println(Arrays.toString(arrMaxAndMin));
        int maxInArray = maxInSimpleArray(arrMaxAndMin);
        int minInArray = minInSimpleArray(arrMaxAndMin);
        System.out.println("Min =" + minInArray + " ; max = " + maxInArray);

        /*7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        **Примеры:
        checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
        checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1

        граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.*/
        int[] evenArr = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] oddArr = {1, 3, 1, 25, 1};
        System.out.println("7. Одномерный массив [2, 2, 2, 1, 2, 2, ||| 10, 1]: " + checkBalance(evenArr));
        System.out.println("\tОдномерный массив [1, 3, 1, 25, 1]: " + checkBalance(oddArr));

        /*8. *** Написать метод, которому на вход подается одномерный массив и число n
        (может быть положительным, или отрицательным), при этом метод должен сместить
        все элементы массива на n позиций. Элементы смещаются циклично.
        Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
        [ 3, 5, 6, 1] при n = -2 (на два влево) ->
        [ 6, 1, 3, 5 ].
        При каком n в какую сторону сдвиг можете выбирать сами.*/
        int[] arrToShift = {1, 2, 3, -9, 14, 0};
        System.out.println("8. Исходный массив");
        System.out.println(Arrays.toString(arrToShift));
        System.out.println("\tСмещённый массив");
        System.out.println(Arrays.toString(shiftArray(arrToShift, 1)));
    }

    public static int[] shiftArray(int[] arr, int n) {
        int cash1 = arr[0];
        int cash2 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i;
            while (j + n < arr.length) {
                cash1 = arr[j];
                cash2 = arr[j+n];
                arr[j+n] = cash1;
                j++;
            }
            arr[i] = cash2;
            cash2 = arr[i+1];

        }
        return arr;
    }

    public static int[] oneDimensionalArrCreate(int len, int initialValue) {
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = initialValue;
        }
        return result;
    }

    public static int[][] twoDimensionalArrCreate(int width, int height, int filling) {
        int[][] result = new int[width][height];
        for (int[] ints : result) {
            Arrays.fill(ints, filling);
        }
        return result;
    }

    public static int[][] twoDimensionalArrCross(int[][] arrToFill, int filling) {
        int beginning = 0;
        int end = arrToFill.length-1;
        for (int i = 0; i < arrToFill.length; i++) {
            arrToFill[i][beginning] = filling;
            arrToFill[i][end] = filling;
            beginning++;
            end--;
        }

        return arrToFill;
    }

    public static void twoDimensionalArrPrinter(int[][] arrToPrint) {
        for (int[] firstArr : arrToPrint) {
            for (int secondArr : firstArr) {
                System.out.print(secondArr + "\t");
            }
            System.out.println("\n");
        }
    }

    public static int maxInSimpleArray(int[] arr) {
        int max = arr[0];
        for(int elem : arr) {
            if(max < elem) {
                max = elem;
            }
        }
        return max;
    }

    public static int minInSimpleArray(int[] arr) {
        int min = arr[0];
        for(int elem : arr) {
            if(min > elem) {
                min = elem;
            }
        }
        return min;
    }

    public static boolean checkBalance(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            if(i > 0) {
                for (int j = 0; j < i; j++) {
                    sumLeft += arr[j];
                }
            }
            if(i < arr.length-1) {
                for (int k = i; k < arr.length; k++) {
                    sumRight += arr[k];
                }
            }
            if (sumLeft == sumRight){
                return true;
            }
        }
        return false;
    }
}
