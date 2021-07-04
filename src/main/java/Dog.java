import com.github.javafaker.Faker;
import java.util.Locale;
public class Dog extends Animal {
    public Dog() {
        this.limitRunning = 500;
        this.limitSwimming = 10;
        this.type = "Dog";
    }
    @Override
    public String generateName() {
        Faker faker = new Faker(new Locale("en", "RU"));
        return faker.dog().name();
    }
}
