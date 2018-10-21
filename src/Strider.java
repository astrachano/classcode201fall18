
public class Strider {
	public int smallFirst(String[] codons, String dna) {
		int total = 0;
		for(String cod : codons) {
			for(int k=0; k < dna.length(); k+=3) {
				//if (dna.substring(k, k+3).equals(cod)) {
				if (dna.regionMatches(k, cod, 0, 3)) {
					total += 1;
				}
			}
		}
		return total;
	}
	
	public int bigFirst(String[] codons, String dna) {
		int total = 0;
		
		for(int k=0; k < dna.length(); k+=3) {
			for(String cod : codons) {
				if (dna.regionMatches(k, cod, 0, 3)) {
					total += 1;
				}
			}
		}
		return total;
	}
	
	public void doTime() {
		String[] codons = {"gac", "tag", "act", "ggg"};
		String base = "gactagactggg";
		StringBuilder dna = new StringBuilder();
		int repeats = 10000000;
		for(int k=0; k < repeats; k++) {
			dna.append(base);
		}
		String sdna = dna.toString();
		
		double start = System.nanoTime();
		int smalls = smallFirst(codons,sdna);
		double end = System.nanoTime();
		double smallTime = (end-start)/1e9;
		
		start = System.nanoTime();
		int bigs = bigFirst(codons,sdna);
		end = System.nanoTime();
		double bigTime = (end-start)/1e9;
		
		System.out.printf("small:\t%d in %1.3f\n", smalls,smallTime);
		System.out.printf("big:\t%d in %1.3f\n", bigs,bigTime);
	}
	
	public static void main(String[] args) {
		Strider st = new Strider();
		st.doTime();
	}
}
