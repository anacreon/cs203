package edu.calstatela.cs.cs203.threads;

public class Producer extends Thread {

    private Buffer buffer;

    public Producer( Buffer buffer )
    {
        this.buffer = buffer;
    }

    public void run()
    {
        for( int i = 0; i < 10; ++i )
        {
            buffer.setValue( i );
            System.out.println( "produced " + i );
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