package testinventory;

import java.util.*;

public class test2 {
	public static void main(String[] args) {
		System.out.println("Enter a number: ");
		Scanner keyboard = new Scanner(System.in);
		
		if(keyboard.hasNextInt()) {
			System.out.println("1");
		}else {
			System.out.println("2");
		}
		
		int n = keyboard.nextInt();
		

		
		System.out.println("Your number: " + n);
		keyboard.close();
	}
}
