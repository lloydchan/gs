package com.matrixport.gs36;
class CountSub { 
  
	static int countSubIncrease(int arr[], int n) {
		int[] cSub = new int[n];

		/* Initialize cSub values for all indexes */
		for (int i = 0; i < n; i++)
			cSub[i] = 1;

		for (int i = 1; i < n; i++)
			for (int j = 0; j < i; j++)
				if (arr[i] > arr[j])
					cSub[i] += cSub[j];

		int result = 0;
		for (int i = 0; i < n; i++)
			result += cSub[i];

		return result;
	}

	static int countSubDecrease(int arr[], int n) {
		int[] cSub = new int[n];
		
		/* Initialize cSub values for all indexes */
		for (int i = 0; i < n; i++)
			cSub[i] = 1;
		
		for (int i = 1; i < n; i++)
			for (int j = 0; j < i; j++)
				if (arr[i] < arr[j])
					cSub[i] += cSub[j];
		
		int result = 0;
		for (int i = 0; i < n; i++)
			result += cSub[i];
		
		return result;
	}
	
//    // Function To Count all the sub-sequences 
//    // possible in which digit is greater than 
//    // all previous digits arr[] is array of n 
//    // digits 
//    static int countSub(int arr[], int n) 
//    { 
//        // count[] array is used to store all 
//        // sub-sequences possible using that  
//        // digit count[] array covers all  
//        // the digit from 0 to 9 
//        int count[] = new int[10];   
//  
//        // scan each digit in arr[]  
//        for (int i = 0; i < n; i++) 
//        { 
//            // count all possible sub- 
//            // sequences by the digits 
//            // less than arr[i] digit 
//            for (int j = arr[i] - 1; j >= 0; j--) 
//                count[arr[i]] += count[j];   
//                  
//            // store sum of all sub-sequences plus 1 in count[] array 
//            count[arr[i]]++; 
//        }    
//  
//        // now sum up the all sequences 
//        // possible in count[] array 
//        int result = 0; 
//        for (int i = 0; i < 10; i++) 
//            result += count[i]; 
//  
//        return result; 
//    } 
  
	// Driver program to run the test case
	public static void main(String[] args) {
		int arr[] = { 3, 2, 4, 5, 4 };
		int n = arr.length; // res = 14
//        int arr[] = {1, 2, 3, 4}; 
//        int n = arr.length; // res = 15
//        int arr[] = {4, 3, 6, 5}; 
//        int n = arr.length; // res = 8
//        int arr[] = {1, 2, 4}; 
//        int n = arr.length; // res = 7

//		System.out.println(countSubIncrease(arr, n));
		System.out.println(countSubDecrease(arr, n));
	}
} 