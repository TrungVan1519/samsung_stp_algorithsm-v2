package stp.arrays.duyetmang_prob24;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int size;
	static char[][] arr;

	static int resCount;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(
					MyUtils.getAbsolutePath("Project/src/stp/arrays/duyetmang_prob24/input.txt", "mac")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				size = s.nextInt();
				arr = new char[size][size];

				// input
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						arr[i][j] = s.next().charAt(0);
					}
				}

				// solve
				resCount = 0;
				for (int j = 0; j < size; j++) {
					for (int i = 0; i < size; i++) {
						if (arr[i][j] == '1') {
							for (int k = i + 1; k < size; k++) {
								if (arr[k][j] == '2') {
									resCount++;
									break;
								} else if (arr[k][j] == '1') {
									break;
								}
							}
						}
					}
				}

				System.out.println("#" + tc + " " + resCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
