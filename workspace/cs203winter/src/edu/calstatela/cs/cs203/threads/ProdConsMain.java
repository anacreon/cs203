package edu.calstatela.cs.cs203.threads;

public class ProdConsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Buffer b = new Buffer();
		
		Thread prod = new Producer(b);
		Thread consu = new Consumer(b);
		
		consu.start();
		prod.start();
		
		
		
	}

}
