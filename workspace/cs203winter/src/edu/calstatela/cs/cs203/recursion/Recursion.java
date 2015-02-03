package edu.calstatela.cs.cs203.recursion;

public class Recursion {
	public static void main(String args[]){
		System.out.println(Recursion.factorial(5));
	}
	
	public static int factorial(int n){
		if(n <= 0)
			return 1;
		return factorial(n-1) * n;
	}
	
	public static int factorialShort(int n){
		return (n==0) ? 1 : (n * factorialShort(n-1));
	}
	
//	public static int factorialLoop(int n){
//		

//	}
}
