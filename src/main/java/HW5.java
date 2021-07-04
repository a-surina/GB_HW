import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class HW5 {
    private static final Faker faker = new Faker(new Locale("en", "RU"));
    private static final Random random = new Random();

    public static String generateName() {
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generateProfession() {
        return faker.job().position();
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generatePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateSalary() {
        return String.valueOf(18_000 + random.nextInt(350_000));
    }

    public static String generateAge() {
        return String.valueOf(18 + random.nextInt(62));
    }

    public static void main(String[] args) {

        //    Создать массив из 5 сотрудников.
        Employee[] employees = new Employee[5];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee(generateName(), generateAge(),
                    generateProfession(), generateEmail(), generatePhoneNumber(), generateSalary());
        }

        //    С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        int count = 0;
        for (Employee employee : employees) {
            if (Integer.parseInt(employee.getAge()) > 40) {
            employee.printer();
            count++;
            }
        }
        if (count == 0) {
            System.out.println("Нет сотрудников старше 40 лет");
        }
    }
}
