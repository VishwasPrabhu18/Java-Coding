package Problems_On_Arrays.Medium;

import java.util.Arrays;

/* ****************
 * Set Matrix Zero
 * ****************
 * Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire 
 * column and row to 0 and then return the matrix.
 * 
 * 
 * Given an 2D matrix where we need to replace all corresponding row & column value to 0
 *  if any (row, column) = 0
 * 
 * Ex: 1 1 1 1 1                1 0 0 1 0
 *     1 1 0 1 1                0 0 0 0 0
 *     1 0 1 1 0       ====>    0 0 0 0 0
 *     1 1 1 1 1                1 0 0 1 0
 *     1 1 1 1 1                1 0 0 1 0
 * 
 */

public class SetMatrixZeroes {
  private static int[][] arr = {
      { 1, 1, 1, 1, 1 },
      { 1, 1, 0, 1, 1 },
      // { 1, 0, 1, 1, 0 },
      { 1, 0, 1, 1, 1 },
      { 1, 1, 1, 1, 1 },
      // { 1, 1, 1, 1, 1 }
      { 0, 1, 1, 1, 1 }
  };

  private static int M = arr[0].length; // row size
  private static int N = arr.length; // column size

  public static void main(String[] args) {
    // bruteForceMethod();
    // optimize1();
    optimize2();
  }

  public static void bruteForceMethod() {
    // Replace all the vertical & horizontal values to -1 then convert to 0
    // Time complexity = (N * M)(N + M) + (N * M)
    displayArr(arr);
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] == 0) {
          rowReplace(i);
          columnReplace(j);
        }
      }
    }

    replaceAllNegtvWithZero(arr);
    System.out.println();
    displayArr(arr);
  }

  public static void rowReplace(int n) {
    // replace entire row with -1
    for (int i = 0; i < M; i++) {
      if (arr[n][i] != 0)
        arr[n][i] = -1;
    }
  }

  public static void columnReplace(int n) {
    // replace entire column with -1
    for (int i = 0; i < N; i++) {
      if (arr[i][n] != 0)
        arr[i][n] = -1;
    }
  }

  public static void replaceAllNegtvWithZero(int[][] arr) {
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] != 1) {
          arr[i][j] = 0;
        }
      }
    }
  }

  public static void optimize1() {
    // Time complexity (N * M ) + (N * M)
    displayArr(arr);
    int[] rowValFinder = new int[M];
    int[] colValFinder = new int[N];

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == 0) {
          rowValFinder[i] = 1;
          colValFinder[j] = 1;
        }
      }
    }
    System.out.println("\n" + Arrays.toString(rowValFinder));
    System.out.println(Arrays.toString(colValFinder));

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (rowValFinder[i] == 1 || colValFinder[j] == 1) {
          arr[i][j] = 0;
        }
      }
    }

    displayArr(arr);
  }

  public static void optimize2() {
    // use the optimize1() method 
    // instead of using extra space implement it in same arr

    int col0 = 1;

    displayArr(arr);

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[0][j] == 0 || arr[i][0] == 0) {
          col0 = 0;
        } else if (arr[i][j] == 0) {
          arr[0][j] = 0;
          arr[i][0] = 0;
        }
      }
    }

    displayArr(arr);

    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr[0].length; j++) {
        if (arr[0][j] == 0 || arr[i][0] == 0) {
          arr[i][j] = 0;
        }
      }
    }

    displayArr(arr);

    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[0][0] == 0)
        arr[0][i] = 0;
    }
    
    displayArr(arr);

    for (int i = arr.length - 1; i >= 0; i--) {
      if (col0 == 0)
        arr[i][0] = 0;
    }
    
    displayArr(arr);
  }

  public static void displayArr(int[][] arr) {
    System.out.println();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}