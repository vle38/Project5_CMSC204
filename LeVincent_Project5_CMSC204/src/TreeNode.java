// This class is linked with the LinkedConverterTreeInterface class.
public class TreeNode<T> {

	public T data;
	public TreeNode<T> leftNode;
	public TreeNode<T> rightNode;
	
	// Constructor method which creates instance nodes/variables for each individual tree. 
	public TreeNode(T data) {
		
		// Instance variable data which stores the data of a specific node.
		this.data = data;
		// Instance variable which allows the creation of a left child node in a tree, current set to null.
		this.leftNode = null;
		// Instance variable which allows the creation of a right child node in a tree, current set to null.
		this.rightNode = null;
		
	}
	
	// Shallow copy method which makes a copy of a node by creating a new node/variable storing the information of the previous node/variable.
	public TreeNode(TreeNode<T> treeNode) {
		
		// Copy of the variable data which is initialized with the instance variable's information from the constructor method. 
		this.data = treeNode.data;
		// Copy of the left child node which is initialized with the instance node's information from the constructor method. 
		this.leftNode = treeNode.leftNode;
		// Copy of the right child node which is initialized with the instance node's information from the constructor method. 
		this.rightNode = treeNode.rightNode;
		
	}
	
	
	// getLeftNode method which gathers the data stored within the left child node and returns the node when the method is executed.
	public TreeNode<T> getLeftNode() {
		
		// Returns information contained in the left node when the method is executed.
		return leftNode;
		
	}
	
	// getRightNode method which gathers the data stored within the right child node and returns the node when the method is executed.
	public TreeNode<T> getRightNode() {
		
		// Returns information contained in the right node when the method is executed.
		return rightNode;
		
	}
	
	// setLeftNode method which initializes the instance left node with information gathered from the parameter. 
	public void setLeftNode(TreeNode<T> leftNode) {
		
		// Instance left node is initialized with the value stored in the method's parameter. 
		this.leftNode = leftNode;
		
	}
	
	// setRightNode method which initializes the instance right node with information gathered from the parameter. 
	public void setRightNode(TreeNode<T> rightNode) {
		
		// Instance right node is initialized with the value stored in the method's parameter. 
		this.rightNode = rightNode;
		
	}
	
	// getData method which returns the information stored in the variable data.
	public T getData() {
		
		// Returns anything contained in "data" when the method is executed. 
		return data;
	}
	
	// setData method which initializes an instance variable with information stored in the method's parameter.
	public void setData(T data) {
		
		// Instance variable data is initialized with the value of the method's parameter. 
		this.data = data;
	}
	
	
	
	
	
	
	
	
	
	
	
}
