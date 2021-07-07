import com.github.javafaker.Faker;
import java.util.Locale;

public class Animal {
    public String name;
    public int limitRunning;
    public int limitSwimming;
    public String type;
    public int appetite;
    boolean full;

    public Animal() {
        this.name = generateName();
        this.limitRunning = 100;
        this.limitSwimming = 5;
        this.type = "Animal";
        this.appetite = 0;
        this.full = false;
    }

    public void run(int length) {
        if(length > this.limitRunning){
            System.out.printf("%s %s cannot run %s m" + "\n", this.type, this.name, length);
        } else {
            System.out.printf("%s %s has run %s m" + "\n", this.type, this.name, length);
        }
    }

    public void swim(int length) {
        if(length > this.limitSwimming){
            System.out.printf("%s %s cannot swim %s m" + "\n", this.type,  this.name, length);
        } else {
            System.out.printf("%s %s has swum %s m" + "\n", this.type,  this.name, length);
        }
    }

    public String generateName() {
        Faker faker = new Faker(new Locale("en", "RU"));
        return faker.animal().name();
    }

    public String getType() {
        return type;
    }

    public void printer() {
        System.out.println(type + " " + name);
    }
}
