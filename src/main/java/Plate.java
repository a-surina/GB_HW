public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int decreaseFood(int n) {
        n = Math.abs(n);
        int foodDecreasedBy;
        if (food >= n) {
            food -= n;
            foodDecreasedBy = n;
        } else {
            foodDecreasedBy = 0;
        }
        return foodDecreasedBy;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void add(int ammount) {
        if (ammount <= 0) {
            System.out.println("You cannot add " + ammount);
        }
        food += ammount;
    }
}
