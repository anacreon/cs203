package edu.calstatela.cs.cs203.lists;


public interface Queue {

    // returns the object at the front of the queue, or null
    // if the queue is empty
    public Object front();

    // insert the object at the end of the queue
    public void enqueue( Object o );

    // removes and returns the object at the front of the queue.
    // throws a NoSuchElementException if the queue is empty
    public Object dequeue();

    // returns whether the queue is empty
    public boolean isEmpty();

    // removes all objects from the queue
    public void clear();

}
