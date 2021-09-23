public class Snake extends Animal {
    public Snake(String name) {
        super(name);
    }

    @Override
    public void scream() {
        System.out.println("Je siffle");
    }

    @Override
    public void move() {
        System.out.println("Je rampe");
    }
}
