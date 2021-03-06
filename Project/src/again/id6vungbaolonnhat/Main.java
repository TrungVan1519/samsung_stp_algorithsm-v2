package again.id6vungbaolonnhat;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int height, width, row, col;
	static int[][] arr;

	static int resSum;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("again\\id6vungbaolonnhat")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				height = s.nextInt();
				width = s.nextInt();
				row = s.nextInt();
				col = s.nextInt();

				arr = new int[row][col];

				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						arr[i][j] = s.nextInt();
					}
				}

				resSum = 0;
				for (int i = 0; i <= row - height; i++) {
					for (int j = 0; j <= col - width; j++) {
						if (getSum(i, j) > resSum) {
							resSum = getSum(i, j);
						}
					}
				}

				System.out.println("#" + tc + " " + resSum);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static int getSum(int i, int j) {
		int sum = 0;
		for (int k = i; k < i + height; k++) {
			for (int k2 = j; k2 < j + width; k2++) {
				if (arr[k][k2] % 2 == 0) {
					sum += arr[k][k2];
				}
			}
		}
		return sum;
	}
}
