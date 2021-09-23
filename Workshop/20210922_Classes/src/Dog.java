public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void getNbPaw() {
        System.out.println("J'ai 4 pattes");
    }

    @Override
    public void scream() {
        System.out.println("J'aboie");
    }

    @Override
    public void move() {
        System.out.println("Je cours");
    }
}
