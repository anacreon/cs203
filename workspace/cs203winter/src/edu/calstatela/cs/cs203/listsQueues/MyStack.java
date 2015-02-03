package edu.calstatela.cs.cs203.listsQueues;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyStack<E> {

	private ArrayList<E> list = new ArrayList<E>();

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int getSize() {
		return list.size();
	}

	public E peek() {
		return list.get(getSize() - 1);
	}

	public E pop() throws NoSuchElementException {
		if(getSize() - 1 == -1)
			throw new NoSuchElementException("Stack empty!");
		E o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}

	public E push(E o) {
		list.add(o);
		return o;
	}

	public int search(E o) {
		return list.lastIndexOf(o);
	}

	/** Override the toString in the Object class */
	public String toString() {
		return "stack: " + list.toString();
	}
	
	public static void main(String args[]){
		MyStack<String> mS = new MyStack<String>();
		mS.push("A");
		mS.push("B");
		mS.push("C");
		mS.push("D");
		mS.push("E");
		
		System.out.println(mS);
		
		System.out.println(mS.pop());
		System.out.println(mS);
		System.out.println(mS.pop());
		System.out.println(mS.pop());
		System.out.println(mS);
		System.out.println(mS.pop());
		System.out.println(mS);
		System.out.println(mS.pop());
		System.out.println(mS.pop());
		
	}
}

