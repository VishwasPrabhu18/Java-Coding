package Problems_On_Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Two Sum : Check if a pair with given sum exists in Array
 * 
 * Problem Statement: Given an array of integers arr[] and an integer target.
 * 
 * 1st variant: Return YES if there exist two numbers such that their sum is equal to the target. 
 *              Otherwise, return NO.
 * 2nd variant: Return indices of the two numbers such that their sum is equal to the target. 
 *              Otherwise, we will return {-1, -1}.
 * 
 * Note: You are not allowed to use the same element twice. Example: If the target is equal to 6 and 
 *       num[1] = 3, then nums[1] + nums[1] = target is not a solution.
 * 
 * Example 1:
 *      Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
 *      Result: YES (for 1st variant)
 *              [1, 3] (for 2nd variant)
 * 
 * Example 2:
 *      Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 15
 *      Result: NO (for 1st variant)
 *              [-1, -1] (for 2nd variant)
 * 
 */

public class TwoSum {
  public static void main(String[] args) {
    int[] arr = { 2, 6, 5, 8, 11 };
    int target = 14;

    System.out.println("\nGiven Array: " + Arrays.toString(arr) + "\nTarget: " + target);
    String res1 = bruteForce_variant1(arr, target);
    System.out.println("Variant #1 => Is found: " + res1);
    List<Integer> resList1 = bruteForce_variant2(arr, target);
    System.out.println("Variant #2 => Result: " + resList1);

    String res2 = betterSolution_varian1(arr, target);
    System.out.println("Variant #1 => Is found: " + res2);
    List<Integer> resList2 = bruteForce_variant2(arr, target);
    System.out.println("Variant #2 => Result: " + resList2);

    optimalSolution_variant1(arr, target);
  }

  public static String bruteForce_variant1(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        if (arr[i] + arr[j] == target) {
          return "YES";
        }
      }
    }

    return "NO";
  }

  public static List<Integer> bruteForce_variant2(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        if (arr[i] + arr[j] == target) {
          return List.of(i, j);
        }
      }
    }

    return List.of(-1, -1);
  }

  public static String betterSolution_varian1(int[] arr, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      int res = target - arr[i];
      if (!hashMap.containsKey(res)) {
        hashMap.put(arr[i], i);
      } else {
        return "YES";
      }
    }
    return "NO";
  }

  public static List<Integer> betterSolution_varian2(int[] arr, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      int res = target - arr[i];
      if (!hashMap.containsKey(res)) {
        hashMap.put(arr[i], i);
      } else {
        return List.of(hashMap.get(arr[i]), i);
      }
    }
    return List.of(-1, -1);
  }

  public static void optimalSolution_variant1(int[] arr, int target) {
    // We can't optimize this further for variant 2
    int left = 0, right = arr.length - 1;

    Arrays.sort(arr); // Sorting is needed

    while (left <= right) {
      int res = arr[left] + arr[right];

      if (res == target) {
        System.out.println("TwoSum fond: YES");
        return;
      }

      if (res > target) {
        right--;
      } else {
        left++;
      }
    }

    System.out.println("TwoSum found: NO");
  }
}
