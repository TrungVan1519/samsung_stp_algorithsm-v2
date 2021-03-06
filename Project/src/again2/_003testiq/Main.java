package again2._003testiq;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int size = 4;
	static char[][] arr;

	static int rs;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(MyUtils.getAbsolutePath("/Project/src/again2/_003testiq/input.txt", "mac")));
		Scanner s = new Scanner(System.in);

		T = s.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			arr = new char[size][size];

			// input
			for (int i = 0; i < size; i++) {
				String str = s.next();
				for (int j = 0; j < size; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// solve
			rs = 0;
			for (int i = 0; i < size - 1; i++) {
				for (int j = 0; j < size - 1; j++) {
					if (arr[i][j] + arr[i + 1][j + 1] + arr[i + 1][j] + arr[i][j + 1] != 2 * ('#' + '.')) {
						rs++;
					}
				}
			}

			if (rs > 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
