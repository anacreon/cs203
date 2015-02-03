package edu.calstatela.cs.cs203.ouput;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MathFileWriter {
	private BufferedWriter bw;
	private String writeFilename;
	public MathFileWriter(String outPut) {
		// TODO Auto-generated constructor stub
		this.writeFilename = outPut;
		try {
			this.bw = new BufferedWriter(new FileWriter(writeFilename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void write(String writeThis) {
		// TODO Auto-generated method stub
		try {
			bw.write(writeThis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() {
		// TODO Auto-generated method stub
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
