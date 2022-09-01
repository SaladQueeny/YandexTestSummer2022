import java.util.*;

public class E {

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Rectangle {
        public Point A;
        public Point B;
        public Point C;
        public Point D;

        public Rectangle(Point A, Point B, Point C, Point D) {
            this.A = A;
            this.B = B;
            this.C = C;
            this.D = D;
        }

    }

    static boolean check(Rectangle a, Rectangle b) {
        return !(a.B.y <= b.D.y || a.D.y >= b.B.y || a.D.x <= b.B.x || a.B.x >= b.D.x);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        Rectangle[] rects = new Rectangle[n];
        int[][] rectangles = new int[n][4];
        int[] countOfIntersection = new int[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            //                           A                B                 C                  D
//            rects[i] = new Rectangle(new Point(x, y), new Point(x, y1), new Point(x1, y1), new Point(x1, y));
            rectangles[i][0] = x;
            rectangles[i][1] = y;
            rectangles[i][2] = x1;
            rectangles[i][3] = y1;
            if (i > 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (!(y1 <= rectangles[j][1] || y >= rectangles[j][3] || x1 <= rectangles[j][0] || x >= rectangles[j][2])) {
                        countOfIntersection[i]++;
                        countOfIntersection[j]++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(countOfIntersection[i] + " ");
        }
    }
}
/*

B............C
.            .
.            .
A............D



6
-2 -4 2 2
-2 -4 0 -1
-2 -1 0 2
0 -4 2 -1
0 -1 2 2
-1 -2 1 0


0 - left
 */