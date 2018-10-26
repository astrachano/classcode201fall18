import java.util.*;
import java.io.*;

//ola

public class TreeDemo {
	private class TreeNode {
        String info;
        TreeNode left;
        TreeNode right;

        TreeNode(String s, TreeNode lptr, TreeNode rptr) {
            info = s;
            left = lptr;
            right = rptr;
        }
    }
	
	public int count(TreeNode root) {
		if (root == null) return 0;
		return 1 + count(root.left) + count(root.right);
	}
	public TreeNode add(TreeNode root, String value) {
		if (root == null) {
			root = new TreeNode(value,null, null);
			return root;
		}
		int comp = value.compareTo(root.info);
		if (comp == 0) return root;
		if (comp < 0) {
			root.left = add(root.left,value);
		}
		else {
			root.right = add(root.right,value);
		}
		return root;
	}
	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.info);
			inOrder(root.right);
		}
	}
	
	public void preOrder(TreeNode root) {
		if (root != null) {
			System.out.println(root.info);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.info);
		}
	}
	
	public void whatOrder(TreeNode root) {
		LinkedList<TreeNode> list = new LinkedList<>();
		if (root != null) {
			list.add(root);
		}
		while (list.size() > 0) {
			root = list.remove(0);
			System.out.printf("%s\n",root.info);
			if (root.left != null) list.add(root.left);
			if (root.right != null) list.add(root.right);
		}
	}
	
	public int height(TreeNode root) {
		if (root == null) return 0;
		return 1+ Math.max(height(root.left), height(root.right));
	}
	
	public void demo() {
		String[] words = {"macaque", "chimp", "monkey", "lemur",
				          "tamarin", "orangutan", "baboon"};
		TreeNode root = null;
		for(String s : words) {
			root = add(root,s);
		}
		inOrder(root);
		System.out.println("-----");
		whatOrder(root);
		System.out.println("-----");
		Iterator<String> iter = new TreeIterator(root);
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public class TreeIterator implements Iterator<String> {
		
		private ArrayList<TreeNode> myStack;

		public TreeIterator(TreeNode root) {
			myStack = new ArrayList<>();
			while (root != null) {
				myStack.add(root);
                root = root.left;
            }
		}
		@Override
		public boolean hasNext() {
			 return myStack.size() > 0;
		}

		@Override
		public String next() {
	        TreeNode t = myStack.remove(myStack.size()-1);
			String data = t.info;
			findSuccessor(t);
	        return data;
		}
		
		private void findSuccessor(TreeNode t) {
			if (t == null)
	            return;               // no successor
	        if (t.right != null) {    // has a right child
	            t = t.right;
	            while (t != null) {
	            	myStack.add(t);
	                t = t.left;
	            }
	        }
		}
		
	}
	
	public void testIter() throws FileNotFoundException {
		TreeSet<String> set = new TreeSet<>();
		TreeNode root = null;
		ArrayList<String> lista = new ArrayList<>();
		ArrayList<String> listb = new ArrayList<>();
		Scanner scan = new Scanner(new File("/data/darwin.txt"));
		while (scan.hasNext()) {
			String s = scan.next();
			set.add(s);
			root = add(root,s);
		}
		for(String s : set) lista.add(s);
		Iterator<String> iter = new TreeIterator(root);
		while (iter.hasNext()) listb.add(iter.next());
		System.out.printf("list sets equal %s %d %d\n ",lista.equals(listb),
				           lista.size(), count(root));
	}
	
	public int diameter(TreeNode t) {
		if (t == null) return 0;
		int rootPath = height(t.left) + height(t.right) + 1;
		return Math.max(rootPath,
				        Math.max(diameter(t.left),diameter(t.right)));
	}
	public static void main(String[] args) throws FileNotFoundException {
		TreeDemo td = new TreeDemo();
		td.demo();
		td.testIter();
	}
}
