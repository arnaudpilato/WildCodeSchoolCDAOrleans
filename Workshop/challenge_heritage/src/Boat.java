public class Boat extends Vehicle {
    @Override
    public String doStuff() {
        return "Je suis " + getBrand() + " et je fais glou glou !";
    }
}
