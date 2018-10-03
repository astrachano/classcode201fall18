
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
		String[] vg = {"squash", "corn", "artichoke",
				       "peas", "asparagus"};
		
		LowLevelLinkDemo ld = new LowLevelLinkDemo();
		Node list1 = ld.createList(vg);
		Node list2 = ld.createListFront(vg);
		
		ld.print(list1);
		ld.print(list2);
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
	private void print(Node list) {
		while (list != null) {
			System.out.printf("%s,", list.info);
			list = list.next;
		}
		System.out.println();
	}
	private void print(String[] list) {
		int index = 0;
		while (index < list.length) {
			System.out.printf("%s,",list[index]);
			index += 1;
		}
		System.out.println();
	}
}
