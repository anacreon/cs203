package edu.calstatela.cs.cs203.lists;


public interface List {

    // insert an element at the end of the list
    public void insert( Object o );

    // insert an element at the ith position
    public void insert( Object o, int i );

    // remove the first occurrence of the object
    public Object remove( Object o );

    // remove the ith element
    public Object remove( int i );

    // find the index of the first occurrence of the object
    public int indexOf( Object o );

    // find whether the object is in the list or not
    public boolean contains( Object o );

    // return the ith element
    public Object get( int i );

    // return the size of the list
    public int size();

    // return whether the list is empty of not
    public boolean isEmpty();

    // remove all objects from the list
    public void clear();

    // print all elements in the list
    public void print();

    // return an iterator for the list
    public ListIterator iterator();

}
