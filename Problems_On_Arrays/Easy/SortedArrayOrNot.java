package Problems_On_Arrays.Easy;

import java.util.Arrays;

/*
 * Check if an Array is Sorted
 * 
 * Problem Statement: Given an array of size n, write a program to check if the given array is sorted in
 *    (ascending / Increasing / Non-decreasing) order or not. If the array is sorted then return True, 
 *     Else return False.
 * 
 * Note: Two consecutive equal values are considered to be sorted.
 * 
 * Example 1:
 *    Input: N = 5, array[] = {1,2,3,4,5}
 *    Output: True.
 * 
 * Example 2
 *    Input: N = 5, array[] = {5,4,6,7,8}
 *    Output: False.
 * 
 */

public class SortedArrayOrNot {
  public static int[] sortedArr = { 1, 2, 3, 4, 5 };
  public static int[] unSortedArr = { 5, 4, 6, 7, 8 };

  public static void main(String[] args) {
    System.out.println("Given Array: " + Arrays.toString(sortedArr));
    System.out.println("Is sorted: " + isSortedArray(sortedArr));
    System.out.println("\nGiven Array: " + Arrays.toString(unSortedArr));
    System.out.println("Is sorted: " + isSortedArray(unSortedArr));
  }

  public static boolean isSortedArray(int[] arr) {
    for (int i = 0; i < arr.length-1; i++) {
      if (arr[i] > arr[i + 1])
        return false;
    }
    
    return true;
  }
}
