package edu.calstatela.cs.cs203.lists;


public class ArrayList extends AbstractList {

    Object elements[];

    public ArrayList()
    {
        elements = new Object[20];
        size = 0;
    }

    private void resize()
    {
        Object newElements[] = new Object[size * 2];
        for( int i = 0; i < elements.length; ++i )
            newElements[i] = elements[i];
        elements = newElements;
    }

    public void insert( Object o, int i )
    {
        if( i < 0 ) i = 0;
        if( i > size ) i = size;
        if( size >= elements.length ) resize();

        int index = size;
        while( index > i )
        {
            elements[index] = elements[index - 1];
            --index;
        }
        elements[i] = o;
        ++size;
    }

    public Object remove( int i )
    {
        if( i < 0 || i >= size ) return null;

        Object p = elements[i];
        while( i < size - 1 )
        {
            elements[i] = elements[i + 1];
            ++i;
        }
        --size;
        return p;
    }

    public int indexOf( Object o )
    {
        for( int i = 0; i < size; ++i )
            if( elements[i].equals( o ) ) return i;
        return -1;
    }

    public Object get( int i )
    {
        return i < 0 || i >= size ? null : elements[i];
    }

    public void print()
    {
        for( int i = 0; i < size; ++i )
            System.out.print( elements[i] + " " );
        System.out.println();
    }

    public ListIterator iterator()
    {
        return new ArrayListIterator( this );
    }

}

class ArrayListIterator implements ListIterator {

    ArrayList list;
    int       current;

    ArrayListIterator( ArrayList list )
    {
        this.list = list;
        current = 0;
    }

    public boolean hasPrevious()
    {
        return !list.isEmpty() && current != 0;
    }

    public Object previous()
    {
        return hasPrevious() ? list.elements[--current] : null;
    }

    public boolean hasNext()
    {
        return !list.isEmpty() && current < list.size();
    }

    public Object next()
    {
        return hasNext() ? list.elements[current++] : null;
    }

}
