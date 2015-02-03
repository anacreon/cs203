package edu.calstatela.cs.cs203.cardgame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;




public class Game {
	private BufferedReader br;
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	
	private boolean gameOver = false;
	public Game()
	
	{
		try {
			br =  new BufferedReader(new FileReader("decks.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkedList<Integer> deck = new LinkedList<Integer>();
		LinkedList<Integer> pile1 = new LinkedList<Integer>();
		LinkedList<Integer> pile2 = new LinkedList<Integer>();
		LinkedList<Integer> pile3 = new LinkedList<Integer>();
		LinkedList<Integer> pile4 = new LinkedList<Integer>();
		
		read(deck);
		for(int i = 0; i < deck.size(); i++)
		{
			if((i % 4) == 0)
				pile1.add(deck.get(i));
			else if((i % 4) == 1)
				pile2.add(deck.get(i));
			else if((i % 4) == 2)
				pile3.add(deck.get(i));
			else
				pile4.add(deck.get(i));
		}
		//tell the players what cards they want 
		//and what pile they are drawing from and discarding to
		//and give a name the players
		player1 = new Player("player1", 0, 1, pile1, pile2, this);
		player2 = new Player("player2", 2, 3, pile2, pile3, this);
		player3 = new Player("player3", 4, 5, pile3, pile4, this);
		player4 = new Player("player4", 6, 7, pile4, pile1, this);
		
		//the players get their hands
		player1.draw(4);
		player2.draw(4);
		player3.draw(4);
		player4.draw(4);
		
	}
	public synchronized void play()
	{
		//get the players to start
		player1.start();
		player2.start();
		player3.start();
		player4.start();
		
		while(!gameOver)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		player1.write();
		player2.write();
		player3.write();
		player4.write();
	}
	public void read(LinkedList<Integer> deck)
	{
		String line = "";
		try {
			while((line = br.readLine()) != null)
			{
				String[] cards = line.split(" ");
				for(int i = 0; i < cards.length; i++)
				{
					deck.add(Integer.parseInt(cards[i]));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean gameEnd()
	{
		return gameOver;

	}
	public static void main(String args[])
	{
		Game game = new Game();		
		game.play();
		
	}
	public synchronized void setGame() {
		notifyAll();
		gameOver = true;
		
	}
}
