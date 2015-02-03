package edu.calstatela.cs.cs203.threads;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame(String name){
		super(name);
	}
	
	public static void main(String[] args){
		MyFrame mF = new MyFrame("My Frame");
		mF.setVisible(true);
	}
}
