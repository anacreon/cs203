package edu.calstatela.cs.cs203.tree;
public class BSTree {

    private BSTreeNode root;

    // variable for remove
    private Comparable removedValue;

    public BSTree()
    {
        root = null;
        removedValue = null;
    }

    public void insert( Comparable o )
    {
        insert1( o );
        // root = insert2( root, o );
    }

    public Comparable remove(Comparable o){
		// XXX: To Be Implemented
    	return null;
	}

    public Comparable removeMin()
    {
        root = removeMin( root );
        return removedValue;
    }

    private BSTreeNode removeMin( BSTreeNode node )
    {
       if( node.left == null )
       {
           removedValue = node.value;
           return node.right;
       }
       else
       {
           node.left = removeMin( node.left );
           return node;
       }
    }

    // return the object if it is found in the tree, or null
    // if it is not.
    public Comparable find( Comparable o )
    {
        // XXX: To Be Implemented
    	BSTreeNode index;
    	index = root;
    	while(index != null)
    	{
    		int cmp = 0;
    		cmp = index.value.compareTo(o);
    		if(cmp < 0)
    			index = index.left;
    		else if(cmp > 0)
    			index = index.right;
    		else
    			return index.value;
    				
    	}
        return null;
    }

    // return the smallest object in the tree
    public Comparable min()
    {
        // XXX: To Be Implemented
    	BSTreeNode index;
    	index = root;
    	while(index.left != null)
    		index = index.left;
        return index.value;
    }


    // return the largest object in the tree
    public Comparable max()
    {
        // XXX: To Be Implemented
    	BSTreeNode index;
    	index = root;
    	while(index.right != null)
    		index = index.right;
        return index.value;
    }

    public void print()
    {
        // print1( root );
        print2( root );
        // print3( root );
        System.out.println();
    }

    /* private methods */

    // non-recursive insert
    private void insert1( Comparable o )
    {
        if( root == null )
        {
            root = new BSTreeNode( o );
            return;
        }

        BSTreeNode previous, current;
        previous = current = root;

        int cmp = 0;
        while( current != null )
        {
            previous = current;
            cmp = current.value.compareTo( o );
            if( cmp < 0 )
                current = current.right;
            else if( cmp > 0 )
                current = current.left;
            else
                break;
        }

        if( cmp < 0 ) previous.right = new BSTreeNode( o );
        if( cmp > 0 ) previous.left = new BSTreeNode( o );
    }

    // recursive insert
    private BSTreeNode insert2( BSTreeNode node, Comparable o )
    {
        if( node == null ) return new BSTreeNode( o );

        int cmp = node.value.compareTo( o );
        if( cmp < 0 ) node.right = insert2( node.right, o );
        if( cmp > 0 ) node.left = insert2( node.left, o );

        return node;
    }

    // recursive print using pre-order traversal
    private void print1( BSTreeNode node )
    {
        if( node == null ) return;

        System.out.print( node.value + " " );
        print1( node.left );
        print1( node.right );
    }

    // recursive print using in-order traversal
    private void print2( BSTreeNode node )
    {
        if( node == null ) return;

        print2( node.left );
        System.out.print( node.value + " " );
        print2( node.right );
    }

    // recursive print using post-order traversal
    private void print3( BSTreeNode node )
    {
        if( node == null ) return;

        print3( node.left );
        print3( node.right );
        System.out.print( node.value + " " );
    }

    // test code
    public static void main( String args[] )
    {
        BSTree bst = new BSTree();

        bst.insert( 20 );
        bst.insert( 15 );
        bst.insert( 30 );
        bst.insert( 25 );
        bst.insert( 35 );

        // pre-order: 20, 15, 30, 25, 35
        // in-order: 15, 20, 25, 30, 35
        // post-order: 15, 25, 35, 30, 20
        bst.print();

//        System.out.println( bst.remove(20) );
        bst.print();
//        System.out.println( bst.removeMin() );
//        bst.print();
//
//        System.out.println( bst.removeMin() );
//        bst.print();
    }

}

class BSTreeNode {

    Comparable value;
    BSTreeNode left, right;

    BSTreeNode( Comparable value, BSTreeNode left, BSTreeNode right )
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    BSTreeNode( Comparable value )
    {
        this( value, null, null );
    }

}
