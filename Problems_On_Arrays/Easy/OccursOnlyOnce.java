package Problems_On_Arrays.Easy;

import java.util.HashMap;

/*
 * Find the number that appears once, and the other numbers twice
 * 
 * Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one.
 *  Find that single one.
 *
 * Example 1:
 *    Input Format: arr[] = {2,2,1}
 *    Result: 1
 * 
 * Example 2:
 *    Input Format: arr[] = {4,1,2,1,2}
 *    Result: 4
 * 
 */
public class OccursOnlyOnce {
  public static void main(String[] args) {
    int[] arr = { 4, 1, 2, 1, 2 };

    bruteForceSolution(arr);

    betterSolution(arr);

    optimalSolution(arr);
  }

  public static void bruteForceSolution(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int counter = 0;
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          counter++;
        }
      }

      if (counter == 1) {
        System.out.println("Single non-repetable number: " + arr[i]);
        break;
      }
    }
  }

  public static void betterSolution(int[] arr) {
    HashMap<Integer, Integer> hasArrMap = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      hasArrMap.put(arr[i], hasArrMap.getOrDefault(arr[i], 0) + 1);
    }

    for (int i : hasArrMap.keySet()) {
      if (hasArrMap.get(i) == 1) {
        System.out.println("Single non-repetable number: " + i);
        break;
      }
    }
  }

  public static void optimalSolution(int[] arr) {
    int xorValue = 0;
    for (int i = 0; i < arr.length; i++) {
      xorValue = xorValue ^ arr[i];
    }

    System.out.println("Single non-repetable number: " + xorValue);
  }
}
