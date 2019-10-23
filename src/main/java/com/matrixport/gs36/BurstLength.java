package com.matrixport.gs36;

public class BurstLength {

//	private static final String input1 = "abbcaaccd";
	
	public static String getBurstLength(String str, Integer burst) {
		
		System.out.println(str);
		
		int n = str.length();
		
		int count = 0;
		int j;
		for (int i=0; i<n; i++) {
			count = 1;
			j = i;
			// check subsequent string are the same
			while (j < n-1 && str.charAt(j) == str.charAt(j+1)) {
				j++;
				count++;
			}
			
			System.out.println(i + "," + j + "," + count);
			
			if (count >= burst) {
				String subStr = str.substring(0,  i) + str.substring(j+1); 
				return getBurstLength(subStr, burst);
			} else {
				count = 1;
			}
		}
		return str;
	}
	
	public static void main(String[] args) {
//		String input1 = "abbcaaaccd";
//		Integer input2 = 2;
//		String output = getBurstLength(input1, input2);
//		System.out.println(output);

		String input1 = "abbcaaaccd";
		Integer input2 = 3;
		String output = getBurstLength(input1, input2);
		System.out.println(output);	// abbd
	}

}
