import java.util.*;
import java.io.*;

public class WordLaddersFull {
	/**
	 * Return true if a and b differ by exactly one
	 * character, e.g., "spore" and "spare"
	 * @return true if a and b are one apart, else false
	 */
	private boolean oneAway(String a, String b){
		int count = 0;
		
		for(int k=0; k < a.length(); k++){
			if (a.charAt(k) != b.charAt(k)){
				count++;
			}
			if (count > 1) return false;
		}
		return count == 1;
	}
	
	/**
	 * Read a file that has white-space separated words
	 * @param filename is name of file with words
	 * @return array of words read
	 * @throws FileNotFoundException if file can't be open
	 */
	private String[] loadWords(String filename) throws FileNotFoundException{
		ArrayList<String> list = new ArrayList<>();

			Scanner scan = new Scanner(new File(filename));
			while (scan.hasNext()) {
				list.add(scan.next());
			}
			scan.close();
			return list.toArray(new String[0]);
	}
	public String createPath(String last, String first,
			                 Map<String,String> path) {
		StringBuffer sb = new StringBuffer();
		String current = last;
		while (! current.equals(first)) {
			sb.append(current);
			sb.append(" ");
			current = path.get(current);
		}
		sb.append(first);
		return sb.toString().trim();
	}
	
	/**
	 * Find and return shortest ladder between
	 * first and last, using words as "rungs"
	 * @return the word ladder, if it exists
	 */
	public String findLadder(String[] words, String first, String last) {
		Queue<String> qu = new LinkedList<>();
		Set<String> set = new HashSet<>();
		Map<String,String> map = new HashMap<>();
		
		qu.add(first); 
		while (qu.size() > 0) {
			String current = qu.remove();
			
			if (current.equals(last)) {
				return createPath(last,first,map);
			}
			
			for(String word : words){
				if(!set.contains(word) && oneAway(word,current)) {
					set.add(word);
					qu.add(word);
					map.put(word,current);
				}
			}
		}
		return "no ladder from "+first+" to "+last;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		WordLaddersFull ladder = new WordLaddersFull();
		String filename = "data/kwords5.txt";
		String[] words = ladder.loadWords(filename);
		
		Scanner scan = new Scanner(System.in);
		System.out.print("ladder from to: ");
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] data = line.split("\\s+");
			if (data.length != 2) break;
			String result = ladder.findLadder(words, data[0]	, data[1]);
			System.out.printf("%s\n", result);
			System.out.print("ladder from to: ");
		}
		scan.close();
	}
}

