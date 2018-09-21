import java.util.*;

public class WrappedStringDriver {
	public static void main(String[] args) {
		String[] array = {"apple", "pear", "cherry", "lemon"};
		ArrayList<StringWrapper> list = new ArrayList<>();
		for(String s : array) {
			list.add(new StringWrapper(s));
		}
		HashSet<StringWrapper> set = new HashSet<>();
		for(StringWrapper sw : list) {
			set.add(sw);
			set.add(new StringWrapper(sw));
		}
		
		System.out.printf("list = %d set = %d\n",list.size(), set.size());
		for(StringWrapper sw : set) {
			System.out.println(sw);
		}
		System.out.printf("stats: %s\n", StringWrapper.getInfo());
	}
}
