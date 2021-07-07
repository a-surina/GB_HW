import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class HW66 {

    private static final Random random = new Random();

    public static void main(String[] args) {

        //    Создаём массив из 10 животных
        Animal[] animals = new Animal[10];
        for (int i = 0; i < animals.length; i++) {
            int type = random.nextInt(3);
            if(type == 0) {
                animals[i] = new Animal();
            }else if(type == 1) {
                animals[i] = new Dog();
            }else if(type == 2) {
               animals[i] = new Cat();
            }
        }

        //Выводим его на экран

        for(Animal animal : animals) {
            animal.printer();
        }
        System.out.println();

        //Считаем, сколько в нём кого
        countTypesOfAnimals(animals);

        //Просим животных пробежать разные дистанции
        for(Animal animal : animals) {
            animal.run(generateDistance());
        }
        System.out.println();

        //Просим животных проплыть разные дистанции
        for(Animal animal : animals) {
            animal.swim(generateDistance());
        }
    }

    public static void countTypesOfAnimals(Animal[] animals) {
        HashMap<String, Integer> map = new HashMap<>();
        for(Animal animal : animals) {
            String type = animal.getType();
            if(map.containsKey(type)) {
                map.put(type, map.get(type)+1);
            } else {
                map.put(type, 1);
            }
        }
        System.out.println(map.entrySet());
        System.out.println();
    }


    public static int generateDistance() {
        return 1 + random.nextInt(1000);
    }
}
