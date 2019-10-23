package com.matrixport.gs16;

import java.util.ArrayList;
import java.util.List;

public class MinCostPath {

	private static List<String> path = new ArrayList<>();
	
	/*
	 * A utility function that returns minimum of 3 integers
	 */
	static int min(int x, int y, int z) {
		if (x < y)
			return (x < z) ? x : z;
		else
			return (y < z) ? y : z;
	}

	/*
	 * Returns cost of minimum cost path from (0,0) to (m, n) in mat[R][C]
	 */
	static int minCost(int cost[][], int m, int n) {
//		System.out.println(m + "," + n);
		if (n < 0 || m < 0) {
			return Integer.MAX_VALUE;
		}
		else if (m == 0 && n == 0) {
			return cost[m][n];
		}
		else {
			return cost[m][n] 
					+ min(minCost(cost, m-1, n-1), minCost(cost, m-1, n), minCost(cost, m, n-1));
		}
	}

	public static void main(String[] args) {
		int cost[][] = {{ 1, 2, 3 }, 
						{ 4, 8, 2 }, 
						{ 1, 5, 3 } };

		System.out.print(minCost(cost, 2, 2));
	}

}
