public class Fish extends Animal {
    public Fish(String name) {
        super(name);
    }

    public void egg() {
        Egg egg = new Egg();
        System.out.println("Je pond des oeufs");
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
