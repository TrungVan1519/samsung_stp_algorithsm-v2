package stp.strings.thisamsunglan1;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static char[] p, s;

	static int resLen;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\strings\\thisamsunglan1")));
			Scanner sc = new Scanner(System.in);

			T = sc.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				// input
				String strP = sc.next();
				p = new char[strP.length()];
				for (int i = 0; i < p.length; i++) {
					p[i] = strP.charAt(i);
				}

				String strS = sc.next();
				s = new char[strS.length()];
				for (int i = 0; i < s.length; i++) {
					s[i] = strS.charAt(i);
				}

				// solve
				resLen = -1;
				for (int i = 0; i < p.length - 1; i++) {
					if (p[i] == '.') {
						if (p[i + 1] == '*') {
							splitArr(i);
						} else {
							for (int j = 0; j < s.length; j++) {
								if (condition) {
									
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void splitArr(int i) {
		char[] first = new char[i];
		char[] second = new char[p.length - 1 - i + 2];

		for (int j = 0; j < i; j++) {
			first[j] = p[j];
		}

		for (int j = i + 2; j < p.length; j++) {
			second[j] = p[j];
		}

		if (first.length != 0) {
		}

		if (second.length != 0) {
			for (int j = s.length - 1; j >= 0; j--) {
				if (s[j] == second[second.length - 1]) {
					boolean check = true;
					for (int j2 = 0; j2 < second.length; j2++) {
						if (s[j - j2] != second[second.length - j2]) {
							check = false;
							break;
						}
					}

					if (check && resLen < j + second.length) {
						resLen = j + second.length;
					}
				}
			}
		}
	}
}
