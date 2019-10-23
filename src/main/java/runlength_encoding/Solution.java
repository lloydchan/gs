package runlength_encoding;

class Solution {
	public static String getRunLengthEncode(String s) {

		String res = "";
		int n = s.length();
		int count = 1;

		for (int i = 0; i < n - 1; i++) {
			char c = s.charAt(i);
			char next = s.charAt(i + 1);
			if (c == next) {
				count++;
			} else {
				res += c;
				res += count;
				count = 1;
			}
		}

		// process last charcter
		char c = s.charAt(n - 1);
		res += c;
		res += count;

		return res;
	}

	public static void main(String[] args) {
		String str = "wwwwaaadexxxxxxywww";
//		String str = "w";

		String res = getRunLengthEncode(str);
		System.out.println(res);
	}
}