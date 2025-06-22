package Problems_On_Arrays.Easy;

import java.util.Arrays;

/*
 * Left Rotate the Array by One
 * 
 * Problem Statement: Given an array of N integers, left rotate the array by one place.
 * 
 * Example 1:
 *    Input: N = 5, array[] = {1,2,3,4,5}
 *    Output: 2,3,4,5,1
 * 
 * Example 2:
 *    Input: N = 1, array[] = {3}
 *    Output: 3
 * 
 */

public class LeftRotateByOne {
  public static int[] arr = { 1, 2, 3, 4, 5 };

  public static void main(String[] args) {
    System.out.println("Original Array: " + Arrays.toString(arr));

    // Time complexity O(n)
    int cur = arr[0];

    for (int i = 1; i < arr.length; i++) {
      arr[i - 1] = arr[i];
    }

    arr[arr.length - 1] = cur;

    System.out.println("After Left Rotate(1): " + Arrays.toString(arr));
  }
}
