import java.util.ArrayList;

public class LowLevelLinkDemo {
	private class Node{
		String info;
		Node next;
		public Node(String key, Node link){
			this.info = key;
			this.next = link;
		}
	}
	
	public static void main(String[] args) {
		String[] vg = {"squash", "corn", "artichoke", "asparagus",
				       "peas", "corn", "squash","asparagus"};
		
		LowLevelLinkDemo ld = new LowLevelLinkDemo();
		Node list1 = ld.createList(vg);
		Node list2 = ld.createListFront(vg);
		
		System.out.println(ld.toString(list1));
		//ld.print(list2);
		list1 = ld.deleteAll(list1, "asparagus");
		System.out.println(ld.toString(list1));
		list1 = ld.deleteAll(list1,"squash");
		System.out.println(ld.toString(list1));
	}

	private Node deleteAllRec(Node list, String target) {
		if (list == null) return null;
		
		Node after = deleteAllRec(list.next, target);
		if (list.info.equals(target)) {
			return after;
		}
		list.next = after;
		return list;
	}
	
	private Node deleteAll(Node list, String target) {
	    Node first = list;
	    if (first == null) return null;
	    
	    // invariant: list != null
	    while (list.next != null) {
	    	if (list.next.info.equals(target)) {
	    		list.next = list.next.next;
	    	}
	    	else {
	    		list = list.next;
	    	}
	    }
	    // all done except first node
	    if (first.info.equals(target)) {
	    	return first.next;
	    }
	    return first;
	}
	private Node createList(String[] vg) {
		Node first = new Node(vg[0], null);
		Node last = first;
		for(int k=1; k < vg.length; k += 1) {
			last.next = new Node(vg[k],null);
			last = last.next;
		}
		return first;
	}
	private Node createListFront(String[] vg) {
		Node first = null;
		for(int k=0; k < vg.length; k += 1) {
			Node nf = new Node(vg[k],first);
			first = nf;
		}
		return first;
	}
	private String toString(Node list) {
		ArrayList<String> array = new ArrayList<>();
		
		while (list != null) {
			array.add(list.info);
			list = list.next;
		}
		return String.join(",", array);
	}
}
