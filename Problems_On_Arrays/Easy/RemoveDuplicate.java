package Problems_On_Arrays.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Remove Duplicates in-place from Sorted Array
 * 
 * Problem Statement: Given an integer array sorted in non-decreasing order, remove the duplicates in 
 *    place such that each unique element appears only once. The relative order of the elements should
 *    be kept the same.
 * 
 * If there are k elements after removing the duplicates, then the first k elements of the array should
 *    hold the final result. It does not matter what you leave beyond the first k elements.
 * 
 * Note: Return k after placing the final result in the first k slots of the array.
 * 
 * Example 1: 
 *    Input: arr[1,1,2,2,2,3,3]
 *    Output: arr[1,2,3,_,_,_,_]
 * 
 * Example 2: 
 *    Input: arr[1,1,1,2,2,3,3,3,3,4,4]
 *    Output: arr[1,2,3,4,_,_,_,_,_,_,_]
 * 
 */

public class RemoveDuplicate {
  public static int[] arr = { 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4 };

  public static void main(String[] args) {
    System.out.println("Array taken: " + Arrays.toString(arr));
    bruteForceMethod();

    optimalSolution();
  }

  public static void bruteForceMethod() {
    Set<Integer> nonDupIntegers = new HashSet<>();

    for (int i = 0; i < arr.length; i++) {
      nonDupIntegers.add(arr[i]); // log(n)
    }

    // overall n log(n)

    System.out.println("Non Duplicate Array: " + nonDupIntegers);
  }

  public static void optimalSolution() {
    int[] uniqueArray = new int[arr.length];
    int prev = 0;
    uniqueArray[0] = arr[0];

    for (int next = 1; next < arr.length; next++) {
      if (arr[next] != uniqueArray[prev]) {
        uniqueArray[prev + 1] = arr[next];
        prev++;
      }
    }

    System.out.println("Non Duplicate Array: " + Arrays.toString(uniqueArray));
  }
}
