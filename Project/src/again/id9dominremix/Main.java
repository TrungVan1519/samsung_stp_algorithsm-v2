package again.id9dominremix;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int row, col;
	static char[][] arr;

	static int resCount;

	// 0-1 -1-1 -10 -11 01 11 10 1-1
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("again\\id9dominremix")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				row = s.nextInt();
				col = s.nextInt();

				arr = new char[row][col];

				for (int i = 0; i < row; i++) {
					String str = s.next();
					for (int j = 0; j < col; j++) {
						arr[i][j] = str.charAt(j);
					}
				}

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
			// TODO: handle exception
		}
	}

	private static int check(int i, int j) {
		int ti, tj;
		int count = 0;

		for (int k = 0; k < dx.length; k++) {
			ti = i + dx[k];
			tj = j + dy[k];

			if (ti < 0 || ti >= row || tj < 0 || tj >= col) {
				continue;
			}

			if (arr[ti][tj] == '*') {
				count++;
			}
		}
		return count;
	}
}
