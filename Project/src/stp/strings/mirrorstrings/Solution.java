package stp.strings.mirrorstrings;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static String str;
	static int resLen, resCount;
	static String resStr;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\strings\\mirrorstrings")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				// input
				str = s.next();

				// solve
				resLen = -1;
				resCount = 0;
				resStr = "";
				for (int i = 0; i < str.length(); i++) {
					for (int j = str.length() - 1; j >= i; j--) {
						if (str.charAt(i) != str.charAt(j)) {
							continue;
						}

						String tmp = str.substring(i, j + 1);
						if (isSymmetric(tmp) && resLen < tmp.length()) {
							resLen = tmp.length();
							resStr = tmp;
						}
					}
				}

				if (resLen == 1) {
					resCount = str.length();
				} else {
					for (int i = 0; i < str.length(); i++) {
						if (str.substring(i).indexOf(resStr) != -1) {
							resCount++;
						}
					}
				}

				System.out.println(resLen + " " + resCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
