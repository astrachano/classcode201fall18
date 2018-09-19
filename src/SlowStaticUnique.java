import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SlowStaticUnique {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(new File("/data/kjv10.txt"));
		HashSet<String> list = new HashSet<>();
		int wcount = 0;
		double start = System.nanoTime();

		while (s.hasNext()) {
			wcount += 1;
			String word = s.next();
			if (! list.contains(word)) {
				list.add(word);
			}
		}
		double end = System.nanoTime();
		System.out.printf("total #: %d, unique #: %d\n" , 
				          wcount, list.size());
		System.out.printf("time: %2.3g\n", (end-start)/1e9);
        s.close(); 
    }
}
