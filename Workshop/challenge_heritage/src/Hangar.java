public class Hangar {
    public static void main(String[] args) {
        Car car = new Car();
        car.setBrand("Flash McQueen");
        System.out.println(car.doStuff());

        Boat boat = new Boat();
        boat.setBrand("Pochtron");
        System.out.println(boat.doStuff());
    }
}
