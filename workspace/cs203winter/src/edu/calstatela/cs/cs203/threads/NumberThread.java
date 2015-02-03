package edu.calstatela.cs.cs203.threads;

public class NumberThread implements Runnable {
	Collector buff; 
	
	public NumberThread(Collector buff){
		this.buff = buff;
	}
	@Override
	public void run() {
		int tmp = 0;
		boolean run = true;
		while(run){
			if(tmp < Integer.MAX_VALUE)
				run = this.buff.addNum(tmp++);
			else
				tmp = 0;
			
//			Thread.yield();
			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	
//	public static void main(String[] args){
//		Thread numThread = new Thread(new NumberThread());
//		Thread charThread = new Thread(new CharThread());
//		numThread.start();
//		charThread.start();
//	}

	
}
