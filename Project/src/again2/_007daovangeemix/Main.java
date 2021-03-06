package again2._007daovangeemix;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int row, col;
	static char[][] arr;

	static int rs, rsRowGolds, rsColGolds;

	public static void main(String[] args) throws Exception {
		System.setIn(
				new FileInputStream(MyUtils.getAbsolutePath("/Project/src/again2/_007daovangeemix/input.txt", "mac")));
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
			rsRowGolds = 0;
			rsColGolds = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (arr[i][j] == '0') {
						if (checkRow(i)) {
							rsRowGolds++;
						}

						if (checkCol(j)) {
							rsColGolds++;
						}
					}
				}
			}

			int cntRows = rsColGolds / row;
			int cntCols = rsRowGolds / col;
			rs = rsRowGolds + rsColGolds - cntRows * cntCols;
			System.out.printf("#%d %d\n", tc, rs);
		}
	}

	private static boolean checkRow(int i) {
		for (int j = 0; j < col; j++) {
			if (arr[i][j] != '0') {
				return false;
			}
		}
		return true;
	}

	private static boolean checkCol(int j) {
		for (int i = 0; i < row; i++) {
			if (arr[i][j] != '0') {
				return false;
			}
		}
		return true;
	}
}
