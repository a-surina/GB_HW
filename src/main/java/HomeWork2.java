public class HomeWork2 {
    /* 1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
* 5. Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.*/

    public static void main(String[] args) {
        System.out.println(sumWithinTenToTwenty(10, 10)); //true
        isPositive(0); // true
        System.out.println(isNegative(0)); // false
        multiplePrinter("print", 5); //should be printed 5 times
        System.out.println(isLeapYear(2000)); //true
    }

    public static boolean sumWithinTenToTwenty(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void isPositive(int a) {
        boolean result = a >= 0;
        System.out.println(result);
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void multiplePrinter(String stringToPrint, int quantity) {
        while (quantity > 0) {
            System.out.println(stringToPrint);
            quantity--;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
