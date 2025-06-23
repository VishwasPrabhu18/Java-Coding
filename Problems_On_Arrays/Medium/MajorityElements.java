package Problems_On_Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Find the Majority Element that occurs more than N/2 times
 * 
 * Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.
 * 
 * Example 1:
 *    Input Format: N = 3, nums[] = {3,2,3}
 *    Result: 3
 * 
 * Example 2:
 *    Input Format:  N = 7, nums[] = {2,2,1,1,1,2,2}
 *    Result: 2
 * 
 * Example 3:
 *    Input Format:  N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}
 *    Result: 4
 * 
 */

public class MajorityElements {
  public static void main(String[] args) {
    int[] arr = { 4, 4, 2, 4, 3, 4, 4, 3, 2, 4 };
    // int[] arr = { 2, 2, 1, 1, 1, 2, 2 };

    System.out.println("\nGiven Array: " + Arrays.toString(arr));

    bruteForceMethod(arr);

    betterSolution(arr);

    optimalSolution(arr);
  }

  public static void bruteForceMethod(int[] arr) {
    int N = arr.length;

    for (int i = 0; i < N; i++) {
      int count = 0;
      for (int j = 0; j < N; j++) {
        if (arr[i] == arr[j])
          count++;
      }

      if (count > N / 2) {
        System.out.println("Result = " + arr[i]);
        break;
      }
    }
  }
  
  public static void betterSolution(int[] arr) {
    HashMap<Integer, Integer> hashArrCountMap = new HashMap<>();
    int N = arr.length;

    for (int i = 0; i < N; i++) {
      hashArrCountMap.put(arr[i], hashArrCountMap.getOrDefault(arr[i], 0) + 1);
    }

    for (Integer i : hashArrCountMap.keySet()) {
      if (hashArrCountMap.get(i) > N / 2) {
        System.out.println("Result: " + i);
        break;
      }
    }
  }
  
  public static void optimalSolution(int[] arr) {
    // Moore's Voting Algorithm
    /*
     * Begin by initializing two variables, num and a counter count, both of which are set to 0.
     * Now we’ll begin iterating over the number and for each element x.
     * We first check to see if the count is 0, and then we assign num to x.
     * Then we check to see if the current num is equal to x, if not, we decrease the count by one, else we increment it by one.
     * Reset the counter to zero.
     * Find the frequency of the num variable by looping through the nums array.
     * Now, if the count is larger than N/2, we return num; otherwise we return -1.
     */

    int num = -1, count = 0, N=arr.length;
    for (int i = 0; i < N; i++) {
      if (count == 0) {
        num = arr[i];
        count++;
      } else if (num == arr[i])
        count++;
      else
        count--;
    }

    int count1 = 0;
    for (int i = 0; i < N; i++) {
      if (num == arr[i])
        count1++;
    }

    if (count1 > N / 2)
      System.out.println("Result: " + num);
    else
    System.out.println("Result: -1");
  }
}
