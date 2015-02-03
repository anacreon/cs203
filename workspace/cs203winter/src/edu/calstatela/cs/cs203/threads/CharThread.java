package edu.calstatela.cs.cs203.threads;

public class CharThread implements Runnable{
	Collector buff; 
	
	public CharThread(Collector buff){
		this.buff = buff;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		char tmp = 0;
		boolean run = true;
		while(run){
			for(tmp = 'a'; tmp < 'a' + 26; ++tmp){
				run = this.buff.addChar(tmp);
//				Thread.yield();
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
	}

}