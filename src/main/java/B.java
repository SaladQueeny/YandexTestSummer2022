import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        String numbers1[] = numbers.split(" ");
        int n = Integer.parseInt(numbers1[0]);
        int m = Integer.parseInt(numbers1[1]);
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String stroka = scanner.nextLine();
            char[] chars = stroka.toCharArray();
            List<Character> smallList = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                smallList.add(chars[j]);
            }
            list.add(smallList);
        }
        List<List<Character>> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            List<Character> semiresult = new ArrayList<>();
            for (int j = 0; j < m; ++j) {
                semiresult.add(list.get(n - i - 1).get(m - j - 1));
            }
            result.add(semiresult);
        }
        List<List<Character>> ultraLastResult = new ArrayList<>();
        List<Character> nado = new ArrayList<>();
        for (int i=0; i<m; i++){
            nado.add('.');
        }
        ultraLastResult.add(nado);
        for (int i = 0; i < n-1; ++i) {
            List<Character> semiresult = new ArrayList<>();
            for (int j = 0; j < m; ++j) {
                if (j % 2 == 0) {
                    semiresult.add(result.get(i+1).get(j));
                } else{
                    semiresult.add(result.get(i).get(j));
                }
            }
            ultraLastResult.add(semiresult);
        }


        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(ultraLastResult.get(i).get(j));
            }
            System.out.println();
        }
    }

}
/*
8 13
.............
...._........
.._/A\_..._..
./B\_/D\_/F\.
.\_/C\_/E\_/.
...\_/G\_/...
.....\_/.....
.............





5 5
.....
.._..
./X\.
.\_/.
.....
 */