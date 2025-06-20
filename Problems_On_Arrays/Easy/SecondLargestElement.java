package Problems_On_Arrays.Easy;

/*
 * Find Second Largest Element in an array
 * 
 * Problem Statement: Given an array, find the second largest element in the array. 
 *  Print ‘-1’ in the event that either of them doesn’t exist.
 * 
 * Example 1:
 *    Input: [1,2,4,7,7,5]
 *    Output: Second Largest : 5
 * 
 * Example 2:
 *    Input: [1]
 *    Output:	Second Largest : -1
 */

public class SecondLargestElement {
  public static int[] arr = { 1, 2, 4, 7, 7, 5 };

  public static void main(String[] args) {
    method1();
  }

  public static void method1() {
    int largest = arr[0];
    int secondLargest = -1;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > largest) {
        secondLargest = largest;
        largest = arr[i];
      } else if (arr[i] < largest && arr[i] > secondLargest) {
        secondLargest = arr[i];
      }
    }

    System.out.println("Second Largest: " + secondLargest);
  }
}
