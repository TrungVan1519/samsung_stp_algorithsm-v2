package stp.arrays.matrantoadooxy_robot1;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int size;
	static int[][] robot;

	static int resCount;

	static enum Dir {
		LEFT, UP, RIGHT, DOWN
	};

	/**
	 * Chú ý:
	 * >>> Bài này sử dụng ma trận tọa độ Oxy chứ không sử dụng ma trận đường đi
	 * >>> Cho trước các tọa độ thì ta sẽ dùng công thức để tính ra hướng chứ không tạo hướng ban đầu
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\matrantoadooxy_robot1")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				size = s.nextInt();
				robot = new int[size][2];

				// input
				for (int i = 0; i < size; i++) {
					robot[i][0] = s.nextInt();
					robot[i][1] = s.nextInt();
				}

				// solve
				resCount = 0;
				for (int i = 0; i < size - 2; i++) {
					int curDir = checkDir(robot[i][0], robot[i][1], robot[i + 1][0], robot[i + 1][1]);
					int nextDir = checkDir(robot[i + 1][0], robot[i + 1][1], robot[i + 2][0], robot[i + 2][1]);

					if ((curDir + 1) % 4 == nextDir) {
						resCount++;
					}
				}

				System.out.println("#" + tc + " " + resCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static int checkDir(int x1, int y1, int x2, int y2) {
		int dir = Dir.LEFT.ordinal();

		if (x1 == x2 && y1 + 1 == y2) {
			dir = Dir.UP.ordinal();
		} else if (x1 + 1 == x2 && y1 == y2) {
			dir = Dir.RIGHT.ordinal();
		} else if (x1 == x2 && y1 - 1 == y2) {
			dir = Dir.DOWN.ordinal();
		}

		return dir;
	}
}
