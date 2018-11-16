
public class Fibonacci {
	public static long fib(int n) {
		if (n <= 2) return 1;
		long a = 1;
		long b = 1;
		for(int k=0; k < n-1; k++) {
			long sum = a + b;
			a = b;
			b = sum;
		}
		return a;
	}
	public static long rfib(int n) {
		if (n <= 2) return 1;
		return rfib(n-1) + rfib(n-2);
	}
	
	public static void main(String[] args) {
		for(int k=1; k <= 50; k++) {
			System.out.printf("%d\t%d\n",k,rfib(k));
		}
	}
}
