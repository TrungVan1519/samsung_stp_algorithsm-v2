package again.id2tuanlecongdan;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int row, col;
	static char[][] arr;

	static int resCount, resI, resJ;

	// 0-1 -1-1 -10 -11 01 11 10 1-1
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("again\\id2tuanlecongdan")));
			Scanner s = new Scanner(System.in);

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
						if (resCount < check(i, j)) {
							resCount = check(i, j);
							resI = i;
							resJ = j;
						}
					}
				}
			}

			arr[resI][resJ] = 'o';

			resCount = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (arr[i][j] == 'o') {
						resCount += check(i, j);
					}
				}
			}

			System.out.println(resCount / 2); // because handshake is duplicated 2 times
		} catch (Exception e) {
			e.printStackTrace();
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

			if (arr[ti][tj] == 'o') {
				count++;
			}
		}

		return count;
	}
}
