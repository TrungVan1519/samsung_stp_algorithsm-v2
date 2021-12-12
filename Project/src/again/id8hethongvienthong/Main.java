package again.id8hethongvienthong;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int row, col;
	static char[][] arr;

	static int resCount;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("again\\id8hethongvienthong")));
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

				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (arr[i][j] == 'A') {
							for (int range = 1; range < 2; range++) {
								check(i, j, range);
							}
						} else if (arr[i][j] == 'B') {
							for (int range = 1; range < 3; range++) {
								check(i, j, range);
							}
						} else if (arr[i][j] == 'C') {
							for (int range = 1; range < 4; range++) {
								check(i, j, range);
							}
						}
					}
				}

				resCount = 0;
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (arr[i][j] == 'H') {
							resCount++;
						}
					}
				}

				System.out.println("#" + tc + " " + resCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void check(int i, int j, int range) {
		int ti, tj;

		for (int k = 0; k < dx.length; k++) {
			ti = i + dx[k] * range;
			tj = j + dy[k] * range;

			if (ti < 0 || ti >= row || tj < 0 || tj >= col) {
				continue;
			}

			if (arr[ti][tj] == 'H') {
				arr[ti][tj] = 'X';
			}
		}
	}
}
