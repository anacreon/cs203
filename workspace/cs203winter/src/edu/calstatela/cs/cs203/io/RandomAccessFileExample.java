package edu.calstatela.cs.cs203.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {

	public static void main(String[] args) {
		try {
			RandomAccessFile rAF = 
				new RandomAccessFile("inout.dat", "rw");
			try {			
				for(int i = 0; i < 200; ++i)
					rAF.writeInt(i);
				rAF.seek(0);
				
				rAF.seek(4 * 17);
				
				System.out.println(rAF.readInt());
				System.out.println(rAF.getFilePointer());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
