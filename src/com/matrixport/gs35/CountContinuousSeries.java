package com.matrixport.gs35;

public class CountContinuousSeries {
	
	public static void printDigit(int[] a) {
		int n = a.length;
		int count = 1;
		for (int i=0; i<n-1; i++) {
			if (a[i] == a[i+1])
				count++;
			else {
				System.out.println("i" +a[i]+ "," + count);
				count =1;
			}
		}
//		if (count > 1) {
			System.out.println("i" +a[n-1]+ "," + count);
//		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 1, 1, 1, 6, 6, 4, 4, 4, 9};
		printDigit(a);
		System.out.println("====================");
		int[] b = {1, 1, 1, 1, 6, 6, 4, 4, 4, 4};
		printDigit(b);
	}
	
	
}
