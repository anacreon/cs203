
package edu.calstatela.cs.cs203.tree;

import java.util.Scanner;

public class AnimalTree {

	private TreeNode root;
	public AnimalTree()
	{
		TreeNode previous, current;
		root = new TreeNode("is it big?");
		current = previous = root;
		insert("does it have a cage?", "does it eat grass?", current);
		
		//left side of tree
		current = current.left;
		insert("does it meow", "does it chirp?", current);
		previous = current;
		current = current.left;
		insert("its a dog", "its a cat", current);
		current = previous.right;
		insert("its a hamster", "its a bird", current);
		
		current = previous = root;
		
		//right side of tree
		current = current.right;
		previous = current;
		insert("does it have a long neck?", "does it moo?", current);
		current = current.left;
		insert("its a bear", "its a giraffe", current);
		current = previous.right;
		insert("its a horse", "its a cow", current);

		
		
		
		
	}
	public void insert(Comparable left , Comparable right, TreeNode current)
	{
		current.left = new TreeNode(left);
		current.right = new TreeNode(right);
			
	}
	public void ask()
	{
		TreeNode index = root;
		Scanner input = new Scanner(System.in);
		String answer;
		while(index != null)
		{
			System.out.println(index.value.toString());
			if(index.left == null || index.right == null)
				break;
			else
					answer = input.nextLine();
			
			
			if(answer.contains("Y") || answer.contains("y"))
				index = index.right;
			else
				index= index.left;
				
		}
	}
	public static void main(String[] args) {
		AnimalTree at = new AnimalTree();
		at.ask();

	}

}
class TreeNode {

    Comparable value;
    TreeNode left, right;

    TreeNode( Comparable value, TreeNode left, TreeNode right )
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    TreeNode( Comparable value )
    {
        this( value, null, null );
    }

}