package edu.calstatela.cs.cs203.lists;



public class LinkedList extends AbstractList {

    ListNode head, tail;

    public LinkedList()
    {
        head = null;
        size = 0;
    }

    public void insert( Object o )
    {
        ListNode node = new ListNode( o );

        if( size == 0 )
        {
            head = tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }

        ++size;
    }

    public void insert( Object o, int i )
    {
        if( i < 0 ) i = 0;
        if( i > size ) i = size;
        if( size == 0 || i == size ) { insert( o ); return; }

        ListNode node = new ListNode( o );
        if( i == 0 )
        {
            node.next = head;
            head = node;
        }
        else
        {
            int index = 0;
            ListNode current = head;
            while( index < i - 1 )
            {
                current = current.next;
                ++index;
            }
            node.next = current.next;
            current.next = node;
        }

        ++size;
    }

    public void print()
    {
        ListNode current = head;
        while( current != null )
        {
            System.out.print( current.data + " " );
            current = current.next;
        }
        System.out.println();
    }

    public ListIterator iterator()
    {
        return new LinkedListIterator( this );
    }

	public Object remove(int i) {
		ListNode index, temp;
		index = head;
		temp = head;
		
		
		if( size == 0 )
        {
			System.out.print("The List is empty");
			return null;
        }
		else if(i == 0)
		{
			
			head = head.next;
			index.next = null;
			return index.data;
		}
		else if(i == (size - 1))
		{
			for(int j = 0; j < i; j++)
        	{
        		index = index.next;
        	}
			tail = index;
			index.next = null;
			return index.data;
		}
		else if(i < 0)
			return null;
        else
        {
        	for(int j = 0; j < i; j++)
        	{
        		index = index.next;
        	}
        	for(int j = 0; j < i-1; j++)
        	{
        		temp = temp.next;
        	}
        	temp.next = index.next;
        	index.next = null;
        	size--;
        }
		return index.data;
	}

	public int indexOf(Object o) {
		ListNode index = head;
		if(size == 0)
		{
			System.out.println("The list is empty");
			return -1;
		}
		else
		{
			for(int i = 0; i < size; i++)
			{
				if(index == null)
					return -1;
				if(index.data.equals(o))
					return(size - 1);
				index = index.next;
				
			}
			return -1;
		}
	}

	public Object get(int i) {
		ListNode index;
		index = tail;
		
		
		if( size == 0 )
        {
			System.out.print("The List is empty");
			return null;
        }
        else
        {
        	for(int j = 0; j < (size - i); j++)
        	{
        		index = index.next;
        	}
        }
		return index.data;
	}

	public void bubblesort() {
		
		
	}

}

class ListNode {

    Object   data;
    ListNode next;

    ListNode()
    {
        this( null, null );
    }

    ListNode( Object data )
    {
        this( data, null );
    }

    ListNode( Object data, ListNode next )
    {
        this.data = data;
        this.next = next;
    }

}

class LinkedListIterator implements ListIterator {

    private LinkedList list;
    private ListNode   current;

    public LinkedListIterator( LinkedList list )
    {
        this.list = list;
        current = list.head;
    }

    public boolean hasPrevious()
    {
        return list.size > 0 && current != list.head;
    }

    public Object previous()
    {
        Object o = null;

        if( hasPrevious() )
        {
            ListNode previous = list.head;
            while( previous.next != current )
                previous = previous.next;
            current = previous;
            o = current.data;
        }

        return o;
    }

    public boolean hasNext()
    {
        return list.size > 0 && current != null;
    }

    public Object next()
    {
        Object o = null;

        if( hasNext() )
        {
            o = current.data;
            current = current.next;
        }

        return o;
    }

}

