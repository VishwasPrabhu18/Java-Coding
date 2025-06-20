package Problems_On_Arrays.Easy;

/*
 * Find Second Smallest Element in an array
 * 
 * Problem Statement: Given an array, find the second smallest element in the array. 
 *  Print ‘-1’ in the event that either of them doesn’t exist.
 * 
 * Example 1:
 *    Input: [1,2,4,7,7,5]
 *    Output: Second Smallest : 2
 * 
 * Example 2:
 *    Input: [1]
 *    Output:	Second Smallest : -1
 */

public class SecondSmallestElement {
  public static int[] arr = { 1, 2, 4, 7, 7, 5 };

  public static void main(String[] args) {
    method1();
  }

  public static void method1() {
    int smallest = arr[0];
    int secondSmallest = Integer.MAX_VALUE;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < smallest) {
        secondSmallest = smallest;
        smallest = arr[i];
      } else if (arr[i] > smallest && arr[i] < secondSmallest) {
        secondSmallest = arr[i];
      }
    }

    System.out.println("Second Smallest: " + secondSmallest);
  }
}
