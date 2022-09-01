import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[] s = scanner.nextLine().toCharArray();
        int index = 0;
        int index1 = 0;
        int sum = -1;
        int sum1 = -1;
        var result = new int[n];
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                sum--;
                sum1++;
                if (sum1 <= 0) {
                    result[i] = -1;
                    index = i;
                    sum1 = 1;
                } else {
                    result[i] = index + 1;
                }
            } else {
                sum++;
                sum1--;
                if (sum <= 0) {
                    result[i] = -1;
                    index1 = i;
                    sum = 1;
                } else {
                    result[i] = index1 + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
