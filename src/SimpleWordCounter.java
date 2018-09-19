import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SimpleWordCounter {
   
	/**
	 * Returns index of first occurrence of word in list, -1 if not in list
	 * @param list is searched
	 * @param word is string being searched for
	 * @return index of first occurrence, or -1 if no occurrence of word in list
	 */
	private int indexOf(String[] list, String word){
		for(int k=0; k < list.length; k += 1){
			if (list[k].equals(word)) {
				return k;
			}
		}
		return -1;
	}
	
	/**
	 * Returns word and count for word that occurs most often in File
	 * @param f is file searched for
	 * @return "word:count" for word in file for which count is maximal
	 * @throws FileNotFoundException
	 */
	public String methodA(File f) throws FileNotFoundException{
		ArrayList<String> words = new ArrayList<>();
		ArrayList<Integer> counter = new ArrayList<>();
		
		Scanner s = new Scanner(f);
		while (s.hasNext()){
			
			String w = s.next();
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
		s.close();
		return maxString+":"+max;
	}
	
	/**
	 * Returns word and count for word that occurs most often in File
	 * @param f is file searched for
	 * @return "word:count" for word in file for which count is maximal
	 * @throws FileNotFoundException
	 */
	public String methodB(File f) throws FileNotFoundException{
		ArrayList<String> words = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		
		Scanner s = new Scanner(f);
		while (s.hasNext()){
			String w = s.next();
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
		s.close();
		return maxString+":"+max;
	}
	
	/**
	 * Returns word and count for word that occurs most often in File
	 * @param f is file searched for
	 * @return "word:count" for word in file for which count is maximal
	 * @throws FileNotFoundException
	 */
	public String methodC(File f) throws FileNotFoundException{
		HashMap<String,Integer> map = new HashMap<>();
		
		Scanner s = new Scanner(f);
		while (s.hasNext()){
			String w = s.next();
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
		s.close();
		return maxString+":"+max;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		SimpleWordCounter counter = new SimpleWordCounter();
		File f = FileSelector.selectFile();
		
		double start = System.nanoTime();
		String sa = counter.methodA(f);
		double end = System.nanoTime();
		double atime = (end-start)/1e9;
		
		start = System.nanoTime();
		String sb = counter.methodB(f);
		end = System.nanoTime();
		double btime = (end-start)/1e9;
		
		start = System.nanoTime();
		String sc = counter.methodC(f);
		end = System.nanoTime();
		double ctime = (end-start)/1e9;
		
		System.out.printf("method a %s with %3.4f\n",sa,atime);
		System.out.printf("method b %s with %3.4f\n",sb,btime);
		System.out.printf("method c %s with %3.4f\n",sc,ctime);
	}
}
