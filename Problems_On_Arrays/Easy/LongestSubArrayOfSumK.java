package Problems_On_Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

/*
 * Longest Subarray with given Sum K(Positives)
 * 
 * Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray
 *  that sums to k.
 * 
 * Example 1:
 *    Input Format: N = 3, k = 5, array[] = {2,3,5}
 *    Result: 2
 * 
 * Example 2:
 *    Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
 *    Result: 3
 * 
 */

public class LongestSubArrayOfSumK {
  public static int N = 5;
  public static int k = 10;
  public static int arr[] = { 2, 2, 5, 1, 9, 10 };

  public static void main(String[] args) {
    bruteForceSolution();
    betterSolution();
    optimalSolution();
  }

  public static void bruteForceSolution() {
    int maxSubArrCount = 0;

    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      int count = 0;
      for (int j = i; j < arr.length; j++) {
        if (sum == k) {
          if (count > maxSubArrCount) {
            maxSubArrCount = count;
          }
        } else if (sum > k) {
          break;
        } else {
          sum += arr[j];
          count++;
        }
      }
    }

    System.out.println("Maximum length: " + maxSubArrCount);
  }

  public static void betterSolution() {
    // This method will be the optimal solution where we have both +ve, 0's and -ve
    Map<Long, Integer> preSumArMap = new HashMap<>();
    long sum = 0;
    long maxLength = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];

      if (sum == k) {
        maxLength = Math.max(maxLength, i + 1);
      }

      long remaining = k - sum;
      if (preSumArMap.containsKey(remaining)) {
        int len = i - preSumArMap.get(remaining);
        maxLength = Math.max(maxLength, len);
      }

      if (!preSumArMap.containsKey(sum)) {
        preSumArMap.put(sum, i);
      }
    }

    System.out.println("Maximum length: " + maxLength);
  }

  public static void optimalSolution() {
    int maxSubArrCount = 0;
    int i = 0, j = 0;
    int sum = 0;

    while (i < arr.length) {
      sum += arr[i];

      if (sum == k) {
        int count = (i - j) + 1;
        if(count > maxSubArrCount) 
          maxSubArrCount = count;
      } else if (sum > k) {
        j++;
      }

      i++;
    }

    System.out.println("Maximum length: " + maxSubArrCount);
  }
}