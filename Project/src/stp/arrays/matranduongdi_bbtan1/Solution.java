package stp.arrays.matranduongdi_bbtan1;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int size;
	static char[][] arr;

	static int txBall, tyBall, dirBall;
	static int resCount;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static enum Dir {
		LEFT, UP, RIGHT, DOWN
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\matranduongdi_bbtan1")));
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
				txBall = 0;
				tyBall = 0;
				dirBall = Dir.RIGHT.ordinal();
				resCount = 0;
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (txBall < 0 || txBall >= size || tyBall < 0 || tyBall >= size) {
							break;
						}
						
						if (arr[txBall][tyBall] == '\\') {
							if (dirBall == Dir.RIGHT.ordinal() || dirBall == Dir.LEFT.ordinal()) {
								dirBall = turnRight(dirBall);
							} else if (dirBall == Dir.UP.ordinal() || dirBall == Dir.DOWN.ordinal()) {
								dirBall = turnLeft(dirBall);
							}
							resCount++;
						} else if (arr[txBall][tyBall] == '/') {
							if (dirBall == Dir.RIGHT.ordinal() || dirBall == Dir.LEFT.ordinal()) {
								dirBall = turnLeft(dirBall);
							} else if (dirBall == Dir.UP.ordinal() || dirBall == Dir.DOWN.ordinal()) {
								dirBall = turnRight(dirBall);
							}
							resCount++;
						}

						txBall += dx[dirBall];
						tyBall += dy[dirBall];
					}
				}

				System.out.println("#" + tc + " " + resCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static int turnLeft(int oldDir) {
		return (oldDir + 3) % 4;
	}

	static int turnRight(int oldDir) {
		return (oldDir + 1) % 4;
	}
}
