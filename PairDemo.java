class Pair<T1, T2> {

    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public void showTypes() {
        System.out.println(
            first.getClass().getName() + " & " +
            second.getClass().getName()
        );
    }

    // Method untuk menukar posisi nilai
    public Pair<T2, T1> swap() {
        return new Pair<>(second, first);
    }
}

public class PairDemo {

    public static void main(String[] args) {

        // Pair Integer dan String
        Pair<Integer, String> pair1 = new Pair<>(100, "Lynn");

        System.out.println("Pair 1:");
        System.out.println("Nilai pertama: " + pair1.getFirst());
        System.out.println("Nilai kedua: " + pair1.getSecond());
        System.out.print("Tipe data: ");
        pair1.showTypes();

        Pair<String, Integer> swapped1 = pair1.swap();

        System.out.println("Setelah Swap:");
        System.out.println(swapped1.getFirst() + " & " + swapped1.getSecond());

        System.out.println("------------------------");

        // Pair Double dan Boolean
        Pair<Double, Boolean> pair2 = new Pair<>(3.14, true);

        System.out.println("Pair 2:");
        System.out.println("Nilai pertama: " + pair2.getFirst());
        System.out.println("Nilai kedua: " + pair2.getSecond());
        System.out.print("Tipe data: ");
        pair2.showTypes();

        Pair<Boolean, Double> swapped2 = pair2.swap();

        System.out.println("Setelah Swap:");
        System.out.println(swapped2.getFirst() + " & " + swapped2.getSecond());
    }
}