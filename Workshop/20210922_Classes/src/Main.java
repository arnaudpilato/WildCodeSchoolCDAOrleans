import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);
        System.out.println("Selectionnez le nom de votre animal");
        String animalName = choice.nextLine();
        System.out.println(
                "Selectionnez maintenant votre type d'animal : \n" +
                "1 - Cheval \n" +
                "2 - Chien \n" +
                "3 - Chat \n" +
                "4 - Oiseaux \n" +
                "5 - Poisson \n" +
                "6 - Dauphin \n" +
                "7 - Serpent \n"
        );

        int animalType = choice.nextInt();

        switch (animalType) {
            case 1 -> horse(animalName);
            case 2 -> dog(animalName);
            case 3 -> cat(animalName);
            case 4 -> bird(animalName);
            case 5 -> fish(animalName);
            case 6 -> dolphin(animalName);
            case 7 -> snake(animalName);
        }
    }

    public static void horse(String name) {
        Horse horse = new Horse(name);
        System.out.println("Je m'appelle " + horse.getName());
        horse.scream();
        horse.move();
    }

    public static void dog(String name) {
        Dog dog = new Dog(name);
        System.out.println("Je m'appelle " + dog.getName());
        dog.scream();
        dog.getNbPaw();
        dog.move();
    }

    public static void cat(String name) {
        Cat cat = new Cat(name);
        System.out.println("Je m'appelle " + cat.getName());
        cat.scream();
        cat.getNbPaw();
        cat.move();
    }

    public static void bird(String name) {
        Bird bird = new Bird(name);
        System.out.println("Je m'appelle " + bird.getName());
        bird.scream();
        bird.getNbPaw();
        bird.move();
    }

    public static void fish(String name) {
        Fish fish = new Fish(name);
        System.out.println("Je m'appelle " + fish.getName());
        fish.scream();
        fish.move();
    }

    public static void dolphin(String name) {
        Dolphin dolphin = new Dolphin(name);
        System.out.println("Je m'appelle " + dolphin.getName());
        dolphin.scream();
        dolphin.move();
    }

    public static void snake(String name) {
        Snake snake = new Snake(name);
        System.out.println("Je m'appelle " + snake.getName());
        snake.scream();
        snake.move();
    }
}
