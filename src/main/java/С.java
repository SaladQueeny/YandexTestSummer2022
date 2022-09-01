import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class С {

    static boolean IsSimple(long n) {
        if (n == 1) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static Long getGcd(Long n1, Long n2) {
        if (n2 == 0) {
            return n1;
        }
        return getGcd(n2, n1 % n2);
    }

    private static List<Long> maxPrimeFactors(Long n) {
        List<Long> decimers = new ArrayList<>();
//        System.out.println("--------------------------------");
        long maxPrime = -1;
        while (n % 2 == 0) {
            maxPrime = 2;
            if (!decimers.contains(maxPrime)) {
                decimers.add(maxPrime);
            }
//            System.out.println("maxPrime "+maxPrime);
            n = n / 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                if (!decimers.contains(maxPrime)) {
                    decimers.add(maxPrime);
                }
//                System.out.println("maxPrime "+maxPrime);
                n = n / i;
            }
        }
        if (n > 2) {
            maxPrime = n;
            if (!decimers.contains(maxPrime)) {
                decimers.add(maxPrime);
            }
//            System.out.println("maxPrime "+maxPrime);
        }

//        System.out.println(decimers);
//        System.out.println("maxPrime "+maxPrime);
//        System.out.println("--------------------------------");
        return decimers;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] nums = line.split(" ");
            long num1 = Long.parseLong(nums[0]);
            long num2 = Long.parseLong(nums[1]);

            if (IsSimple(Math.max(num1, num2)) || Math.max(num1, num2) == 1) {
                System.out.println(Math.max(num1, num2));
                continue;
            }
            List<Long> maxDivider1 = maxPrimeFactors(Math.max(num1, num2));
            List<Long> maxDivider2 = maxPrimeFactors(Math.min(num1, num2));
            var max = 0L;
            for (Long num : maxDivider1) {
                max = Math.max(getGcd(Math.min(num1, num2) * num, Math.max(num1, num2)), max);
            }
            for (Long num : maxDivider2) {
                max = Math.max(getGcd(Math.min(num1, num2), Math.max(num1, num2) * num), max);
            }
            if (IsSimple(Math.min(num1, num2))) {
                max = Math.max(Math.min(num1, num2), max);
            }
            System.out.println(max);
        }
    }
}

/*
5
1667 123
20 45
3
5 1
12 54
500100 100500
1 1
2 14

1000000000 1000000000

 */




