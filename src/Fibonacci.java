
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
	static long [] memo = new long[5000];
	public static long rfib(int n) {
		if (n <= 2) return 1;
		if (memo[n] != 0) {
			return memo[n];
		}
		memo[n] = rfib(n-1) + rfib(n-2);
		return memo[n];
	}
	
	public static void main(String[] args) {
		for(int k=1; k <= 50; k++) {
			System.out.printf("%d\t%d\n",k,rfib(k));
		}
	}
}
