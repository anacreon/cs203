package edu.calstatela.cs.cs203.threads;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ThreadTest1 {

    public ThreadTest1()
    {
    }

    public long fibonacci( int n )
    {
        if( n == 0 )
            return 0;
        else if( n == 1 )
            return 1;
        else
            return fibonacci( n - 1 ) + fibonacci( n - 2 );
    }

    public void netAccess( String url ) throws Exception
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(
                (new URL( url )).openStream() ) );
        while( br.readLine() != null );
        br.close();

        System.out.println( "page download completed." );
    }

    public static void main( String args[] ) throws Exception
    {
        ThreadTest1 tt = new ThreadTest1();

        long startTime = System.currentTimeMillis();
        System.out.println( tt.fibonacci( 41 ) );
        tt.netAccess( "http://www.cnn.com" );
        long endTime = System.currentTimeMillis();
        System.out.println( "Time elapsed: " + (endTime - startTime) / 1000
                + " seconds." );
    }

}
