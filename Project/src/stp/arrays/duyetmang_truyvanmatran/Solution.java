package stp.arrays.duyetmang_truyvanmatran;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int row, col;
	static int[][] arr;

	static int K;
	static int[][] change;

	static int resCount;
	static String resStr;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\duyetmang_truyvanmatran")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				row = s.nextInt();
				col = s.nextInt();
				K = s.nextInt();

				arr = new int[row][col];
				change = new int[K][2];

				// input
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						arr[i][j] = s.nextInt();
					}
				}

				for (int i = 0; i < K; i++) {
					change[i][0] = s.nextInt();
					change[i][1] = s.nextInt();
				}

				// solve
				resCount = 0;
				resStr = "#" + tc;
				for (int i = 0; i < K; i++) {
					int[] tmpArr = new int[col];

					// DOWN
					if (change[i][0] == 1) {
						for (int j = 0; j < change[i][1]; j++) {
							// copy last row
							for (int k = 0; k < col; k++) {
								tmpArr[k] = arr[row - 1][k];
							}

							// change
							for (int k = row - 1; k >= 0; k--) {
								for (int k2 = 0; k2 < col; k2++) {
									if (k == 0) {
										arr[0][k2] = tmpArr[k2];
									} else {
										arr[k][k2] = arr[k - 1][k2];
									}
								}
							}

							getSum4or8();
						}
						resStr += " " + resCount;
					}

					// UP
					if (change[i][0] == 3) {
						for (int j = 0; j < change[i][1]; j++) {
							// copy first row
							for (int k = 0; k < col; k++) {
								tmpArr[k] = arr[0][k];
							}

							// change
							for (int k = 0; k < row; k++) {
								for (int k2 = 0; k2 < col; k2++) {
									if (k == row - 1) {
										arr[row - 1][k2] = tmpArr[k2];
									} else {
										arr[k][k2] = arr[k + 1][k2];
									}
								}
							}

							getSum4or8();
						}
						resStr += " " + resCount;
					}

					// RIGHT
					if (change[i][0] == 2) {
						for (int j = 0; j < change[i][1]; j++) {
							// copy last col
							for (int k = 0; k < row; k++) {
								tmpArr[k] = arr[k][col - 1];
							}

							// change
							for (int k = col - 1; k >= 0; k--) {
								for (int k2 = 0; k2 < row; k2++) {
									if (k == 0) {
										arr[k2][0] = tmpArr[k2];
									} else {
										arr[k2][k] = arr[k2][k - 1];
									}
								}
							}
							getSum4or8();
						}
						resStr += " " + resCount;
					}

					// LEFT
					if (change[i][0] == 4) {
						for (int j = 0; j < change[i][1]; j++) {
							// copy first col
							for (int k = 0; k < row; k++) {
								tmpArr[k] = arr[k][0];
							}

							// change
							for (int k = 0; k < col; k++) {
								for (int k2 = 0; k2 < row; k2++) {
									if (k == col - 1) {
										arr[k2][col - 1] = tmpArr[k2];
									} else {
										arr[k2][k] = arr[k2][k + 1];
									}
								}
							}

							getSum4or8();
						}
						resStr += " " + resCount;
					}
				}

				System.out.println(resStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void getSum4or8() {
		resCount = 0;
		for (int k = 0; k < row - 1; k++) {
			for (int k2 = 0; k2 < col - 1; k2++) {
				int sum = arr[k][k2] + arr[k + 1][k2 + 1] + arr[k + 1][k2] + arr[k][k2 + 1];
				if (sum == 4 || sum == 8) {
					resCount++;
				}
			}
		}
	}
}
