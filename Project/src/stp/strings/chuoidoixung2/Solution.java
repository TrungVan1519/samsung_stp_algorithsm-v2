package stp.strings.chuoidoixung2;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static String str;
	
	static int resLen;
	static String resStr;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\strings\\chuoidoixung2")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				// input
				str = s.next();

				// solve
				resLen = -1;
				resStr = "";
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

				System.out.println("#" + tc + " " + resLen + " " + resStr);
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
