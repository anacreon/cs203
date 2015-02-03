package edu.calstatela.cs.cs203.io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class WriteData implements Serializable{
	private DataOutputStream outfile;
	
	public WriteData(String filename){
		try {
			outfile =
				  new DataOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void writeData(){
		try {
			outfile.writeDouble(2.5);
			outfile.writeDouble(3.5);
			outfile.writeDouble(4.5);
			outfile.writeInt(4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
