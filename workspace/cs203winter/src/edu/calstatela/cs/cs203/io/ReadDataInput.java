package edu.calstatela.cs.cs203.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadDataInput {
	public static void main(String[] args) {
		WriteData wD = new WriteData("out.dat");
		wD.writeData();

		try {
			DataInputStream infile = 
				new DataInputStream(new FileInputStream("out.dat"));
			if(infile.available() != 0){
				System.out.println(infile.readDouble());
				System.out.println(infile.readDouble());
				System.out.println(infile.readDouble());
				System.out.println(infile.readInt());
				System.out.println(infile.readInt());
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
