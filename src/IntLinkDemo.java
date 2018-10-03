

public class IntLinkDemo {
	private class Node{
		int info;
		Node next;
		public Node(int key, Node link){
			this.info = key;
			this.next = link;
		}
	}
	
	public int calc(Node list) {
		int t = 0;
		while (list != null) {
			t += list.info;
			list = list.next;
		}
		return t;
	}
	
	public void demo() {
		Node first = new Node(1,
				       new Node(2,
				         new Node(3,null)));
		int a = calc(first);
		int b = calc(first);
		int total = a + b;
		System.out.println(total);
	}
	public static void main(String[] args) {
		IntLinkDemo x = new IntLinkDemo();
		x.demo();
	}
}
