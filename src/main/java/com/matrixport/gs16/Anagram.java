package com.matrixport.gs16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

	public static String sorted(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return String.valueOf(arr);
	}
	
	public static int countOfAnagramSubstring(String str) {
		int n = str.length();
		Map<String, Integer> map = new HashMap<>();
		
		
		for (int i=0; i<n; i++) {
			String sb = "";
			
			// find all substring
			for (int j=i; j<n; j++) {
				// map to single key
				sb = sorted(sb + str.charAt(j));
				Integer v = map.getOrDefault(sb, 0);
				// increment frequencies count of each substring
				map.put(sb, ++v);
				System.out.println(sb + "," + v);
			}
		}
		
		int sum = 0;
		for (Integer v : map.values()) {
			// if a particular substring has 'o' anagrams in string, total o*(o-1)/2 anagram
			// pairs can be formed
			sum += (v * (v-1)) / 2;
			System.out.println("sum=" + sum + "," + v);
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
//		String input = "xyyx";
//		String input = "xyx";
//		String input = "xyxy";
		String input = "xyxyx";
		int output = countOfAnagramSubstring(input);
		System.out.println(output);
	}

}
