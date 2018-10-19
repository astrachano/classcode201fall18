
public class StringPlay {
	
	/**
	 * Create s+s+s+ ...+s and return it
	 * @param s is the string to be repeated
	 * @param reps is the number of times to repeat s
	 * @return sssss....ss (there are reps s's
	 */
	public String stringConcat(String s, int reps) {
		String ret = "";
		for(int k=0; k < reps; k++) {
			ret += s;
		}
		return ret;
	}
	
	/**
	 * Create s+s+s+ ...+s and return it, uses StringBuilder internally 
	 * @param s is the string to be repeated
	 * @param reps is the number of times to repeat s
	 * @return sssss....ss (there are reps s's
	 */
	public String builderConcat(String s, int reps) {
		StringBuilder ret = new StringBuilder();
		for(int k=0; k < reps; k++) {
			ret.append(s);
		}
		return ret.toString();
	}
	 
	public static void main(String[] args) {
		StringPlay sp = new StringPlay();
		String source = "hello";
		int first = 10000;
		int last = 200000;
		int incr = 10000;
		for(int k=first; k <= last; k += incr) {
			double start = System.nanoTime();
			String ss = sp.stringConcat(source, k);
			double end = System.nanoTime();
			double stringTime = (end-start)/1e9;
			start = System.nanoTime();
			String bs = sp.builderConcat(source, k);
			end = System.nanoTime();
			double buildTime = (end-start)/1e9;
			System.out.printf("%d\t%1.3f\t%d\t%1.3f\n", 
					          ss.length(),stringTime,
					          bs.length(),buildTime);
		}
	}
}
