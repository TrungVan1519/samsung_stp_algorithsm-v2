package stp.arrays.matran4huong_hotelfloors;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int row, col;
	static char[][] arr;

	static float resPeople, resRoom;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\matran4huong_hotelfloors")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				row = s.nextInt();
				col = s.nextInt();
				arr = new char[row][col];

				// input
				for (int i = 0; i < row; i++) {
					String str = s.next();
					for (int j = 0; j < col; j++) {
						arr[i][j] = str.charAt(j);
					}
				}

				// solve
				resPeople = 0;
				resRoom = 0;
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (arr[i][j] == '*') {
							resPeople++;
						}
					}
				}

				for (int i = 1; i < row - 1; i++) {
					for (int j = 1; j < col - 1; j++) {
						if (arr[i][j] != '#') {
							resRoom++;
							arr[i][j] = '#';
							fillRoom(i, j);
						}
					}
				}

				System.out.println(new DecimalFormat("0.00").format(resPeople / resRoom));
//				System.out.printf("%.2f", resPeople / resRoom);
//				System.out.println(String.format("%.2f", resPeople/resRoom));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void fillRoom(int i, int j) {
		if (arr[i][j - 1] != '#') {
			arr[i][j - 1] = '#';
			fillRoom(i, j - 1);
		}

		if (arr[i - 1][j] != '#') {
			arr[i - 1][j] = '#';
			fillRoom(i - 1, j);
		}

		if (arr[i][j + 1] != '#') {
			arr[i][j + 1] = '#';
			fillRoom(i, j + 1);
		}

		if (arr[i + 1][j] != '#') {
			arr[i + 1][j] = '#';
			fillRoom(i + 1, j);
		}
	}
}
