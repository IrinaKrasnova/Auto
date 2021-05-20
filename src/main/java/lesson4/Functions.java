package lesson4;

public class Functions {
    public static double calculateArea(int a, int b, int c) throws NegativeOrNullTriangleSideException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new NegativeOrNullTriangleSideException();
        }
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) + (p - b) * (p - c));
    }

}
