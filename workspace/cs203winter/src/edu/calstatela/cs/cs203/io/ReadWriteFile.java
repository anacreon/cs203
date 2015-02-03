package edu.calstatela.cs.cs203.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {
	private BufferedWriter bw;
	private BufferedReader br;
	
	private String readFilename;
	private String writeFilename;
	
	private static String fileSeparater = File.separator;
	
	public ReadWriteFile(String readFilename, String writeFilename){
		this.readFilename = readFilename;
		this.writeFilename = writeFilename; 
		try {
			this.br = new BufferedReader(new FileReader(readFilename));
			this.bw = new BufferedWriter(new FileWriter(writeFilename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public String getReadFilename() {
		return this.readFilename;
	}

	public String getWriteFilename() {
		return this.writeFilename;
	}

	private void writeFile(String writeThis) {
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

	private  void readFile() {
		try {			
			String line = "";
			while((line = br.readLine()) != null){
				//				     if(!line.equals("")){
				//					int tmp = Integer.parseInt(line.trim());
				//					System.out.println(tmp);
				//				}
				String[] contents = line.split(" ");
				for(String s: contents){
					System.out.println(s);
					this.bw.write(s + "\n");
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void cleanup(){
		try {
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]){
		ReadWriteFile rWF = new ReadWriteFile("test.txt", "test3.txt");
		rWF.writeFile("CS203 is GREAT!");
		rWF.readFile();
		rWF.cleanup();
	}
}