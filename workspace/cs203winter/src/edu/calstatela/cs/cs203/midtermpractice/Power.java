package edu.calstatela.cs.cs203.midtermpractice;

public class Power {

	public static int power(int x, int n)
	{
		int product = 1;
		if(n == 0)
			return 1;
		else
		{
			n--;
		    product = x * power(x, n);
		    return product;
		}
	}
	public static void main(String args[])
	{
		System.out.println(power(5, 3));
		System.out.println(power(3, 3));
		System.out.println(power(2, 16));
	}
}
