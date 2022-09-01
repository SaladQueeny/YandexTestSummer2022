import java.util.*;

public class A {
    public static void main(String[] args) {
        String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " "};
        Map<Double, Integer> degreeOfTwo = new HashMap<>();
        for (int i=0; i<30; i++) {
            degreeOfTwo.put(Math.pow(2, i), i);
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double w = 0;
        double difference=0;
        for (int i = 0; i < n; i++) {
            double wi = scanner.nextDouble();
            difference = Math.abs(w - wi);
            w=wi;
            System.out.print(alphabet[degreeOfTwo.get(difference)]);
        }
    }
}




