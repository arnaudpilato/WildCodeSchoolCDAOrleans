public class Car extends Vehicle  {
    @Override
    public String doStuff() {
        return "Je suis " + getBrand() + " et je fais vroum vroum !";
    }
}
