package com.matrixport.gs33;

public class CircleLatticePoints {

	public static int getLatticePointsOrigin(int r, int x0, int y0) {
		// x^2 + y^2 = r^2
		if (r < 0)
			return -1;

		int r_2 = r * r;
		int count = 0;

		for (int x = x0-r; x <= x0+r; x++) {
			int y_2 = r_2 - x * x;
			int y = (int) Math.sqrt(r_2 - x * x);
			System.out.println(x + "," + y_2 +"," + y);
			if (y_2 == (y * y)) {
				count += 1;
				System.out.println("added=" + x + "," + y);
			}
			int y_negative = -1 * y;
			System.out.println(x + "," + y + "," + y_2 + ",neg=" + y_negative);
			if (x != x0-r && x != x0+r && y_2 == (y_negative * y_negative)) {
				count += 1;
				System.out.println("added=" + x + "," + y_negative);
			}
		}
//		for (int x = x0 - r; x <= x0 + r; x++) {
//			int y_2 = r_2 - (x - x0) * (x - x0);
//			int y = (int) Math.sqrt(r_2 - (x - x0) * (x - x0));
//			if (y_2 == (y - y0) * (y - y0)) {
//				count += 1;
//				System.out.println((x-x0) + "," + (y-y0));
//			}
//			int y_negative = -1 * y;
//			if (y != y_negative && y_2 == ((y_negative-y0) * (y_negative-y0))) {
//				count += 1;
//				System.out.println((x-x0) + "," + (y_negative-y0));
//			}
//		}

		return count;
	}
	
	public static int getLatticePoints(int r) {
		// x^2 + y^2 = r^2
		if (r < 0)
			return -1;

		int r_2 = r * r;
		int count = 0;

		for (int x = -1 * r; x <= r; x++) {
			int y_2 = r_2 - x * x;
			int y = (int) Math.sqrt(r_2 - x * x);
			if (y_2 == (y * y)) {
				count += 1;
				System.out.println(x + "," + y);
			}
			int y_negative = -1 * y;
			if (x != -r && x != r && y_2 == (y_negative * y_negative)) {
				count += 1;
				System.out.println(x + "," + y_negative);
			}
		}

		return count;
	}
	
	public static void main(String[] args) {
		int r = 6;
		System.out.println(getLatticePoints(r));
//		System.out.println(getLatticePointsOrigin(r, 1, 0));
	}
}
