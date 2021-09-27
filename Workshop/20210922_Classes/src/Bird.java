public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    public void getNbPaw() {
        System.out.println("J'ai 2 pattes");
    }

    public void egg() {
        Egg egg = new Egg();
        System.out.println("Je pond des oeufs");
    }

    @Override
    public void scream() {
        System.out.println("Je chante");
    }

    @Override
    public void move() {
        System.out.println("Je vole");
    }
}
