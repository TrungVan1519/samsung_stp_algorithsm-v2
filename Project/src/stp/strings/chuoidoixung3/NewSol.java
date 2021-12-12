package stp.strings.chuoidoixung3;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class NewSol {

	static int T;

	static int size;
	static char[][] arr;

	static int resLen;
	static String resStr;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\strings\\chuoidoixung3")));
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
					check(arr[i]);
				}

				// check cols
				for (int j = 0; j < size; j++) {
					char[] cs = new char[size];
					for (int i = 0; i < size; i++) {
						cs[i] = arr[i][j];
					}
					check(cs);
				}

				System.out.println("#" + tc + " " + resLen + " " + resStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void check(char[] cs) {
		for (int i = 0; i < cs.length; i++) {
			for (int j = cs.length - 1; j > i; j--) {
				if (cs[i] == cs[j]) {
					int len = j - i + 1;

					if (isSymmetric(cs, i, len) && resLen < len) {
						resLen = len;
						resStr = "";
						for (int k = i; k < len; k++) {
							resStr += cs[k];
						}
					}
				}
			}
		}
	}
	
	private static boolean isSymmetric(char[] cs, int i, int len) {
		for (int k = i; k < len / 2; k++) {
			if (cs[k] != cs[len - 1 - k]) {
				return false;
			}
		}
		return true;
	}
}
