package edu.calstatela.cs.cs203.lists;



public abstract class AbstractList implements List {

    protected int size;

    public AbstractList()
    {
        size = 0;
    }

    public void insert( Object o )
    {
        insert( o, size );
    }

    public Object remove( Object o )
    {
        return remove( indexOf( o ) );
    }

    public boolean contains( Object o )
    {
        return indexOf( o ) != -1;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void clear()
    {
        size = 0;
    }

}
