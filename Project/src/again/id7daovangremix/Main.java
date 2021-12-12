package again.id7daovangremix;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int row, col;
	static char[][] arr;

	static int goldRow, goldCol;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("again\\id7daovangremix")));
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

				goldRow = 0;
				goldCol = 0;
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (arr[i][j] == '0') {
							if (checkRow(i)) {
								goldRow++;
							}
							if (checkCol(j)) {
								goldCol++;
							}
						}
					}
				}

				int validRow = goldRow / col;
				int validCol = goldCol / row;
				int resGold = goldRow + goldCol - validRow * validCol;
				System.out.println("#" + tc + " " + resGold);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static boolean checkCol(int j) {
		for (int i = 0; i < row; i++) {
			if (arr[i][j] != '0') {
				return false;
			}
		}
		return true;
	}

	private static boolean checkRow(int i) {
		for (int j = 0; j < col; j++) {
			if (arr[i][j] != '0') {
				return false;
			}
		}

		return true;
	}
}
