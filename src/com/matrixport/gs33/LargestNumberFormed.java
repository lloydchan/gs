package com.matrixport.gs33;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFormed {
	private static final Integer[] input = {54, 546, 548, 60};
//	private static final String output = "6054854654";
//	private static final Integer[] input = {1, 34, 3, 98, 9, 76, 45, 4};
//	private static final String output = "998764543431";
	
	static Comparator<Integer> comparator = new Comparator<Integer>() {
	    public int compare(Integer o1, Integer o2) {
	    	String comb1 = o1.toString() + o2.toString();
	    	String comb2 = o2.toString() + o1.toString();
	        return Integer.valueOf(comb2).compareTo(Integer.valueOf(comb1));
	    }
	};
	
	public static String getLargestNumberFormed(Integer[] input) {
		
		Arrays.sort(input, comparator);
		String res = "";
		for (Integer i : input) {
			System.out.println(i);
			res += i;
		}
		return res;
	}
	
	public static void main(String[] arg) {
		String expected = getLargestNumberFormed(input);
//		assert output != expected : "assert fail equality";
		System.out.println(expected);
	}
}
