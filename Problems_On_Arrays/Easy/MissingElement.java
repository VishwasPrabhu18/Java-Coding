package Problems_On_Arrays.Easy;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Find the missing number in an array
 * 
 * Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. 
 *  Find the number(between 1 to N), that is not present in the given array.
 * 
 * Example 1:
 *    Input Format: N = 5, array[] = {1,2,4,5}
 *    Result: 3
 * 
 * Example 2:
 *    Input Format: N = 3, array[] = {1,3}
 *    Result: 2
 * 
 */

public class MissingElement {
  public static void main(String[] args) {
    int N = 5;
    int[] arr = { 1, 2, 3, 4 };

    System.out.println("Given Array: " + Arrays.toString(arr));
    method1(N, arr);
    method2(N, arr);
    method3(N, arr);
    method4(N, arr);
  }

  public static void method1(int n, int[] arr) {
    for (int i = 1; i <= n; i++) {
      int flag = 0;
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] == i) {
          flag = 1;
          break;
        }
      }

      if (flag == 0) {
        System.out.println("Missing number: " + i);
        break;
      }
    }
  }

  public static void method2(int n, int[] arr) {
    // Using the concept of Hash
    // declare a hash array of size N + 1
    // inset 1 to the array if the element exists
    // reiterate and check whether any of the vaues not set to 1 from 1 to N
    HashMap<Integer, Integer> hashArrMap = new HashMap<>();
    for (int i = 0; i < n + 1; i++) {
      hashArrMap.put(i, 0);
    }

    for (int i = 0; i < arr.length; i++) {
      hashArrMap.put(arr[i], 1);
    }

    for (int i = 1; i <= n; i++) {
      if (hashArrMap.get(i) != 1) {
        System.out.println("Missing number: " + i);
        break;
      }
    }
  }

  public static void method3(int n, int[] arr) {
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }

    // Here we use the formula sum of numbers S = N ( N + 1) / 2
    // the diff = S - sum
    long S = n * (n + 1) / 2;
    long res = S - sum;
    System.out.println("Missing number: " + res);
  }

  public static void method4(int n, int[] arr) {
    int xorValue1 = 0, xorValue2 = 0;
    for (int i = 0; i < n - 1; i++) {
      xorValue2 = xorValue2 ^ arr[i];
      xorValue1 = xorValue1 ^ (i + 1);
    }

    xorValue1 = xorValue1 ^ n;
    int res = xorValue1 ^ xorValue2;
    System.out.println("Missing number: " + res);
  }
}
