import java.util.*;

public class ListRemove {
	private String[] myWords = {"apple", "banana", "guava"};
	private Random myRandom = new Random();
	
	public List<String> fill(int count, List<String> proto){
		proto.clear();
		for(int k=0; k < count; k += 1) {
			int index = myRandom.nextInt(myWords.length);
			proto.add(myWords[index]);
		}
		return proto;
	}
	
	public List<String> removeAll(String target, List<String> list){
		for(String w : list) {
			if (w.equals(target)) {
				list.remove(w);
			}
		}
		return list;
	}
	
	public List<String> removeAllIterator(String target, List<String> list) {
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String w = iter.next();
			if (w.equals(target)) {
				iter.remove();
			}
		}
		return list;
	}
	
	public List<String> removeAllWrong(String target, List<String> list) {
		for(int k=0; k < list.size(); k++) {
			String w = list.get(k);
			if (w.equals(target)) {
				list.remove(k);
			}
		}
		return list;
	}
	
	public List<String> removeAllGack(String target, List<String> list) {
		//int sz = list.size();
		for(int k=0; k < list.size(); k++) {
			String w = list.get(k);
			if (w.equals(target)) {
				list.remove(k);
				k -= 1;
			}
		}
		return list;
	}
	public double timeRemove(List<String> list, int repSize) {
		myRandom.setSeed(123456);
		fill(repSize,list);
		double start = System.nanoTime();
		String target = list.get(0);
		int presize = list.size();
		int tsize = Collections.frequency(list, target);
		//removeAllGack(list.get(0),list);
		//removeAllWrong(list.get(0),list);
		removeAllIterator(list.get(0),list);
		double end = System.nanoTime();
		if (list.size() != presize-tsize) {
			System.out.printf("error on remove %d occurrences of %s from %d: %d not %d\n", tsize,target,presize,list.size(),presize-tsize);
		}
		return (end-start)/1e9;
	}
	public static void main(String[] args) {
		final int SIZE = 1000000;
		
		LinkedList<String> llist = new LinkedList<>();
		ArrayList<String> alist = new ArrayList<>();
		ListRemove remove = new ListRemove();
		double ltime = remove.timeRemove(llist, SIZE);
		double atime = remove.timeRemove(alist, SIZE);
		
		System.out.printf("array time = %1.3f\n", atime);
		System.out.printf("linked time = %1.3f\n", ltime);
		
	}
}
