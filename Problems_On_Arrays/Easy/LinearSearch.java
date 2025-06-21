package Problems_On_Arrays.Easy;

import java.util.Arrays;

/*
 * Linear Search in C
 * 
 * Problem Statement: Given an array, and an element num the task is to find if num is present
 *    in the given array or not. If present print the index of the element or print -1.
 * 
 * Example 1:
 *    Input: arr[]= 1 2 3 4 5, num = 3
 *    Output: 2
 * 
 * Example 2:
 *    Input: arr[]= 5 4 3 2 1, num = 5
 *    Output: 0
 */

public class LinearSearch {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
    int num = 5;

    int idx = seach_an_numeber(arr, num);
    System.out.println("\nGiven Array: " + Arrays.toString(arr));
    System.out.println("Element " + num + (idx != -1 ? " found at index: " + idx : " Not found"));
  }

  public static int seach_an_numeber(int[] arr, int num) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == num)
        return i;
    }
    
    return -1;
  }
}
