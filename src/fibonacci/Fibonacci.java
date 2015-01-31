package fibonacci;

/**
 * Created by alshevchuk on 31.01.2015.
 */
public class Fibonacci {
    private static int quantity = 10;//quantity of Fibonacci elements
    private static int f0 = 1;
    private static int f1 = 1;

    public static void main(String[] args) {
        System.out.println(f0);
        System.out.println(f1);
        new Fibonacci().calc();

        System.out.println("==============================");

        quantity = 10;
        System.out.println(f0=1);
        System.out.println(f1=1);
        new Fibonacci().calcRecursive();
    }

    void calc() {
        while (quantity >= 0) {
            int res = f0 + f1;
            System.out.println(res);
            f0 = f1;
            f1 = res;
            quantity--;
        }
    }

    void calcRecursive() {
        if (quantity >= 0) {
            int res = f0 + f1;
            System.out.println(res);
            f0 = f1;
            f1 = res;
            quantity--;
            calcRecursive();
        }
    }
}