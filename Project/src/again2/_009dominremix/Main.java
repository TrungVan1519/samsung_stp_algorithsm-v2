package again2._009dominremix;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int row, col;
	static char[][] arr;

	static int rs;

	// 0-1 -1-1 -10 -11 01 11 10 1-1
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(MyUtils.getAbsolutePath("/Project/src/again2/_009dominremix/input.txt", "mac")));
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
			rs = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (arr[i][j] == '*') {
						rs += count(i, j);
					}
				}
			}
			
			System.out.printf("Case #%d: %d\n", tc, rs);
		}

	}

	private static int count(int i, int j) {
		int cnt = 0;
		int ti, tj;

		for (int k = 0; k < dx.length; k++) {
			ti = i + dx[k];
			tj = j + dy[k];

			if (ti < 0 || ti >= row || tj < 0 || tj >= col) {
				continue;
			}

			if (arr[ti][tj] == '.') {
				cnt++;
			}
		}

		return cnt;
	}
}
