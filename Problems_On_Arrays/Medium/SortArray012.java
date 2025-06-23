package Problems_On_Arrays.Medium;

import java.util.Arrays;

/*
 * Sort an array of 0s, 1s and 2s
 * 
 * Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
 * 
 * Examples
 *    Input: nums = [2,0,2,1,1,0]
 *    Output: [0,0,1,1,2,2]
 * 
 *    Input: nums = [2,0,1]
 *    Output: [0,1,2]
 * 
 *    Input: nums = [0]
 *    Output: [0]
 */

public class SortArray012 {
  public static void main(String[] args) {
    int[] arr = { 2, 0, 2, 1, 1, 0 };

    System.out.println("\nGiven Array: " + Arrays.toString(arr));

    // bruteForceMethod(arr);

    // betterSolution(arr);

    optimalSolution(arr);
  }

  public static void bruteForceMethod(int[] arr) {
    // Use any sortng algorithm
    // 1. Bubble Sort
    int[] bubbleSortArr = bubbleSort(arr);
    System.out.println(Arrays.toString(bubbleSortArr));
  }

  public static void betterSolution(int[] arr) {
    int count0 = 0, count1 = 0, count2 = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0)
        count0++;
      else if (arr[i] == 1)
        count1++;
      else if (arr[i] == 2)
        count2++;
    }

    for (int i = 0; i < count0; i++) {
      arr[i] = 0;
    }

    for (int i = count0; i < count0 + count1; i++) {
      arr[i] = 1;
    }
    for (int i = count0 + count1; i < arr.length; i++) {
      arr[i] = 2;
    }

    System.out.println(Arrays.toString(arr));

  }

  public static void optimalSolution(int[] arr) {
    // Using the famous algo
    /*
     * Dutch National Flag Algorithm
     * 
     * Procedure:
     * 1. Use 3 pointers => low, mid, high
     * 2. Initially => low=0, mid=0 and high=arr,length-1
     * 3. here from low -> mid-1 => sorted and mid -> high => unsorted
     * 4. if mid == 0
     * swap(arr[low], arr[mid]), low++, mid++;
     * 5. if mid == 1
     * mid++;
     * 6. if mid == 2
     * swap(arr[mid], arr[high]), high--;
     */

    int low = 0, mid = 0, high = arr.length - 1;

    while (mid <= high) {
      if (arr[mid] == 0) {
        swapArrValues(arr, mid, low);
        mid++;
        low++;
      } else if (arr[mid] == 1) {
        mid++;
      } else if (arr[mid] == 2) {
        swapArrValues(arr, mid, high);
        high--;
      }
    }

    System.out.println("Sorted Array: " + Arrays.toString(arr));
  }

  public static int[] bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
  }

  public static void swapArrValues(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
