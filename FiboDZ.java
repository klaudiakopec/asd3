package asd_lab_3.dzielzwyciezaj;

class FiboDZ {

    public static void main(String[] args) {
        //final int N = 10; // n-ty wyraz ciagu
        //System.out.println(fibo(N));
        System.out.println(fibo(10));
    }

    public static int fibo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}
