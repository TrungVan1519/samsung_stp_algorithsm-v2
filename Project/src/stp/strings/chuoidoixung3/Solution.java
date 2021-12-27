package stp.strings.chuoidoixung3;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int size;
	static char[][] arr;

	static int resLen;
	static String resStr;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("Project/src/stp/strings/chuoidoixung3/input.txt", "mac")));
;
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				size = s.nextInt();
				arr = new char[size][size];

				// input
				for (int i = 0; i < size; i++) {
					String str = s.next();
					for (int j = 0; j < size; j++) {
						arr[i][j] = str.charAt(j);
					}
				}

				// solve
				resLen = -1;
				resStr = "";
				// check rows
				for (int i = 0; i < size; i++) {
					String str = "";
					for (int j = 0; j < size; j++) {
						str += arr[i][j];
					}
					check(str);
				}

				// check cols
				for (int j = 0; j < size; j++) {
					String str = "";
					for (int i = 0; i < size; i++) {
						str += arr[i][j];
					}
					check(str);
				}

				System.out.println("#" + tc + " " + resLen + " " + resStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void check(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = str.length() - 1; j > i; j--) {
				if (str.charAt(i) == str.charAt(j)) {
					String tmp = str.substring(i, j + 1);
					if (isSymmetric(tmp) && resLen < tmp.length()) {
						resLen = tmp.length();
						resStr = tmp;
					}
				}
			}
		}
	}

	private static boolean isSymmetric(String substring) {
		for (int i = 0; i < substring.length() / 2; i++) {
			if (substring.charAt(i) != substring.charAt(substring.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
