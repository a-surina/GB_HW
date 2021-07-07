import java.util.Random;

public class HW7 {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Cat cat = new Cat(5);
        Plate plate = new Plate(100);
        plate.info();
        cat.eat(plate);
        plate.info();
        System.out.println();

        // Создаём массив из 10 котов
        Cat[] cats = new Cat[10];
        for (int i = 0; i < cats.length; i++) {
            int appetite = random.nextInt(100);
            cats[i] = new Cat(appetite);
        }

        // Создаём тарелку с едой
        Plate plateForHungryCats = new Plate(200);
        plateForHungryCats.info();

        // Кормим котов
        for (Cat kitty : cats) {
            kitty.eat(plateForHungryCats);
        }

        // Добавляем еды
        plateForHungryCats.info();
        plateForHungryCats.add(400);
        plateForHungryCats.info();

        // Кормим недокормленных котов
        for (Cat kitty : cats) {
            if(!kitty.full) {
            kitty.eat(plateForHungryCats);
            }
        }
        plateForHungryCats.info();
    }

}
