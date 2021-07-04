import com.github.javafaker.Faker;
import java.util.Locale;
public class Cat extends Animal {
    public Cat() {
        this.limitRunning = 200;
        this.type = "Cat";
    }

    @Override
    public String generateName() {
        Faker faker = new Faker(new Locale("en", "RU"));
        return faker.cat().name();
    }
}
