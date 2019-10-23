package com.matrixport.gs35;

public class MaxConsecutiveRepeatingChar {

    static char getMaxConsecutiveRepeatChar(String str) 
    { 
        int n = str.length(); 
        int count = 0; 
        char res = str.charAt(0); 
        int cur_count = 1; 
  
        // Traverse string except last character 
        for (int i = 0; i < n; i++) 
        { 
            // If current character matches with next 
            if (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) 
                cur_count++; 
  
            // If doesn't match, update result 
            // (if required) and reset count 
            else
            { 
                if (cur_count > count) 
                { 
                    count = cur_count; 
                    res = str.charAt(i); 
                } 
                cur_count = 1; 
            } 
        } 
        return res; 
    } 
	
	public static void main(String[] args) {
//		String input = "aaaabbaaccde";
		String input = "aaaabbaaccdeeeee";
		
		char max = getMaxConsecutiveRepeatChar(input);
		System.out.println(max);
	}

}
