public class Snake extends Animal {
    public Snake(String name) {
        super(name);
    }

    public void egg() {
        Egg egg = new Egg();
        System.out.println("Je pond des oeufs");
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
