public class Main {
    public static void main(String[] args) {
        repeatString("Hello", 3);

    }

    public static void repeatString(final Object toRepeat, final int n) {
        String repeat = "";
        for (int i = 0; i < n; i++) {
            if (repeat instanceof String) {
                repeat += toRepeat;
            }
        }

        System.out.println(repeat);
    }
}
