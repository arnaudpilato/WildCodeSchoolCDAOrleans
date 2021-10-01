public class Dolphin extends Animal {
    public Dolphin(String name) {
        super(name);
    }

    @Override
    public void scream() {
        System.out.println("Je siffle");
    }

    @Override
    public void move() {
        System.out.println("Je nage");
    }
}
