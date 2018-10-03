
public class StringWrapper implements Comparable<StringWrapper>{
	private String myString;
	private static int ourHashCount;
	private static int ourEqualsCount;
	private static int ourComparableCount;
	
	public StringWrapper(String s) {
		myString = s;
	}
	
	public StringWrapper(StringWrapper sw) {
		myString = sw.myString;
	}
	
	@Override
	public int hashCode() {
		ourHashCount += 1;
		System.out.println("hash called on "+myString);
		//return myString.hashCode();
		return 5;
	}
	
	@Override
	public boolean equals(Object o) {
		ourEqualsCount += 1;
		System.out.println("equal called on "+myString);
		if (o.getClass() != this.getClass()) {
			return false;
		}
		StringWrapper other = (StringWrapper) o;
		String ostr = other.myString;
		return myString.equals(ostr);
	}
	
	@Override
	public String toString() {
		return myString;
	}
	
	/**
	 * Return a string with statistics about internal calls
	 * of hashCode, equals, and comparable. Also resets internal
	 * counters of each to zero
	 * @return a string containing information about calls
	 */
	public static String getInfo() {
		String ret = String.format("hash = %d, equals = %d comp = %d", 
				                   ourHashCount,ourEqualsCount,ourComparableCount);
		ourHashCount = 0;
		ourEqualsCount = 0;
		ourComparableCount = 0;
		return ret;
	}

	@Override
	public int compareTo(StringWrapper o) {
		ourComparableCount += 1;
		return myString.compareTo(o.myString);
	}
}
