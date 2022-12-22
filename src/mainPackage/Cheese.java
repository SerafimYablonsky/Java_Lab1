package mainPackage;

public class Cheese extends Food {
    public void consume() {
        System.out.println("" + this + " съеден");
    }

    public Cheese() {
        super("Сыр");
    }

    public int calculateCalories() {
        return 300;
    }
}