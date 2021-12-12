package stp.arrays.matran4huong_hethongvienthong;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int row, col;
	static char[][] arr;

	static int resSum;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	/**
	 * Cách giải:
	 * >>> Lập ma trận đường đi 4 hướng
	 * >>> Lặp ma trận, nếu gặp arr[i][j] == 'A' || 'B' || 'C' thì lặp range tương ứng
	 * >>> Nếu phần tử == 'H' thì chuyển về 'X'
	 * >>> Lặp ma trận lại 1 lần nữa và đếm 'H'
	 * 
	 * Chú ý:
	 * >>> range trong vòng lặp phải bắt đầu từ 1, không được bắt đầu từ 0
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\matran4huong_hethongvienthong")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				row = s.nextInt();
				col = s.nextInt();
				arr = new char[row][col];

				// input
				for (int i = 0; i < row; i++) {
					String str = s.next();
					for (int j = 0; j < col; j++) {
						arr[i][j] = str.charAt(j);
					}
				}

				// solve
				resSum = 0;
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (arr[i][j] == 'A') {
							for (int range = 1; range <= 1; range++) {
								check(i, j, range);
							}
						} else if (arr[i][j] == 'B') {
							for (int range = 1; range <= 2; range++) {
								check(i, j, range);
							}
						} else if (arr[i][j] == 'C') {
							for (int range = 1; range <= 3; range++) {
								check(i, j, range);
							}
						}
					}
				}

				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (arr[i][j] == 'H') {
							resSum++;
						}
					}
				}

				System.out.println("#" + tc + " " + resSum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void check(int x, int y, int range) {
		int tx, ty;

		for (int i = 0; i < dx.length; i++) {
			tx = x + dx[i] * range;
			ty = y + dy[i] * range;

			if (tx < 0 || tx >= row || ty < 0 || ty >= col) {
				continue;
			}

			if (arr[tx][ty] == 'H') {
				arr[tx][ty] = 'X';
			}
		}
	}
}
