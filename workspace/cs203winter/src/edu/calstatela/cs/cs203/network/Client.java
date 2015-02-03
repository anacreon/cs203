package edu.calstatela.cs.cs203.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		try {
			Socket s = new Socket("127.0.0.1", 80);
			DataInputStream sI = new DataInputStream(s.getInputStream());
			DataOutputStream sO = new DataOutputStream(s.getOutputStream());
			while(true)
			{
				sO.writeUTF(keyboard.nextLine());
				sO.flush();
				System.out.println(sI.readUTF());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
