package edu.calstatela.cs.cs203.lists;


import java.util.Scanner;

public class ListTest {

    public void test( List list )
    {
        // insert
        list.insert( new Integer( 20 ) );
        list.insert( new Integer( 30 ) );
        list.insert( new Integer( 40 ) );
        list.print();
        list.insert( new Integer( 10 ), 0 );
        list.insert( new Integer( 15 ), 1 );
        list.insert( new Integer( 50 ), 20 );
        list.print();

        // indexOf() and contains()
        System.out.println( list.indexOf( new Integer( 50 ) ) );
        System.out.println( list.contains( new Integer( 20 ) ) );
        System.out.println( list.contains( new Integer( 35 ) ) );

        // remove(), size(), and isEmpty()
        list.remove( new Integer( 20 ) );
        list.remove( new Integer( 35 ) );
        list.print();
        list.remove( 0 );
        list.print();
        list.remove( list.size() - 1 );
        list.remove( list.size() - 1 );
        list.print();
        System.out.println( list.isEmpty() );

        // get()
        for( int i = 0; i < list.size(); ++i )
            System.out.print( list.get( i ) + " " );
        System.out.println();

        // iterator
        ListIterator iterator = list.iterator();
        while( iterator.hasNext() )
            System.out.print( iterator.next() + " " );
        System.out.println();

        iterator = list.iterator();
        list.insert( iterator.next() );
        list.insert( iterator.next() );
        list.insert( iterator.previous() );
        list.insert( iterator.previous() );
        list.insert( iterator.next() );
        list.insert( iterator.previous() );
        list.print();
    }

    public static void main( String[] args )
    {
        System.out.println( "Please choose which List implementation to test:" );
        System.out.println( "  1. ArrayList" );
        System.out.println( "  2. LinkedList" );
        System.out.println( "  3. DoubleLinkedList" );
        System.out.print( "Your choice: " );

        Scanner scanner = new Scanner( System.in );
        int choice = scanner.nextInt();
        scanner.close();

        List list = null;
        switch( choice )
        {
            case 1:
                list = new ArrayList();
                break;
            case 2:
                list = new LinkedList();
                break;
            case 3:
                list = new DoubleLinkedList();
                break;
            default:
                System.err.println( "Wrong input: " + choice );
                return;
        }

        (new ListTest()).test( list );
    }

}
