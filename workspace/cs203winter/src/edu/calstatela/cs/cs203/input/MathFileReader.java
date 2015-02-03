package edu.calstatela.cs.cs203.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import edu.calstatela.cs.cs203.ouput.MathFileWriter;

public class MathFileReader {
	private BufferedReader br;
	private String readFileName;
	
	MathFileReader(String readFileName)
	{
		this.readFileName = readFileName;
		try {
			this.br = new BufferedReader(new FileReader(readFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String readFile()
	{
		String line = "";
		double firstNumber, secondNumber, result;
		String operator ="";
		String output ="";
		try {			
			while((line = br.readLine()) != null){
				String[] contents = line.split(" ");
				if(((!contents[0].contains("#")) || (!contents[0].equals(""))) && (contents.length == 3))
				{
					operator = contents[0].trim();
					firstNumber = Double.valueOf(contents[1].trim());
					secondNumber = Double.valueOf(contents[2].trim());
					if(operator.equals("+"))
						result = firstNumber + secondNumber;
					else if(operator.equals("-"))
						result = firstNumber - secondNumber;
					else if(operator.equals("/"))
						result = firstNumber / secondNumber;
					else
						result = firstNumber * secondNumber;
					output += firstNumber + " " + operator + " " + secondNumber + " = " + result +" \n";
				}
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output; 
	}
	

	public String getOutPut()
	{
		
		String outPutPath ="";
		String line;
		try {
			if(((line = br.readLine())) != null)
				outPutPath = line;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outPutPath;
		
	}
	public void close() {
		// TODO Auto-generated method stub
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		MathFileReader mFR = new MathFileReader("input.txt");
		MathFileWriter mFW = new MathFileWriter(mFR.getOutPut());
		mFW.write(mFR.readFile());
		mFR.close();
		mFW.close();

	}
}