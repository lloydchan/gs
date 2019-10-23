package com.matrixport.gs36;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindAllSubsequence3 {
	
//	public static int printAllSubsequence(Integer[] a) {
//		int n = a.length;
//		int count = 0;
//		
//		for (int i=0; i<n; i++) {
//			for (int j=i+1; j<n; j++) {
//				for (int k=j+1; k<n; k++) {
//					count++;
//				}
//			}
//		}
//		return count;
//	}

	public static Set<String> getAllDistinctSubsequenceLength3(Integer[] a) {
		int n = a.length;
		int count = 0;
		Set<String> dup = new HashSet<>();
		
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				for (int k=j+1; k<n; k++) {
					String subseq = a[i] + "," + a[j] + "," + a[k];
					if (! dup.contains(subseq)) {
						count++;
						dup.add(subseq);
					} 
				}
			}
		}
		return dup;
	}

	private static Set<String> seqN = new HashSet<>();
	public static void getAllDistinctSubsequenceLengthN(Integer[] a, String subSeq, int k, int subLen) {
		int n = a.length;
		if (subLen > 2) {
			return;
		}
		
		for (int i=k; i<n; i++) {
			if (subLen == 2) {
				seqN.add(subSeq + "," + a[i]);
			}
			getAllDistinctSubsequenceLengthN(a, subSeq + "," + a[i], i+1, subLen+1);
		}
	}

	private static int findIncreaseAllSubseqSize3(Integer[] a) {
		Set<String> seq = getAllDistinctSubsequenceLength3(a);
		int count = 0;
		for (String s : seq) {
			String[] tokens = s.split(",");
			int i0 = Integer.parseInt(tokens[0]);
			int i1 = Integer.parseInt(tokens[1]);
			int i2 = Integer.parseInt(tokens[2]);
			if (i0 < i1 && i1 < i2) {
				System.out.println(i0 + "," + i1 + "," + i2);
				count++;
			}
		}
		return count;
	}
	
//	private static final Set<String> SEQUENCE = new HashSet<>();
	
//	public static void getAllDistinctSubsequenceN(Integer[] a, List<Integer> subs, int nSubSeq, int i) {
////		System.out.println(prevSub + "," + nSubSeq + "," + i);
//		
//		int n = a.length;
//		if (i > n-1)	{	// end of array 
//			return;
//		}
//		
//		if (subs.size() == nSubSeq) {
//			String sub = subs.stream().map(Object::toString).collect(Collectors.joining(","));
//			SEQUENCE.add(sub);
//			System.out.println(sub);
//			return;
//		}
//		
//		getAllDistinctSubsequenceN(a, prevSub + "," + a[i], nSubSeq-1, i+1);
//	}
	
	public static void main(String[] args) {
//		int a[] = {1, 2, 4, 3};
//		Integer a[] = {1, 1, 1, 2, 2, 2};
		Integer a[] = {2, 6, 4, 5, 7};
		
//		Arrays.sort(a);
//		Arrays.sort(a, Collections.reverseOrder());
//		for (int i : a) {
//			System.out.println(i);
//		}
		
		int output = findIncreaseAllSubseqSize3(a);
		System.out.println(output);
		System.out.println("===============================");
		
		getAllDistinctSubsequenceLengthN(a, "", 0, 0);
		for (String s : seqN) {
			System.out.println(s);
		}
//		getAllDistinctSubsequenceN(a, "", 2, 0);
//		System.out.println(SEQUENCE.size());
	}
}
