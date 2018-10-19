

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
	
	public TreeNode add(TreeNode root, String value) {
		if (root == null) {
			root = new TreeNode(value,null, null);
			return root;
		}
		int comp = value.compareTo(root.info);
		if (comp <= 0) {
			root.left = add(root.left,value);
		}
		else {
			root.right = add(root.right,value);
		}
		return root;
	}
	public void print(TreeNode root) {
		if (root != null) {
			print(root.left);
			System.out.println(root.info);
			print(root.right);
		}
	}
	
	public void demo() {
		String[] words = {"dog", "cat", "elephant", "ant", "fox", "bat"};
		TreeNode root = null;
		for(String s : words) {
			root = add(root,s);
		}
		print(root);
	}
	public static void main(String[] args) {
		TreeDemo td = new TreeDemo();
		td.demo();
	}
}
