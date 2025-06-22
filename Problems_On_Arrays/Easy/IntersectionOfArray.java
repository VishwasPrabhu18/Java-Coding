package Problems_On_Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

/*
 * Intersection of Two Sorted Arrays
 * 
 * Problem Statement: Given two sorted arrays, arr1, and arr2 of size n and m. Find the intersection of
 *     two sorted arrays.
 * The intersection of two arrays can be defined as the common elements in the two arrays.
 * NOTE: Elements in the intersection should be in ascending order.
 * 
 * Example 1:
 *    Input: n = 5,m = 5.
 *          arr1[] = {1,2,3,4,5}  
 *          arr2[] = {2,3,4,4,5}
 *    Output: {2,3,4,5}
 * 
 * Example 2:
 *    Input: n = 10,m = 7.
 *          arr1[] = {1,2,3,4,5,6,7,8,9,10}
 *          arr2[] = {2,3,4,4,5,11,12}
 *    Output: {2,3,4,5}

 */

public class IntersectionOfArray {
  public static void main(String[] args) {
    int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };

    bruteForce1(arr1, arr2);

    optimalSolution(arr1, arr2);
  }

  public static void bruteForce1(int[] arr1, int[] arr2) {
    List<Integer> arrList = new ArrayList<>();
    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr2.length; j++) {
        if (arr1[i] == arr2[j]) {
          if (arrList.size() == 0 || arrList.getLast() != arr1[i]) {
            arrList.add(arr1[i]);
            break;
          }
        }
      }
    }

    System.out.println(arrList);
  }

  public static void optimalSolution(int[] arr1, int[] arr2) {
    int len1 = arr1.length, len2 = arr2.length;
    int i = 0, j = 0;
    List<Integer> intersectList = new ArrayList<>();

    while (i < len1 && j < len2) {
      if (arr1[i] < arr2[j]) {
        i++;
      } else if (arr2[j] < arr1[i]) {
        j++;
      } else {
        intersectList.add(arr1[i]);
        i++;
        j++;
      }
    }

    System.out.println(intersectList);
  }
}
