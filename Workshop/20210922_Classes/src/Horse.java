public class Horse extends Animal {
    public Horse(String name) {
        super(name);
    }

    @Override
    public void scream() {
        System.out.println("Je hennit");
    }

    @Override
    public void move() {
        System.out.println("Je galope");
    }
}
