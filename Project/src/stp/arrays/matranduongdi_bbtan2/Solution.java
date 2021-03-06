package stp.arrays.matranduongdi_bbtan2;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int size;
	static char[][] arr;

	static int resX, resY, resScore;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static enum Dir {
		LEFT, UP, RIGHT, DOWN
	}

	/**
	 * Chú ý:
	 * >>> Không cần phải tạo dirBall trước, mỗi phần từ ở cạnh ma trận đều tự động hướng vào tâm ma trận rồi nên ta sẽ tự động có hướng
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\matranduongdi_bbtan2")));
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
				resScore = 0;
				
				// first col
				for (int i = 0; i < size; i++) {
					if (resScore < move(i, 0, Dir.RIGHT.ordinal())) {
						resScore = move(i, 0, Dir.RIGHT.ordinal());
						resX = i;
						resY = 0;
					}
				}

				// last row
				for (int j = 0; j < size; j++) {
					if (resScore < move(size - 1, j, Dir.UP.ordinal())) {
						resScore = move(size - 1, j, Dir.UP.ordinal());
						resX = size - 1;
						resY = j;
					}
				}

				// last col
				for (int i = size - 1; i >= 0; i--) {
					if (resScore < move(i, size - 1, Dir.LEFT.ordinal())) {
						resScore = move(i, size - 1, Dir.LEFT.ordinal());
						resX = i;
						resY = size - 1;
					}
				}

				// first row
				for (int j = size - 1; j >= 0; j--) {
					if (resScore < move(0, j, Dir.DOWN.ordinal())) {
						resScore = move(0, j, Dir.DOWN.ordinal());
						resX = 0;
						resY = j;
					}
				}

				System.out.println("#" + tc + " " + resX + " " + resY + " " + resScore);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int move(int txBall, int tyBall, int dirBall) {
		int count = 0;
		
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
					count++;
				} else if (arr[txBall][tyBall] == '/') {
					if (dirBall == Dir.RIGHT.ordinal() || dirBall == Dir.LEFT.ordinal()) {
						dirBall = turnLeft(dirBall);
					} else if (dirBall == Dir.UP.ordinal() || dirBall == Dir.DOWN.ordinal()) {
						dirBall = turnRight(dirBall);
					}
					count++;
				}

				txBall += dx[dirBall];
				tyBall += dy[dirBall];
			}
		}
		return count;
	}

	static int turnLeft(int x) {
		return (x + 3) % 4;
	}

	static int turnRight(int x) {
		return (x + 1) % 4;
	}

	static int turnBack(int x) {
		return (x + 2) % 4;
	}
}
