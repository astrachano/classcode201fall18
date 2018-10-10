

public class IntLinkDemo {
	private class Node{
		int info;
		Node next;
		public Node(int key, Node link){
			this.info = key;
			this.next = link;
		}
	}
	
	public void print(Node list) {
		while (list != null) {
			System.out.printf("%d,",list.info);
			list = list.next;
		}
		System.out.println();
	}
	public int calc(Node list) {
		int t = 0;
		while (list != null) {
			t += list.info;
			list = list.next;
		}
		return t;
	}
	
	public Node build3() {
		Node a = new Node(9,null);
		Node b = new Node(6,null);
		Node c = new Node(3,null);
		
		// what is list c here?
		
		c.next = b;
		b.next = a;
		// what is list c here?
		
		//a.next = c;
		// what is list c here?
		
		return c;
	}
	
	
	public void demo() {
		Node first = new Node(1,
				       new Node(2,
				         new Node(3,null)));
		int a = calc(first);
		int b = calc(first);
		int total = a + b;
		System.out.println(total);
		
		Node xx = build3();
		print(xx);
	}
	public static void main(String[] args) {
		IntLinkDemo x = new IntLinkDemo();
		x.demo();
	}
}
