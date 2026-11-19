public class CompareUtil {

    // Generic Method untuk membandingkan dua nilai
    public static <T extends Comparable<T>> boolean isEqual(T a, T b) {
        return a.compareTo(b) == 0;
    }

    public static void main(String[] args) {

        // Membandingkan Integer
        System.out.println("Integer: " + isEqual(5, 5));

        // Membandingkan String
        System.out.println("String: " + isEqual("Hello", "World"));

        // Membandingkan Double
        System.out.println("Double: " + isEqual(3.14, 3.14));

        // Membandingkan Character
        System.out.println("Character: " + isEqual('A', 'A'));

        // Test Character berbeda
        System.out.println("Character: " + isEqual('A', 'B'));
    }
}