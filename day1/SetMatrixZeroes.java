package day1;

import java.util.Arrays;

/*
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
      { 1, 0, 1, 1, 0 },
      { 1, 1, 1, 1, 1 },
      { 1, 1, 1, 1, 1 }
  };

  private static int M = arr[0].length; // row size
  private static int N = arr.length; // column size

  public static void main(String[] args) {

    displayArr(arr);
    bruteForceMethod(arr);
    System.out.println();
    displayArr(arr);
  }

  public static void bruteForceMethod(int[][] arr) {
    // Replace all the vertical & horizontal values to -1 then convert to 0
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] == 0) {
          rowReplace(i);
          columnReplace(j);
        }
      }
    }

    replaceAllNegtvWithZero(arr);
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

  public static void displayArr(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}