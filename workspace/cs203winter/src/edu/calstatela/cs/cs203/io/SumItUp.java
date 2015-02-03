package edu.calstatela.cs.cs203.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumItUp {

	public static void main(String[] args) {
		SumItUp.readFile("sum.txt");

	}
	
	private static  void readFile(String filename) {
		try {
			int sum = 0;
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			String line = "";
			while((line = br.readLine()) != null){
				if(line.equals(""))
					continue;
				String[] contents = line.split("\t");
				for(String s: contents){
					if(s.equals(""))
						continue;
					int tmp = Integer.parseInt(s.trim());
					sum += tmp;
				}
			}
			
			System.out.println("Sum is: " + sum);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
