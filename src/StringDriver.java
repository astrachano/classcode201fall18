import java.util.*;
import java.io.*;

public class StringDriver {
	
	public static int benchmark(Set<String> set, String filename) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(filename));
		int total = 0;
		while (scan.hasNext()) {
			String s = scan.next();
			set.add(s);
			total += 1;
		}
		scan.close();
		return total;
	}
	
	public static int benchmarkWrap(Set<StringWrapper> set, String filename) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(filename));
		int total = 0;
		while (scan.hasNext()) {
			String s = scan.next();
			set.add(new StringWrapper(s));
			total += 1;
		}
		scan.close();
		return total;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String[] plays = {"allswell.txt", "caesar.txt",	"errors.txt",
				          "hamlet.txt", "likeit.txt", "macbeth.txt",
				          "romeo.txt", "tempest.txt"};
		
		HashSet<StringWrapper> hsetwrap = new HashSet<>();
		TreeSet<StringWrapper> tsetwrap = new TreeSet<>();
		
		double start,end,time;
		
		
		start = System.nanoTime();
		for(String play : plays) {
			String fname = "data/shakes/" + play;
			benchmarkWrap(hsetwrap,fname);
		}
		end = System.nanoTime();
		time = (end-start)/1e9;
		System.out.printf("wrapper stats = %s\n", StringWrapper.getInfo());
		System.out.printf("hashwrap time: %1.3f, size = %d\n",time,hsetwrap.size());
		
		start = System.nanoTime();
		for(String play : plays) {
			String fname = "data/shakes/" + play;
			benchmarkWrap(tsetwrap,fname);
		}
		end = System.nanoTime();
		time = (end-start)/1e9;
		System.out.printf("wrapper stats = %s\n", StringWrapper.getInfo());
		System.out.printf("treewrap time: %1.3f, size = %d\n",time,tsetwrap.size());		         
		HashSet<String> hset = new HashSet<>();
		TreeSet<String> tset = new TreeSet<>();
		
		start = System.nanoTime();
		int total = 0;
		for(String play : plays) {
			String fname = "data/shakes/" + play;
			total += benchmark(hset,fname);
		}
		end = System.nanoTime();
		time = (end-start)/1e9;
		System.out.printf("hash time: %1.3f, size = %d\n",time,hset.size());
		System.out.printf("total words read = %d\n", total);
		
		start = System.nanoTime();
		for(String play : plays) {
			String fname = "data/shakes/" + play;
			benchmark(tset,fname);
		}
		end = System.nanoTime();
		time = (end-start)/1e9;
		System.out.printf("tree time: %1.3f, size = %d\n",time,tset.size());
		
		
	}
}
