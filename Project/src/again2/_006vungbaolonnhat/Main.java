package again2._006vungbaolonnhat;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int height, width, row, col;
	static int[][] arr;

	static int tmpSum, rs;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(
				MyUtils.getAbsolutePath("/Project/src/again2/_006vungbaolonnhat/input.txt", "mac")));
		Scanner s = new Scanner(System.in);

		T = s.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			height = s.nextInt();
			width = s.nextInt();
			row = s.nextInt();
			col = s.nextInt();
			arr = new int[row][col];

			// input
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					arr[i][j] = s.nextInt();
				}
			}

			// solve
			tmpSum = 0;
			rs = 0;
			for (int i = 0; i <= row - height; i++) {
				for (int j = 0; j <= col - width; j++) {
					tmpSum = getSum(i, j);
					
					if (rs < tmpSum) {
						rs = tmpSum;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, rs);
		}
	}

	private static int getSum(int i, int j) {
		int sum = 0;

		for (int k = i; k < height + i; k++) {
			for (int k2 = j; k2 < width + j; k2++) {
				if (arr[k][k2] % 2 == 0) {
					sum += arr[k][k2];
				}
			}
		}

		return sum;
	}
}
