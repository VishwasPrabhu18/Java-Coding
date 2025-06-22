package Problems_On_Arrays.Easy;

import java.util.Arrays;

/*
 * Rotate array by K elements
 * 
 * Problem Statement: Given an array of integers, rotating array of elements by k elements
 *    either left or right.
 * 
 * Example 1:
 *    Input: N = 7, array[] = {1,2,3,4,5,6,7} , k=2 , right
 *    Output: 6 7 1 2 3 4 5
 * 
 * Example 2:
 *    Input: N = 6, array[] = {3,7,8,9,10,11} , k=3 , left 
 *    Output: 9 10 11 3 7 8
 * 
 */

/*
 * Brute force method
 *    1. Take a temp array with 1st k values
 *    2. Shift rest all elements by k 
 *    3. Add temp values at end for array
 * 
 * Optimal solution 
 *    1. Divide the arraya in 2 parts as 1st k elements and rest elements like [1,2,3], [4,5,6,7,8]
 *    2. Reverse 1st array => [3,2,1]
 *    3. Reverse 2nd array => [8,7,6,5,4]
 *    4. Combine them in single array => [3,2,1,8,7,6,5,4]
 *    5. Reverse the new array => [4,5,6,7,8,1,2,3]
 *    which is the rotated array by 3 position to left
 */
public class RotateElementByK {
  public enum Direction {
    LEFT, RIGHT
  }

  public static void main(String[] args) {
    int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
    int[] arr2 = { 3, 7, 8, 9, 10, 11 };

    // Rotation alwasy reconstruct the original array if we rotate it to sizeof arr
    // always use rotation remaining
    // if arr.length = 5 & rotation k= 14
    // then finalRzotation = 14 % 5 = 4
    System.out.println("\nTaken Array: " + Arrays.toString(arr1));
    rotateArrayElements(arr1, 2, Direction.RIGHT);
    System.out.println("\nTaken Array: " + Arrays.toString(arr2));
    rotateArrayElements(arr2, 3, Direction.LEFT);
  }

  public static void rotateArrayElements(int[] arr, int k, Direction direction) {
    if (direction.equals(Direction.LEFT)) {
      leftRotateArray(arr, k);
      System.out.print("After Left rotation by " + k + " as: " + Arrays.toString(arr));
    } else if (direction.equals(Direction.RIGHT)) {
      rightRotateArray(arr, k);
      System.out.print("After Right rotation by " + k + " as: " + Arrays.toString(arr));
    }
  }

  public static void leftRotateArray(int[] arr, int k) {
    reverseArray(0, k - 1, arr);
    reverseArray(k, arr.length - 1, arr);
    reverseArray(0, arr.length - 1, arr);
  }

  public static void rightRotateArray(int[] arr, int k) {
    reverseArray(arr.length - k, arr.length - 1, arr);
    reverseArray(0, arr.length - k - 1, arr);
    reverseArray(0, arr.length - 1, arr);
  }

  public static void reverseArray(int i, int j, int[] arr) {
    while (i <= j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }
}
