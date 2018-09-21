import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountingStringsBenchmark {
	private static final int SEED = 1234;
	private static final int MIN_LEN = 5;
	private static final int MAX_LEN = 15;
	private static final int REPS = 1;
	
	public static List<String> getRandomStrings(int size){
		ArrayList<String> list = new ArrayList<>();
		String[] alph = {"a","b","c","d","e","f","g","h","i","j",
				         "k","l","m","n","o","p","q","r","r","s",
				         "t","u","v","w","x","y","z"};
	
		List<String> alist = Arrays.asList(alph);
		Random rand = new Random(SEED);
		while (list.size() < size) {
			int start = rand.nextInt(alist.size() - MAX_LEN);
			int end = start + MIN_LEN + rand.nextInt(MAX_LEN-MIN_LEN);
			List<String> word = alist.subList(start, end);
			Collections.shuffle(word,rand);
			int reps = 1; //rand.nextInt(REPS) + 1;
			for(int k=0; k < reps; k+=1) {
				if (list.size() == size) break;
				list.add(String.join("",word));
			}	
		}		
		return list;
	}
	
	public static String parallelArrays(List<String> list) {
		ArrayList<String> words = new ArrayList<>();
		ArrayList<Integer> counter = new ArrayList<>();
		
		for(String w : list) {
			int index = words.indexOf(w);			
			if (index == -1){
				words.add(w);
				counter.add(1);
			}
			else {
				counter.set(index, counter.get(index) + 1);   // already found, increment count
			}
		}
		
		// find largest # occurrences and retain value and string
		int max = 0;
		String maxString = "";
		for(int k=0; k < counter.size(); k += 1){
			if (counter.get(k) > max) {
				max = counter.get(k);
				maxString = words.get(k);
			}
		}
		return maxString+":"+max;
	}
	
	public static String binarySearch(List<String> list) {
		ArrayList<String> words = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		
		for(String w : list) {
			words.add(w);
			set.add(w);
		}
		
		Collections.sort(words);
		
		int max = 0;
		String maxString = "";
		for(String word : set) {
			int index = Collections.binarySearch(words, word);
			int first = index-1;  
			int last = index+1;
			
			// invariant: word in interval (first,last) of list words
			while (0 < first && words.get(first).equals(word)){
				first -= 1;
			}
			while (last < words.size() && words.get(last).equals(word)){
				last += 1;
			}
			int count = last-first-1;  // number of times word occurs in words
			if (count > max) {
				max = count;
				maxString = word;
			}
		}
		return maxString+":"+max;
	}
	public static String mapping(List<String> list) {
		HashMap<String,Integer> map = new HashMap<>();
		
		for(String w : list) {
			if (map.containsKey(w)) {
				map.put(w, map.get(w) + 1);
			}
			else {
				map.put(w, 1);
			}
		}
		int max = Collections.max(map.values());
		String maxString = null;
		for(String word : map.keySet()) {
			if (map.get(word) == max) {
				maxString = word;
				break;
			}
		}
		return maxString+":"+max;
	}
	
	public static void main(String[] args) {

		int first = 10000;
		int last = 100000;
		int incr = 10000;
		for(int size = first; size <= last; size += incr) {
			List<String> list = getRandomStrings(size);
			double start = System.nanoTime();
			//String max = parallelArrays(list);
			//String max = binarySearch(list);
			String max = mapping(list);
			double end = System.nanoTime();
			double time = (end-start)/1e9;
			System.out.printf("%d\t%1.3f\t%s\n", list.size(),time,max);
		}
	}
}
