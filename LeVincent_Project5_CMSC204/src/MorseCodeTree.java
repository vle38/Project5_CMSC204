import java.util.ArrayList;

// MorseCodetree class which establishes a tree containing nodes for all morse code letters, implements all abstract methods from the LinkedConverterTreeInterface class.
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	// Declaration of an object rootNode as apart of the TreeNode generic object. 
	public TreeNode<String> rootNode;
	
	
	// getRootNode method which returns the root node when the method is executed.
	public TreeNode<String> getRootNode() {
		
		// Root node is returned when the method is executed. 
		return rootNode;
		
	}
	
	// setRootNode method which initializes an instance node with the value in the method's parameter. 
	public void setRootNode(TreeNode<String> rootNode) {
		
		// Instance node rootNode is initialized with the method's parameter when the method is executed. 
		this.rootNode = rootNode;
		
	}
	
	// Insert method which adds a node into the tree, with the node being initialized with the letter and its morse code.
	public void insert(String morseCode, String letter) {
		
		// addNode method is executed with information from the insert method's parameters initializing a root node in the tree. 
		addNode(rootNode, morseCode, letter);
		// return this;
	}
	
	// addNode method which allows a node to be added into a tree containing morse code information and the letter representing the morse code.
	public void addNode(TreeNode<String> currentNode, String morseCode, String letter) {
		
		
		// Note to self:
		// . -> Left node
		// - -> Right node
		
		// Utilizes recursion
		// If statement which checks if the length of the morse code has a length of one.
		if(morseCode.length() == 1) {
			// If true, a nested if statement that checks if the value of the morse code contains a dot.
			if(morseCode.equals(".")) {
				
				// If true, the left node will be declared and initialized with the letter according to the morse code. 
				currentNode.setLeftNode(new TreeNode<>(letter));
				
			}
			// An else if statement which checks if the value of the morse code contains a dash.
			else if(morseCode.equals("-")){
				
				// If true, the right node will be declared and initialized with the letter according to the morse code. 
				currentNode.setRightNode(new TreeNode<>(letter));
				
			}
			
			// return;
		}
		
		// Otherwise, the following will execute if the initial if statement possesses morse code length greater than one. 
		else {
			
			// If statement which checks if the first character value in a morse code value contains a dot.
			if(morseCode.charAt(0) == '.') {
				
				// If true, a nested if statement checks if the left node is null when the left node is required to be gathered. 
				if(currentNode.getLeftNode() == null) {
					
					// If true, the currentNode is initialized as the new left child node in a tree. 
					currentNode.setLeftNode(new TreeNode<>(""));
					// addNode(currentNode.getLeftNode(), morseCode.substring(1), letter);
					
				}
				
				// addNode method executes creating a new left child node with the current morse code and its according alphabetic letter.
				addNode(currentNode.getLeftNode(), morseCode.substring(1), letter);
				
			}
			// Else if statement which checks if the first character value in a morse code value contains a dash.
			else if(morseCode.charAt(0) == '-'){
				
				// If true, a nested if statement checks if the right child node is null.
				if(currentNode.getRightNode() == null) {
					
					// If true, the currentNode is initialized as the new right child node in a tree.
					currentNode.setRightNode(new TreeNode<>(""));
					// addNode(currentNode.getRightNode(), morseCode.substring(1), letter);
					
				}
				
				// addNode method executes creating a new right child node with the current morse code and its according letter.
				addNode(currentNode.getRightNode(), morseCode.substring(1), letter);
			}
			
		}
		
	}
	
	
	// fetchNode method which gathers a specific node in its position in a tree when executed. 
	public String fetchNode(TreeNode<String> currentNode, String morseCode) {
		
		// Utilizes recursion to gather nodes according to a series of morse code.
		
		// Base case
		// If statement which checks if the current node in a tree is null to prevent a NullPointerException.
		if(currentNode == null) {
			// If true, the program returns an empty string value.
			return "";
		}
		
		// If statement which checks if the length of a morse code is zero.
		if(morseCode.length() == 0) {
			// if true, the current node is executed with the getData function to gather the current data of the node.
			return currentNode.getData();
		}
		
		// If statement which checks if the first character of the morse code contains a dot.
		if(morseCode.charAt(0) == '.') {
			// If true, the program returns an execution of the fetchNode method with the left child node in a tree.
			return fetchNode(currentNode.getLeftNode(), morseCode.substring(1));
		}
		// Otherwise if the first character of a morse code doesn't contain a dot (likely to contain a dash as its first character value)
		else {
			// The program returns an execution of the fetchNode method with the right child node in a tree.
			return fetchNode(currentNode.getRightNode(), morseCode.substring(1));
		}
		
	}
	
	
	// fetch method which executes and returns the fecthNode method, gathering the root node based on a specific morse code input that is present in a node.
	public String fetch(String morseCode) {
		// Method returns an execution of fetchNode gathering a root node and its according morse code
		return fetchNode(rootNode, morseCode);
	}
	
	// toArrayList method which creates an arraylist to contain each node and its information.
	public ArrayList<String> toArrayList() {
		
		// Arraylist object list contains strings (its generic data type) of morse code and its alphabetic letter.
		ArrayList<String> list = new ArrayList<>();
		
		// In-order traversal which traverses through each node in the tree and adds each node's information into the list arraylist.
		LNRoutputTraversal(rootNode, list);
		
		// list is then returned after all execution of the toArrayList method
		return list;
	}
	
	
	// In-order traversal through the tree starting from left node, to root node, to right node, when the method is executed.
	public void LNRoutputTraversal(TreeNode<String> currentNode, ArrayList<String> list) {
		
		// If statement which checks if the value of current node is null
		if(currentNode == null) {
			// If true, the method will conduct a void return.
			return;
		}
		
		// In-order traversal method executes operating on the left child node.
		LNRoutputTraversal(currentNode.getLeftNode(), list);
		// ArrayList then adds the current node and its data into the arraylist object "list".
		list.add(currentNode.getData());
		// In-order traversal method executes operating on the right child node.
		LNRoutputTraversal(currentNode.getRightNode(), list);
		
	}
	
	
	// Constructor method MorseCodeTree which initializes rootNode as a TreeNode object and initializes a tree.
	public MorseCodeTree() {
		
		// rootNode is initialized as a new TreeNode
		rootNode = new TreeNode<>("");
		// buildTree is executed, creating nodes for each letter and its according morse code related to the alphabetic letter
		buildTree();
	}
	
	
	// buildTree method which creates a tree by inserting each letter and its morse code. 
	public void buildTree() {
		
		// rootNode = new TreeNode<>("");
		
		// Note to self, everything has to be in hierarchy order, not by alphabetical order. 
		
		
		// . -> Left node
		// - -> Right node
		
		// Level 0 in O(h), height of the tree
		// Left node
		insert(".", "e");
		// Right node
		insert("-", "t");
		
		// Level 1 in O(h), height of the tree
		// Left, left node
		insert("..", "i");
		// Left, right node
		insert(".-", "a");
		// Right, left node
		insert("-.", "n");
		// Right, right node
		insert("--", "m");
		
		
		// Level 2 in O(h), height of the tree
		// Left, left, left node
		insert("...", "s");
		// Left, left, right node
		insert("..-", "u");
		// Left, right, left node
		insert(".-.", "r");
		// Left, right, right node
		insert(".--", "w");
		// Right, left, left node
		insert("-..", "d");
		// Right, left, right node
		insert("-.-", "k");
		// Right, right, left node
		insert("--.", "g");
		// Right, right, right node
		insert("---", "o");
		
		
		// Level 3 in O(h), height of the tree
		// Left, left, left, left node
		insert("....", "h");
		// Left, left, left, right node
		insert("...-", "v");
		// Left, left, right, left node
		insert("..-.", "f");
		// Left, right, left, left node
		insert(".-..", "l");
		// Left, right, right, left node
		insert(".--.", "p");
		// Left, right, right, right node
		insert(".---", "j");
		// Right, left, left, left node
		insert("-...", "b");
		// Right, left, left, right node
		insert("-..-", "x");
		// Right, left, right, right node
		insert("-.--", "y");
		// Right, left, right, left node
		insert("-.-.", "c");
		// Right, right, left, left node
		insert("--..", "z");
		// Right, right, left, right node
		insert("--.-", "q");
		
		
		/*
		insert(".-", "a");
		insert("-...", "b");
		insert("-.-.", "c");
		insert("-..", "d");
		insert(".", "e");
		insert("..-.", "f");
		insert("--.", "g");
		insert("....", "h");
		insert("..", "i");
		insert(".---", "j");
		insert("-.-", "k");
		insert(".-..", "l");
		insert("--", "m");
		insert("-.", "n");
		insert("---", "o");
		insert(".--.", "p");
		insert("--.-", "q");
		insert(".-.", "r");
		insert("...", "s");
		insert("-", "t");
		insert("..-", "u");
		insert("...-", "v");
		insert(".--", "w");
		insert("-..-", "x");
		insert("-.--", "y");
		insert("--..", "z");
		*/
	}
	
	
	// delete method, an abstract method from the LinkedConverterTreeInterface class which throws an UnsupportedOperationException method when executed.
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// throws an unsupported operation exception error. 
		throw new UnsupportedOperationException();
	}
	
	
	// update method, an abstract method from the LinkedConverterTreeInterface class which throws an UnsupportedOperationException method when executed.
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// throws an unsupported operation exception error. 
		throw new UnsupportedOperationException();
	}
	
	
	
	
}
