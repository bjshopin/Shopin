import java.util.Scanner;

public class A {
    /**
     * 
     * SUM_3+SUM+5-SUM_15;
     *
     * @param sum
     * @return
     */
    public static long sum(int sum, int n) {
        int l;
        long top, buttom;
        l = sum / n;
        buttom = n;
        top = l * n;
        //sum = (top + buttom) * l / 2;
        return (buttom + top) * l / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t, num, sum;
        t = input.nextInt();
        while (t-- > 0) {
            sum = 0;
            num = input.nextInt();
            System.out.println(sum(num - 1, 3) + sum(num - 1, 5) - sum(num - 1, 15));
            //3 6 9 12 15
        }
    }
}