package again2._004sonen1;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int num, rs;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(MyUtils.getAbsolutePath("/Project/src/again2/_004sonen1/input.txt", "mac")));
		Scanner s = new Scanner(System.in);

		T = s.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// input
			num = s.nextInt();

			// solve
			rs = impact(num);
			while (rs > 9) {
				rs = impact(rs);
			}

			System.out.printf("#%d %d\n", tc, rs);
		}
	}

	private static int impact(int n) {
		int impact = 0;

		while (n > 0) {
			impact += n % 10;
			n /= 10;
		}

		return impact;
	}
}
