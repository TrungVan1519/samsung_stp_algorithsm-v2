package again.id5hethongphantichremcua;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int row, col;
	static char[][] arr;

	static int[] types;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("again\\id5hethongphantichremcua")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				row = 5 * s.nextInt() + 1;
				col = 5 * s.nextInt() + 1;
				arr = new char[row][col];
				types = new int[5];

				for (int i = 0; i < row; i++) {
					String str = s.next();
					for (int j = 0; j < col; j++) {
						arr[i][j] = str.charAt(j);
					}
				}

				for (int i = 1; i < row; i += 5) {
					for (int j = 1; j < col; j += 5) {
						checkTypes(i, j);
					}
				}

				String resStr = "";
				for (int i = 0; i < types.length; i++) {
					resStr += " " + types[i];
				}
				System.out.println("#" + tc + resStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void checkTypes(int i, int j) {
		int index = 0;

		for (int k = i; k < i + 5; k++) {
			if (arr[k][j] == '*') {
				index++;
			}
		}

		types[index]++;
	}
}
