package again2._005hethongphantichremcua;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int row, col;
	static char[][] arr;

	static int[] types;

	static String rs;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(
				MyUtils.getAbsolutePath("/Project/src/again2/_005hethongphantichremcua/input.txt", "mac")));
		Scanner s = new Scanner(System.in);

		T = s.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			row = 5 * s.nextInt() + 1;
			col = 5 * s.nextInt() + 1;
			arr = new char[row][col];
			types = new int[5];

			// input
			for (int i = 0; i < row; i++) {
				String str = s.next();
				for (int j = 0; j < col; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// solve
			for (int i = 1; i < row; i += 5) {
				for (int j = 1; j < col; j += 5) {
					int cnt = 0;
					for (int k = i; k < i + 5; k++) {
						if (arr[k][j] == '*') {
							cnt++;
						}
					}
					types[cnt]++;
				}
			}

			rs = "#" + tc;
			for (int i = 0; i < types.length; i++) {
				rs += " " + types[i];
			}

			System.out.println(rs);
		}
	}
}
