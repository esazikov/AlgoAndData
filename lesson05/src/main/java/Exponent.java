public class Exponent {
    public static void main(String[] args) {
        System.out.println(exponent(2,-5));
        System.out.println(exponent(2, 5));
    }

    private static float exponent (float number, int power) {
        if (power == 0) {
            return 1;
        }
        if (power < 0) {
            return 1/number * exponent(number, ++power);
        } else {
            return number * exponent(number, --power);
        }



    }
}
