public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public void getNbPaw() {
        System.out.println("J'ai 4 pattes");
    }

    @Override
    public void scream() {
        System.out.println("Je miaule");
    }

    @Override
    public void move() {
        System.out.println("Je cours");
    }
}
