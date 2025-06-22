package Problems_On_Arrays.Easy;

import java.util.Arrays;

/*
 * Count Maximum Consecutive One's in the array
 * 
 * Problem Statement: Given an array that contains only 1 and 0 return the count of maximum 
 *  consecutive ones in the array.
 * 
 * Example 1:
 *    Input: prices = {1, 1, 0, 1, 1, 1}
 *    Output: 3
 * 
 * Example 2:
 *    Input: prices = {1, 0, 1, 1, 0, 1} 
 *    Output: 2
 * 
 */
public class MaxConsecutiveOnce {
public static void main(String[] args) {
  int arr[] = { 1, 1, 0, 1, 1, 1, 0, 1, 1 };

  System.out.println("Given Array: " + Arrays.toString(arr));
  
  int count = 0, maxConsecutive = 0;
  for (int i = 0; i < arr.length; i++) {
    if (arr[i] == 0)
    count = 0;
    else
    count++;
    
    if (count > maxConsecutive)
    maxConsecutive = count;
  }
  
  System.out.println("Maximum consecutive once: " +maxConsecutive);
}
}
