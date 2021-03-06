package stp.strings.chuoidoixung1;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static String str;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(
					MyUtils.getAbsolutePath("Project/src/stp/strings/chuoidoixung1/input.txt", "mac")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				// input
				str = s.next();

				// solve
				if (isSymmetric(str)) {
					System.out.println("#" + tc + " YES");
				} else {
					System.out.println("#" + tc + " NO");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean isSymmetric(String string) {
		for (int i = 0; i < string.length() / 2; i++) {
			if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
