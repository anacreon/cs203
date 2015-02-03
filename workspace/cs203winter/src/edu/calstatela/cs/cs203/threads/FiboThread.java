package edu.calstatela.cs.cs203.threads;
public class FiboThread extends Thread {

    int n;

    public FiboThread( int n )
    {
        super();
        this.n = n;
    }

    public long fibonacci( int k )
    {
        if( k == 0 )
            return 0;
        else if( k == 1 )
            return 1;
        else
            return fibonacci( k - 1 ) + fibonacci( k - 2 );
    }

    public void run()
    {
        System.out.println( fibonacci( n ) );
    }

}
