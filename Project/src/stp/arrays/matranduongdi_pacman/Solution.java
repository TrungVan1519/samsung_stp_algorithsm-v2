package stp.arrays.matranduongdi_pacman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int size, length;
	static int[][] arr;
	static char[] pacman, ghost;

	static int txPacman, tyPacman, dirPacman;
	static long goldPacman;
	static int txGhost, tyGhost, dirGhost;
	static long goldGhost;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static enum Dir {
		LEFT, UP, RIGHT, DOWN
	}

	/**
	 * Chú ý:
	 * >>> Phải cho pacman và ghost vào cùng 1 vòng lặp thì mới check được pacman và ghost có va chạm nhau hay không
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\matranduongdi_pacman")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				size = s.nextInt();
				length = s.nextInt();

				arr = new int[size][size];
				pacman = new char[length];
				ghost = new char[length];

				// input
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						arr[i][j] = s.nextInt();
					}
				}

				String strPacman = s.next();
				for (int i = 0; i < length; i++) {
					pacman[i] = strPacman.charAt(i);
				}

				String strGhost = s.next();
				for (int i = 0; i < length; i++) {
					ghost[i] = strGhost.charAt(i);
				}

				// solve
				txPacman = 0;
				tyPacman = 0;
				dirPacman = Dir.DOWN.ordinal();
				goldPacman = 0;

				txGhost = size - 1;
				tyGhost = size - 1;
				dirGhost = Dir.UP.ordinal();
				goldGhost = 0;
				for (int i = 0; i < length; i++) {
					if (pacman[i] == 'L') {
						dirPacman = turnLeft(dirPacman);
					} else if (pacman[i] == 'R') {
						dirPacman = turnRight(dirPacman);
					}

					txPacman += dx[dirPacman];
					tyPacman += dy[dirPacman];

					if (ghost[i] == 'L') {
						dirGhost = turnLeft(dirGhost);
					} else if (ghost[i] == 'R') {
						dirGhost = turnRight(dirGhost);
					}

					txGhost += dx[dirGhost];
					tyGhost += dy[dirGhost];

					if (txPacman == txGhost && tyPacman == tyGhost) {
						break;
					} else {
						goldPacman += arr[txPacman][tyPacman];
						arr[txPacman][tyPacman] = 0;
						goldGhost += arr[txGhost][tyGhost];
						arr[txGhost][tyGhost] = 0;
					}
				}

				System.out.println("#" + tc + " " + goldPacman + " " + goldGhost);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int turnLeft(int oldDir) {
		return (oldDir + 3) % 4;
	}

	private static int turnRight(int oldDir) {
		return (oldDir + 1) % 4;
	}
}
