package com.matrixport.gs33;

public class NonRepeatChar {
	
	public static String getNonRepeatable(String str) {
		int[] count = new int[256];	// ascii
		int n = str.length();
		
		// loop find repeatables
		for (int i=0; i<n; i++) {
			char c = str.charAt(i);
			count[c]++;	// convert char to int index
		}

		String res = "";
		for (int i=0; i<n; i++) {
			char c = str.charAt(i);
			if (count[c] == 1)	// exist but non-repeat
				res += c;
		}
		
		return res;
	}

	public static char getFirstNonRepeatChar(String str) {
		int[] count = new int[256];	// ascii
		int n = str.length();
		
		// loop find repeatables
		for (int i=0; i<n; i++) {
			char c = str.charAt(i);
			count[c]++;	// convert char to int index
		}
		
		String res = "";
		for (int i=0; i<n; i++) {
			char c = str.charAt(i);
			if (count[c] == 1)	// exist but non-repeat
				return c;
		}
		
		return Character.MIN_VALUE;
	}
	
	public static void main(String[] arg) {
		
//		final String input = "HelloWorld"; 
//		final String input = "GeeksforGeeks"; 
		final String input = "GeeksQuiz"; 

		String res = getNonRepeatable(input);
		System.out.println(res);
		char c  = getFirstNonRepeatChar(input);
		System.out.println(c);
	}
}
