import java.util.Random;

public class HomeWorkApp {
    /* Захотелось разнообразить выдачу,
    поэтому не стала хардкодить значения пременных
    и задала их рандомайзером.
    */

    private static final Random random = new Random();

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.print("Orange\n" +
                "Banana\n" +
                "Apple\n");

    }

    public static void checkSumSign() {
        int a = random.nextInt(99);
        int b = random.nextInt(99);
        String randomizedValue = "a = " + a + ", " + "b = " + b; // чтобы было понятно, какое значение сгенерировалось
        System.out.println(randomizedValue);
        if (a + b >= 0) {
            System.out.println("Сумма положительная");

        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = random.nextInt(99);
        String randomizedValue = "value = " + value;
        System.out.println(randomizedValue);
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = random.nextInt(99);
        int b = random.nextInt(99);
        String randomizedValue = "a = " + a  + ", " + "b = " + b;
        System.out.println(randomizedValue);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
