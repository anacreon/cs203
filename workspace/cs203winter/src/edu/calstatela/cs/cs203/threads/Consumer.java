package edu.calstatela.cs.cs203.threads;
public class Consumer extends Thread {

    private Buffer buffer;

    public Consumer( Buffer buffer )
    {
        this.buffer = buffer;
    }

    public void run()
    {
        for( int i = 0; i < 10; ++i )
        {
            int value = buffer.getValue();
            System.out.println( "\tconsumed " + value );
//            try
//            {
////                Thread.sleep( (int) (Math.random() * 100) );
//                Thread.sleep(500);
//            }
//            catch( InterruptedException e )
//            {
//                e.printStackTrace();
//            }
        }
    }

}
