
public class DoubleLink {
	public class Node {
		String info;
		Node next;
		Node prev;
		
		public Node(String s, Node before, Node after) {
			info = s;
			prev = before;
			next = after;
		}
	}
	public Node deleteAllRec(Node list, String target) {
		if (list == null) return null;
		Node after = deleteAllRec(list.next,target);
		if (list.info.equals(target)) {
			if (after != null) {
				after.prev = null;
			}
			return after;
		}
		// first node good, not equal to target
		if (after == null) {
			list.next = null;
			return list;
		}
		after.prev = list;
		list.next = after;
		return list;
	}
	public Node deleteAll(Node list, String target) {
		Node current = list;
		while (current != null) {
			if (current.info.equals(target)) {
				current.prev.next = current.next;
				current.next.prev = current.prev;
			}
			current = current.next;
		}
		return list;
	}
	public void printRev(Node list) {
		// find last node
		while (list != null && list.next != null) {
			list = list.next;
		}
		while (list != null) {
			System.out.printf("%s,", list.info);
			list = list.prev;
		}
		System.out.println();
	}
	public void print(Node list) {
		while (list != null) {
			System.out.printf("%s,", list.info);
			list = list.next;
		}
		System.out.println();
		
	}
	
	public void deleteDemo() {
		String[] words = {"dog", "cat", "ant", "cat", "dog", "cat","ant","ant"};
		Node list = null;
		for(String s : words) {
			list = new Node(s,null,list);
			if (list.next != null) {
				list.next.prev = list;
			}
		}
		print(list);
		printRev(list);
		list = deleteAll(list,"cat");
		print(list);
		printRev(list);
	}
	public static void main(String[] args) {
		DoubleLink demo = new DoubleLink();
		demo.deleteDemo();
	}
}
