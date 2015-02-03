package edu.calstatela.cs.cs203.threads;


public class ThreadTest2 {

    public ThreadTest2() {}

    public void performTasks() throws Exception
    {
        Thread t1 = new FiboThread(41);
        Thread t2 = new Thread( new NetThread("http://www.cnn.com") );
//        Thread t3 = new Thread(new NetThread("http://ww.cnn.com"));
        t1.start();
//        t1.run();
        t2.start();
        t1.join();
        t2.join();
    }

    public static void main( String[] args ) throws Exception
    {
        ThreadTest2 tt2 = new ThreadTest2();

        long startTime = System.currentTimeMillis();
        tt2.performTasks();
        long endTime = System.currentTimeMillis();

        System.out.println( "Time elapsed: " + (endTime - startTime)/1000
                + " seconds." );
    }

}
