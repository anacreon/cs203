package edu.calstatela.cs.cs203.parse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Parse {
	String dataFilePath;
	String dataFileName;
	BufferedReader br;
	RandomAccessFile output;

	public Parse(String inputFilePath, String dataFilePath, String dataFileName)
	{
		this.dataFilePath = dataFilePath;
		this.dataFileName = dataFileName;
		try {
			this.br = new BufferedReader(inputFilePath);
			this.output = new RandomAccessFile(data)
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
