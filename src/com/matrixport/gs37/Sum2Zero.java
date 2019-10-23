package com.matrixport.gs37;

public class Sum2Zero {

	public static boolean isSum2Zero(int[] a) {
		int n = a.length;
		
		for (int i=0; i<n; i++) {
			int sum = a[i];
			for (int j=i+1; j<n; j++) {
				if (sum == 0) {
					System.out.println(i + "," + (j-1));
					return true;
				}
				sum += a[j];
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
//		int[] a = {15, 2, 4, 8, 9, 5, 10, 23};
//		int[] a = {4, 2, -3, 1, 6};
		int[] a = {4, 2, 0, 1, 6};
//		int[] a = {-3, 2, 3, 1, 6};
		isSum2Zero(a);
	}

}
