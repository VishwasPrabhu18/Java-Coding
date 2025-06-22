package Problems_On_Arrays.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Union of Two Sorted Arrays
 * 
 * Problem Statement: Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of
 *     two sorted arrays.
 * The union of two arrays can be defined as the common and distinct elements in the two arrays.
 * NOTE: Elements in the union should be in ascending order.
 * 
 * Example 1:
 *    Input: n = 5,m = 5.
 *          arr1[] = {1,2,3,4,5}  
 *          arr2[] = {2,3,4,4,5}
 *    Output: {1,2,3,4,5}
 * 
 * Example 2:
 *    Input: n = 10,m = 7.
 *          arr1[] = {1,2,3,4,5,6,7,8,9,10}
 *          arr2[] = {2,3,4,4,5,11,12}
 *    Output: {1,2,3,4,5,6,7,8,9,10,11,12}

 */
public class UnionOfArrays {
  public static void main(String[] args) {
    int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };

    bruteForceMethod(arr1, arr2);

    optimalSolution(arr1, arr2);
  }

  public static void bruteForceMethod(int[] arr1, int[] arr2) {
    Set<Integer> unioSet = new HashSet<>();
    for (int i = 0; i < arr1.length; i++) {
      unioSet.add(arr1[i]);
    }
    for (int i = 0; i < arr2.length; i++) {
      unioSet.add(arr2[i]);
    }

    System.out.println("Union Array: " + unioSet);
  }

  public static void optimalSolution(int[] arr1, int[] arr2) {
    int len1 = arr1.length, len2 = arr2.length;
    int i = 0, j = 0;

    List<Integer> unionList = new ArrayList<>();
    while (i < len1 && j < len2) {
      if (arr1[i] <= arr2[j]) {
        if (unionList.size() == 0 || unionList.getLast() != arr1[i]) {
          unionList.add(arr1[i]);
        }
        i++;
      } else {
        if (unionList.size() == 0 || unionList.getLast() != arr2[j]) {
          unionList.add(arr2[j]);
        }
        j++;
      }
    }

    while (i < len1) {
      if (unionList.size() == 0 || unionList.getLast() != arr1[i]) {
        unionList.add(arr1[i]);
      }
      i++;
    }

    while (j < len2) {
      if (unionList.size() == 0 || unionList.getLast() != arr2[j]) {
        unionList.add(arr2[j]);
      }
      j++;
    }

    System.out.println("Union Array: " + unionList);
  }
}
