package again2._008hethongvienthong;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int row, col;
	static char[][] arr;

	static int rs;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(MyUtils.getAbsolutePath("/Project/src/again2/_008hethongvienthong/input.txt", "mac")));
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
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (arr[i][j] == 'A') {
						fill(i, j, 1);
					} else if (arr[i][j] == 'B') {
						fill(i, j, 2);
					} else if (arr[i][j] == 'C') {
						fill(i, j, 3);
					}
				}
			}

			rs = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (arr[i][j] == 'H') {
						rs++;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, rs);
		}
	}

	private static void fill(int i, int j, int range) {
		int ti, tj;

		for (int rng = 1; rng <= range; rng++) {
			for (int k = 0; k < dx.length; k++) {
				ti = i + dx[k] * rng;
				tj = j + dx[k] * rng;

				if (ti < 0 || ti >= row || tj < 0 || tj >= col) {
					continue;
				}

				if (arr[ti][tj] == 'H') {
					arr[ti][tj] = 'X';
				}
			}
		}
	}
}
