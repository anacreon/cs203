package edu.calstatela.cs.cs203.cardgame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Player extends Thread{

	ArrayList<Integer> junk = new ArrayList<Integer>();
	ArrayList<Integer> kept = new ArrayList<Integer>(); 
	private Integer card1;
	private Integer card2;
	private LinkedList<Integer> draw;
	private LinkedList<Integer> discard;
	String name;
	private boolean hasWon = false;
	private BufferedWriter bw;
	Game game;
	
	public Player(String name, int cardWanted1, int cardWanted2, LinkedList<Integer> draw, LinkedList<Integer> discard, Game game)
	{
		this.card1 = cardWanted1;
		this.card2 = cardWanted2;
		this.draw = draw;
		this.discard = discard;
		this.name = name;
		this.game = game;
		try {
			this.bw = new BufferedWriter(new FileWriter(name + ".txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw(int number)
	{
		int card;
		for(int i = 0; i < number; i++)
		{
			synchronized(draw)
			{
				card = draw.remove();
				System.out.println(name + " drew " + card);
				if((card == card1) || (card == card2))
					kept.add(card);
				else
					junk.add(card);
			}
		}
	}

	public void draw()
	{
		int card;
		synchronized(draw)
		{
			while(draw.isEmpty())
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			card = draw.remove();
			System.out.println(name + " drew " + card);
			if((card == card1) || (card == card2))
				kept.add(card);
			else
				junk.add(card);
		}
	}
	public void discard()
	{
		int card;
		synchronized(discard)
		{
			if(junk.isEmpty())
			{
				int count1 = 0; 
				int count2 = 0;
				for(int i = 0; i < kept.size(); i++)
				{
					if(kept.get(i) == card1)
						count1++;
					else
						count2++;
				}
				if(count1 == count2)
				{
					int remove = (int)(Math.random()* kept.size());
					card = kept.remove(remove);
				}
				else if(count1 > count2)
				{
					
					card = card2;
					kept.remove(card2);
				}
				else
				{
					card = card1;
					kept.remove(card1);
				}				
			}
			else
			{
				int remove = (int)(Math.random()* junk.size());
				card = junk.remove(remove);

			}
			discard.add(card);
		}
		System.out.println(name + " discarded " + card);
	}
	public void run()
	{
		while(!game.gameEnd())
		{
			draw();
			
			try {
				sleep(1);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			discard();
			System.out.println(name + " Hand: " + junk.toString() +", " + kept.toString());
			hasWon();
		}
		System.out.println(name + " has left the game");
	}

	private void cleanUp() {
		// TODO Auto-generated method stub
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write() {
		// TODO Auto-generated method stub
		try {
			bw.write("Won: " + hasWon + "\n" + 
					 "Hand: " + junk.toString() +", " + kept.toString() + "\n" +
					 "Draw Pile: " + draw.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		System.out.println(name + " Won: " + hasWon + "\n" + 
				 "Hand: " + junk.toString() +", " + kept.toString() + "\n" +
				 "Draw Pile: " + draw.toString());
		cleanUp();
	}

	private synchronized void hasWon() {
		if(kept.isEmpty() == false)
		{
			int number = kept.get(0);
			int count = 0;
			for(int i = 0; i < kept.size(); i++)
			{
				if(kept.get(i) == number)
					count++;
			}
				if(count == 4)
				{
					game.setGame();
					hasWon = true;
				}
				else
					hasWon = false;
		}
		else
			hasWon = false;
	}
}