package stp.arrays.duyetmang_vungbaolonnhat;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int height, width, row, col;
	static int[][] arr;

	static int resSum;

	/**
	 * Cách giải:
	 * >>> Lặp lần lượt các phần tử trong ma trận con có kích thước height x width
	 * >>> Tính tổng các phần tử chắng ở rìa ma trân con
	 * 			(i == x || i == x + height - 1 || j == y || j == y + width - 1) && arr[i][j] % 2 == 0
	 * 
	 * Chú ý:
	 * >>> Chỉ check từ hàng i = 0 -> i = row-height và từ cột i = 0 -> i = col-width, chú ý phải == row-height và == col-width
	 * >>> Khi lặp mảng con thì sẽ lặp từ i = 0 -> i < x+height và j = 0 -> j < y+width, chú ý phải < x+height và y+width
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\duyetmang_vungbaolonnhat")));
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
				resSum = 0;
				for (int i = 0; i <= row - height; i++) {
					for (int j = 0; j <= col - width; j++) {
						if (resSum < sum(i, j)) {
							resSum = sum(i, j);
						}
					}
				}

				System.out.println("#" + tc + " " + resSum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int sum(int x, int y) {
		int sum = 0;

		for (int i = x; i < x + height; i++) {
			for (int j = y; j < y + width; j++) {
				if ((i == x || i == x + height - 1 || j == y || j == y + width - 1) && arr[i][j] % 2 == 0) {
					sum += arr[i][j];
				}
			}
		}

		return sum;
	}
}
