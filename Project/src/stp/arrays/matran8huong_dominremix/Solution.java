package stp.arrays.matran8huong_dominremix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int row, col;
	static char[][] arr;

	static int resCount;

	// 0-1 -1-1 -10 -11 01 11 10 1-1
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\matran8huong_dominremix")));
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
				resCount = 0;
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (arr[i][j] == '.') {
							resCount += check(i, j);
						}
					}
				}

				System.out.println("Case #" + tc + ": " + resCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int check(int x, int y) {
		int tx, ty;
		int count = 0;

		for (int i = 0; i < dx.length; i++) {
			tx = x + dx[i];
			ty = y + dy[i];

			if (tx < 0 || tx >= row || ty < 0 || ty >= col) {
				continue;
			}
			
			if (arr[tx][ty] == '*') {
				count++;
			}
		}
		
		return count;
	}
}
