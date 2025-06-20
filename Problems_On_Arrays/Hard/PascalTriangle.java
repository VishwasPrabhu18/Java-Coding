package Problems_On_Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

/* ***************************************
 * Program to generate Pascal's Triangle
 * ***************************************
 * 
 * Problem Statement: This problem has 3 variations. They are stated below:
 *    #1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
 *    #2: Given the row number n. Print the n-th row of Pascal’s triangle.
 *    #3: Given the number of rows n. Print the first n rows of Pascal’s triangle
 */

public class PascalTriangle {
  public static void main(String[] args) {
    // Easiest way to find the #1 is using nCr formula with n-1Cr-1
    // find 4th row 3rd values => (4-1)C(3-1) => 3C2 => 3

    int N = 7, R = 4;
    // Variant 1
    long result_of_1 = findN_C_R(N - 1, R - 1);
    System.out.println("\nSolutions:\n#1 => " + result_of_1);

    // Variant 2
    System.out.print("\n#2 => ");
    // This method uses extra complexity
    // print_Nth_pascal_triangle_values_method_1(N);

    // to reduce we can try an different method or formula
    print_Nth_pascal_triangle_values_method_2(N);

    // Variant 3
    System.out.println("\n#3 => \n" + print_pascal_triangle(N));
  }

  public static long findN_C_R(int n, int r) {
    int N = n - 1, R = r - 1;
    long res = 1;
    for (int i = 0; i < R; i++) {
      res = res * (N - i);
      res = res / (i + 1);
    }

    return res;
  }

  public static void print_Nth_pascal_triangle_values_method_1(int n) {
    for (int i = 1; i <= n; i++) {
      long res = findN_C_R(n, i);
      System.out.print(res + " ");
    }
    System.out.println();
  }

  public static void print_Nth_pascal_triangle_values_method_2(int N) {
    // Here we use a different formula as
    // suppose the res for 7th row as => 1 6 15 20 15 6 1
    /*
     * here 1st and last values are 1
     * 2nd values is N-1 / i where i is 1 -> N (because we starts from 2nd values)
     * along with previous result multiplied
     * res = res * (N-1) / i
     */

    long res = 1;
    System.out.print(res + " ");
    for (int i = 1; i < N; i++) {
      res = res * (N - i) / i;
      System.out.print(res + " ");
    }
  }

  public static List<List<Long>> print_pascal_triangle(int N) {
    List<List<Long>> mainRes = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      long res = 1;
      List<Long> tempList = new ArrayList<>();
      tempList.add(res);
      for (int j = 1; j < i; j++) {
        res = res * (i - j) / j;
        tempList.add(res);
      }

      mainRes.add(tempList);
    }

    return mainRes;
  }
}
