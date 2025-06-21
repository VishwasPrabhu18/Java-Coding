package Problems_On_Arrays.Easy;

import java.util.Arrays;

/*
 * Move all Zeros to the end of the array
 * 
 * Problem Statement: You are given an array of integers, your task is to move all the zeros in the
 *     array to the end of the array and move non-negative integers to the front by maintaining their order.
 * 
 * Example 1:
 *    Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
 *    Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
 * 
 * Example 2:
 *    Input: 1,2,0,1,0,4,0
 *    Output: 1,2,1,4,0,0,0
 * 
 */

public class MoveZerosToEnd {
  public static int[] arr = { 1, 0, 2, 3, 0, 4, 0, 1 };

  public static void main(String[] args) {
    System.out.println("\nTaken Array: " + Arrays.toString(arr));
    bruteForceMethod();

    optimalSolution();
  }

  public static void bruteForceMethod() {
    int[] newArr = new int[arr.length];

    int idx = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        newArr[idx] = arr[i];
        idx++;
      }
    }

    System.out.println("BruteForce Method => Array: " + Arrays.toString(newArr));
  }

  public static void optimalSolution() {
    int cur = 0, next = 1;

    while (next < arr.length) {
      if (arr[cur] != 0) {
        cur++;
        next++;
      } else if (arr[cur] == 0 && arr[next] != 0) {
        int temp = arr[cur];
        arr[cur] = arr[next];
        arr[next] = temp;
      } else {
        next++;
      }

    }

    System.out.println("Optimal Solution => Array: " + Arrays.toString(arr));
  }
}
