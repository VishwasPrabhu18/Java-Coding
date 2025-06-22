package Problems_On_Arrays.Easy;

import java.util.Arrays;

/*
 * Find the Largest element in an array
 * 
 * Problem Statement: Given an array, we have to find the largest element in the array.
 * Example 1:
 *    Input: arr[] = {2,5,1,3,0};
 *    Output: 5
 *    Explanation: 5 is the largest element in the array. 
 * 
 * Example2: 
 *    Input: arr[] = {8,10,5,7,9};
 *    Output: 10
 *    Explanation: 10 is the largest element in the array. 
 */

public class LargestElement {
  public static int[] arr = { 8, 10, 5, 7, 9 };

  public static void main(String[] args) {
    System.out.println("Array taken => " + Arrays.toString(arr));
    method1();
    method2();
  }

  public static void method1() {
    int maxVal = arr[0];

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > maxVal) {
        maxVal = arr[i];
      }
    }

    System.out.println("Method #1 => Largest value is: " + maxVal);
  }
  
  public static void method2() {
    int i = 0, j = arr.length - 1;
    int maxVal = Integer.MIN_VALUE;

    while (i <= j) {
      if (arr[i] < arr[j]) {
        if (arr[j] > maxVal) {
          maxVal = arr[j];
        }
      } else {
        if (arr[i] > maxVal) {
          maxVal = arr[i];
        }
      }
      i++;
      j--;
    }

    System.out.println("Method #2 => Largest value is: " + maxVal);
  }
}
