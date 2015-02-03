package edu.calstatela.cs.cs203.threads;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class NetThread implements Runnable {

    String url;

    public NetThread( String url )
    {
        this.url = url;
    }

    public void run()
    {
        try
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(
                    (new URL( url )).openStream() ) );
            while( br.readLine() != null );
            br.close();

            System.out.println( "page download completed" );
        }
        catch( Exception e )
        {
            System.out.println( e.getMessage() );
        }
    }

}

