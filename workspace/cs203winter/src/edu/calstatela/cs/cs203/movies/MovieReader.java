package edu.calstatela.cs.cs203.movies;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.calstatela.cs.cs203.listsQueues.MyLinkedList;

public class MovieReader {
	private BufferedReader br;
	private String filename;
	MovieReader(String filename)
	{
		this.filename = filename;

			try {
				this.br = new BufferedReader(new FileReader(filename));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public MyLinkedList<String> readFile()
	{
		MyLinkedList<String> movies = new MyLinkedList<String>();
		String line = "";
		try {
			while((line = br.readLine()) != null)
			{
				if(line.contains("$"))
				{
					movies.addLast(line);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}

	
	static void main(String[] args)
	{
		MovieReader mr = new MovieReader("highestGrossingMovies.txt");
		MyLinkedList<String> movies = mr.readFile();
		movies.bubbleSort();
		

	}
}
