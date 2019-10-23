package com.matrixport.gs35;

public class ContainsDigit123 {

	private static final int[] digits = {1, 2 ,3};
	
	public static void printContainsDigit(String[] strings) {
		int size = digits.length;
		
		for (String str : strings) {
			int count = 0;
			for (int i=0; i<size; i++) {
				if (str.indexOf(Integer.toString(digits[i])) >= 0) {
					count++;	
				}
			}
			if (count >= size)
				System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		String[] input = {"1395", "1721298", "102030", "3215", "123"};
		printContainsDigit(input);
	}

}
