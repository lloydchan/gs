package com.matrixport.gs35;

public class ReverseArray {
	static void rvereseArray(int arr[]/* , int start, int end */) {
		int start = 0;
		int end = arr.length-1;
		int temp;

		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	/*
	 * Utility that prints out an array on a line
	 */
	static void printArray(int arr[]) {
		int size = arr.length;
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

// Driver code 
	public static void main(String args[]) {

//		int arr[] = { 1, 2, 3, 4, 5, 6 };
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		printArray(arr);
		rvereseArray(arr);
		System.out.print("Reversed array is \n");
		
		printArray(arr);

	}
}
