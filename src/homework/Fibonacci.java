package homework;

import java.util.Scanner;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter repeat time: ");
		Scanner sc = new Scanner(System.in);
		int repeats = sc.nextInt();
		System.out.println("Result = " + fibonacci(repeats));
	}
	
	public static int fibonacci(int i){
		if (i < 2) 
			return i;         
        else 
        	return fibonacci(i-1) + fibonacci(i-2);         
	}

}
