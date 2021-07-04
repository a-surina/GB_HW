public class Employee {
    //    Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    //    Конструктор класса должен заполнять эти поля при создании объекта.
    //    Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    private final String name;
    private final String age;
    private final String position;
    private final String email;
    private final String phoneNumber;
    private final String salary;

    public Employee(String name, String age, String position, String email, String phoneNumber, String salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSalary() {
        return salary;
    }

    public void printer() {
        System.out.print("ФИО: " + name + "\n"
                + "Должность: " + position + "\n"
                + "E-mail: " + email + "\n"
                + "Телефон: " + phoneNumber + "\n"
                + "Зарплата (руб): " + salary + "\n"
                + "Возраст: " + age + "\n");
        System.out.println();
    }
}
