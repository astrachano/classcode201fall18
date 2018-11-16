import java.util.*;

public class CompareDemo {
	public static void print(String[] list) {
		String s = String.join(",",list);
		System.out.println(s);
	}
	public static void main(String[] args) {
		String[] list = {"zebra", "aardvark", "yak", "bee"};
		print(list);
		Arrays.sort(list);
		print(list);
		Arrays.sort(list, Comparator.reverseOrder());
		print(list);
		Arrays.sort(list, Comparator.comparing(String::length));
		print(list);
		Arrays.sort(list, Comparator.comparing(String::length)
				                    .thenComparing(String::compareTo));
		print(list);
	}
}
