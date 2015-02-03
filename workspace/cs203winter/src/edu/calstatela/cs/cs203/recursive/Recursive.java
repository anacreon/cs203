package edu.calstatela.cs.cs203.recursive;

import java.util.Scanner;

public class Recursive {

	int n;
	int size;
	int min = Integer.MAX_VALUE;
	String s;
	String r ="";
	int i[];
	Scanner input;
	String integer;
	char digits[];
	int sum = 0;
	int number;
	Recursive()
	{
		this.input = new Scanner(System.in);
		System.out.println("Enter a String");
		this.s = this.input.nextLine();
		System.out.println("Enter an integer");
		this.n = this.input.nextInt();
		this.n = Math.abs(this.n);
		System.out.println("Enter an array size");
		this.size = this.input.nextInt();
		this.i= new int[this.size];
		System.out.println("fill the array");
		for(int k = 0; k < this.i.length; k++)
			this.i[k] = this.input.nextInt();
		System.out.println("Enter an integer where the digits will be added up");
		this.number = this.input.nextInt();
		this.number = Math.abs(this.number);
		this.integer= Integer.toString(number);
		this.digits = this.integer.toCharArray();
	}
	public static void count(int n, int i)
	{
		System.out.print(i + " ");
		if(i < n)
		{
			i++;
			count(n, i);
		}
	}
	public static void pattern1(int n)
	{

		for(int i = 1; i <= n; i++)
		{
			System.out.print("*");
		}
		System.out.println();
		if(n > 1)
		{
			n--;
			pattern1(n);
		}
	}
	public static void pattern2(int n, int a)
	{
		for(int i = 1; i <= a; i++)
		{
			System.out.print("*");
		}
		System.out.println();
		if(a < n)
		{
			a++;
			pattern2(n, a);
		}
	}
	public static void pattern3(int n, int a)
	{
		pattern1(n);
		a++;
		pattern2(n, a);
	}
	public static void pattern4(int n, int a)
	{
		pattern2(n, a);
		n--;
		pattern1(n);
	}
	public static String reverseString(String s, String r, int l)
	{
		r+= s.charAt(l - 1);
		if((l - 1) > 0)
		{
			l--;
			r = reverseString(s, r, l);
		}
		return r;
	}
	public static int min(int i[], int min, int l)
	{
		if(i[l-1] < min)
			min = i[l-1];
		if(l - 1 > 0)
		{
			l--;
			min = min(i, min, l);
		}
		return min;
	}
	public static int digitSum(char[] digits, int sum, int length) {
		sum += (digits[length - 1] - 48);
		if((length - 1) > 0)
		{
			length--;
			sum = digitSum(digits, sum, length);
		}
		return sum;
	}
	public static void main(String args[])
	{
		Recursive rec = new Recursive();
		count(rec.n, 1);
		System.out.println();
		pattern1(rec.n);
		System.out.println();
		pattern2(rec.n, 1);
		System.out.println();
		pattern3(rec.n, 1);
		System.out.println();
		pattern4(rec.n, 1);
		System.out.println();
		rec.r = reverseString(rec.s, rec.r, rec.s.length());
		System.out.println(rec.r);
		rec.min = min(rec.i, rec.min, rec.i.length);
		System.out.println(rec.min);
		rec.sum = digitSum(rec.digits, rec.sum, rec.integer.length());
		System.out.print("The sum of the digits ");
		for(int k = 0; k < rec.digits.length; k++)
		{
			System.out.print(rec.digits[k] + " ");
		}
		System.out.print("is " + rec.sum);
		
	}

}
