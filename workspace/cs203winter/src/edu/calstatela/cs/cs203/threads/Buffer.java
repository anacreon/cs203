package edu.calstatela.cs.cs203.threads;
public class Buffer {

    private int     value;
    private boolean ready;

    public Buffer()
    {
        value = -1;
        ready = false;
    }

    public synchronized int getValue()
    {
        // if the value is not ready, the consumer thread should wait
        // until another thread calls notify() or notifyAll().
        while( !ready )
        {
            try
            {
                wait();
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }
        	System.out.println("getValue");
        	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        // set ready to false to indicate that the value has been consumed
        ready = false;

        // activate any other threads that have been waiting
        notifyAll();

        return value;
    }

    public synchronized void setValue( int value )
    {
    	System.out.println("Test");
        // if the value is ready, the producer thread should wait
        // before setting a new value.
        while( ready )
        {
            try
            {
                wait();
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }
        	System.out.println("setValue");
        	
        	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        // set a new value
        this.value = value;

        // set ready to true to indicate that a new value is available
        ready = true;

        // activate any other threads that have been waiting
        notify();
    }

}