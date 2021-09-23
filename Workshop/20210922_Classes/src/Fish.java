public class Fish extends Animal {
    public Fish(String name) {
        super(name);
    }

    @Override
    public void scream() {
        System.out.println("Je blop");
    }

    @Override
    public void move() {
        System.out.println("Je nage");
    }
}
