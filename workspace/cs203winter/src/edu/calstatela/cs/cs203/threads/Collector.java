package edu.calstatela.cs.cs203.threads;

import java.util.ArrayList;

public class Collector {
	ArrayList aL = new ArrayList();
	boolean reset = true;

	public boolean addChar(char c){
//		synchronized(aL){
			if(aL.size() > 2000)
				return false;
			aL.add(c);
			return true;
//		}

	}

	public boolean addNum(int num){
//		synchronized(aL){
			if(aL.size() > 2000)
				return false;
			aL.add(num);
			return true;
//		}
	}

	public static void main(String[] args){
		Collector c = new Collector();

		Thread t1 = new Thread(new NumberThread(c));
		Thread t2 = new Thread(new CharThread(c));

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Object a:c.aL)
			System.out.println(a);
	}
}
