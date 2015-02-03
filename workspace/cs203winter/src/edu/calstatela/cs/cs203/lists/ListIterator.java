package edu.calstatela.cs.cs203.lists;


public interface ListIterator extends Iterator {

    public boolean hasPrevious();

    public Object previous();

}
