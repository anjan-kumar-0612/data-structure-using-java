import java.util.Scanner;
import java.io.*; 
import java.lang.*;
class Node 
{ 
    int key; 
    Node left, right; 
	//calling constructor
    public Node(int item)
	{ 
        key = item; 
        left = right = null; 
    } 
}
public class bst
{
	Node root; 
	bst()//clling constructor 
	{  
        root = null;  
    }
	//Definig insert method
	void insert(int key) 
	{ 
       root = insertNode(root, key); 
    } 
	Node insertNode(Node root, int key) { 
  
        if (root == null) 
		{ 
            root = new Node(key); 
            return root; 
        } 
  
        if (key < root.key) 
            root.left = insertNode(root.left, key); 
        else if (key > root.key) 
            root.right = insertNode(root.right, key); 
  
        return root; 
    }
	//definig delete method
	void delete(int key) 
    { 
        root = deleteNode(root, key); 
    } 
	//finding minimum element of tree
	Node minimum(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	//finding maximum element of tree
	Node maximum(Node root) {
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}
	
	Node deleteNode(Node root, int key) 
    { 
        if (root == null)  return root; 
  
        if (key < root.key) 
            root.left = deleteNode(root.left, key); 
        else if (key > root.key) 
            root.right = deleteNode(root.right, key); 

        else
        { 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
 
            root= minimum(root.right); 
  
            root.right = deleteNode(root.right, root.key); 
        } 
  
        return root; 
    } 
	Node searchNode(Node node, int key) {
		if (node == null || key == node.key) {
			return node;
		}

		if (key < node.key) {
			return searchNode(node.left, key);
		} 
		return searchNode(node.right, key);
	}
	
	//Defining print method
	void print(Node Ptr, String indent, boolean last) {
		// print the tree structure on the screen
	   	if (Ptr != null) {
		   System.out.print(indent);
		   if (last) {
		      System.out.print("R----");
		      indent += "     ";
		   } else {
		      System.out.print("L----");
		      indent += "|    ";
		   }

		   System.out.println(Ptr.key);

		   print(Ptr.left, indent, false);
		   print(Ptr.right, indent, true);
		}
	}
	// main function
	public static void main(String[] args)
    {                 
        Scanner scan = new Scanner(System.in);
        bst tree= new bst(); 
        System.out.println("Binary Search Tree\n");          
        char ch;
		String flag="Not found";
        do    
        {
            System.out.println("\nBinary Search Tree Operations");
			System.out.println("______________________________\n");
            System.out.println("1. INSERT");
            System.out.println("2. DELETE");
            System.out.println("3. DISPLAY");
			System.out.println("4. SEARCH");
			System.out.println("5. FIND MINIMUM");
			System.out.println("6. FIND MAXIMUM ");
			System.out.println("______________________________\n");
 
            int choice = scan.nextInt();
			Scanner reader = new Scanner(System.in);            
            switch (choice)
            {
            case 1 : 
				System.out.println("Enter the no of elements:");
				int range = reader.nextInt();
                System.out.println("Enter integer element to insert");
				for(int i=1;i<=range;i++){
				int value = reader.nextInt();
				Node a=new Node(value);
				tree.insert(value);
				}
                break;                          
            case 2 : 
                System.out.println("Enter integer element to delete");
                tree.delete( scan.nextInt() );
				System.out.println("Tree after deleting entered element \n");
				tree.print(tree.root, "", true);				
                break;                         
            case 3 : 
				System.out.println("Display of tree");
				tree.print(tree.root, "", true);
				break;  
			case 4 :
				System.out.println("Enter the value to be searched");
				if(tree.searchNode(tree.root,scan.nextInt())==null)
					System.out.println("element not found");
				else
					System.out.println("element found");
				break;
			case 5 :
				System.out.println("The minimum element is :");
				System.out.println(tree.minimum(tree.root).key);
				break;
			case 6 :
				System.out.println("The maximum element is :");
				System.out.println(tree.maximum(tree.root).key);
				break;
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
} 
