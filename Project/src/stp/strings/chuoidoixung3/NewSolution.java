package stp.strings.chuoidoixung3;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class NewSolution {

	static int T;

	static int size;
	static char[][] arr;

	static int resLen;
	static String resStr;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(
					MyUtils.getAbsolutePath("Project/src/stp/strings/chuoidoixung3/input.txt", "mac")));
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
					for (int j = 0; j < size; j++) {
						for (int j2 = size - 1; j2 > j; j2--) {
							if (arr[i][j] == arr[i][j2]) {
								int len = j2 + 1 - j;

								if (checkRow(i, j, j2) && resLen < len) {
									resStr = "";
									resLen = len;

									if (resLen > -1) {
										for (int k = j; k <= j2; k++) {
											resStr += arr[i][k];
										}
									}
								}
							}
						}
					}
				}

				// check cols
				for (int j = 0; j < size; j++) {
					for (int i = 0; i < size; i++) {
						for (int i2 = size - 1; i2 > i; i2--) {
							if (arr[i][j] == arr[i2][j]) {
								int len = i2 + 1 - i;

								if (checkCol(j, i, i2) && resLen < len) {
									resStr = "";
									resLen = len;

									if (resLen > -1) {
										for (int k = i; k <= i2; k++) {
											resStr += arr[k][j];
										}
									}
								}
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

	private static boolean checkRow(int i, int start, int finish) {
		int len = finish + 1 - start;
		for (int k = 0; k < len / 2; k++) {
			if (arr[i][start + k] != arr[i][finish - k]) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkCol(int j, int start, int finish) {
		int len = finish + 1 - start;
		for (int k = 0; k < len / 2; k++) {
			if (arr[start + k][j] != arr[finish - k][j]) {
				return false;
			}
		}
		return true;
	}
}
