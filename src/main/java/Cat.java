import com.github.javafaker.Faker;
import java.util.Locale;
public class Cat extends Animal {
    public Cat() {
        this.limitRunning = 200;
        this.type = "Cat";
    }

    public Cat(int appetite) {
        this.appetite = appetite;
        this.type = "Cat";
    }

    @Override
    public String generateName() {
        Faker faker = new Faker(new Locale("en", "RU"));
        return faker.cat().name();
    }

    public void eat(Plate p) {
        int foodEaten = p.decreaseFood(appetite);
        if (foodEaten == appetite){
            full = true;
            System.out.println(type + " " + name + " has eaten " + appetite);
            System.out.println(type + " " + name + " is full");
        } else {
            System.out.println(type + " " + name + " is still hungry");
        }
    }

    @Override
    public void printer() {
        System.out.println("Hungry " + type + " " + name + " with appetite " + appetite);
    }
}
