package tree;

public class Tree {
	static TreeNode root;
	public static void main(String[] args) {
		Tree t = new Tree();
		t.insert(root, 10);
	}
	
	//Create a Binary Search Tree
	//Left Node < Root <= Right Node
	public TreeNode insert(TreeNode root, int val) {
		if(root == null) {
			root = new TreeNode(val);
		}
		if(val < root.value) {
			root.left = insert(root.left, val);
		} 
		if(val > root.value){
			root.right = insert(root.right, val);
		}
		return root;
	}
}

class TreeNode{
	int value;
	TreeNode left, right;
	
	TreeNode(int val){
		this.value = val;
	}
}
