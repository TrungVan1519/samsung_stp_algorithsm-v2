package stp.arrays.matran8huong_mario;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int row;
	static char[][] arr;
	static char[] mario;
	static int txMario, tyMario, dirMario;

	static int resCount;
	static boolean resCheck;

	static int[] dx = { -1, -1, -1 };
	static int[] dy = { -1, 0, 1 };

	static enum Dir {
		UP_LEFT, UP, UP_RIGHT
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\matran8huong_mario")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				// input
				row = s.nextInt();
				arr = new char[row][5];
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < 5; j++) {
						arr[i][j] = s.next().charAt(0);
					}
				}

				String str = s.next();
				mario = new char[str.length()];
				for (int i = 0; i < str.length(); i++) {
					mario[i] = str.charAt(i);
				}

				// solve
				resCheck = true;
				resCount = 0;
				txMario = row;
				tyMario = 2;
				dirMario = Dir.UP.ordinal();
				for (int i = 0; i < mario.length; i++) {
					if (mario[i] == 'C') {
						dirMario = Dir.UP.ordinal();
					} else if (mario[i] == 'L') {
						dirMario = Dir.UP_LEFT.ordinal();
					} else if (mario[i] == 'R') {
						dirMario = Dir.UP_RIGHT.ordinal();
					}

					txMario += dx[dirMario];
					tyMario += dy[dirMario];
					
					if (txMario < 0 || tyMario < 0) {
						break;
					}

					if (arr[txMario][tyMario] == '2') {
						resCheck = false;
						break;
					}

					if (arr[txMario][tyMario] == '1') {
						resCount++;
					}
				}

				if (resCheck) {
					System.out.println("#" + tc + " YES" + " " + resCount);
				} else {
					System.out.println("#" + tc + " NO");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
