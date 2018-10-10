
public class Factorial {
	public static int factorial(int n) {
		int prod = 1;
		for(int k=2; k <= n; k += 1) {
			prod *= k;
		}
		return prod;
	}
	public static int fact(int n) {
		if (n == 1) return 1;
		return n * fact(n-1);
	}
	public static void main(String[] args) {
		int first = 10;
		int last = 20;
		for(int k=first; k <= last; k += 1) {
			int f1 = factorial(k);
			int f2 = fact(k);
			System.out.printf("%d\t%d\t%d\n", k,f1,f2);
		}
	}
}
