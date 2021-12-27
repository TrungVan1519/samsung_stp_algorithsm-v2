package again2._012robot1;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int size;
	static int[][] pos;

	static int oldDir, newDir;
	static int rs;

	static enum Dir {
		left, up, right, down
	};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(MyUtils.getAbsolutePath("/Project/src/again2/_012robot1/input.txt", "mac")));
		Scanner s = new Scanner(System.in);

		T = s.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			size = s.nextInt();
			pos = new int[size][2];

			// input
			for (int i = 0; i < size; i++) {
				pos[i][0] = s.nextInt();
				pos[i][1] = s.nextInt();
			}

			// solve
			rs = 0;
			for (int i = 0; i < size - 2; i++) {
				oldDir = getDir(pos[i][0], pos[i][1], pos[i + 1][0], pos[i + 1][1]);
				newDir = getDir(pos[i + 1][0], pos[i + 1][1], pos[i + 2][0], pos[i + 2][1]);
				if ((oldDir + 1) % 4 == newDir) {
					rs++;
				}
			}

			System.out.printf("#%d %d", tc, rs);
		}

	}

	private static int getDir(int x1, int y1, int x2, int y2) {
		if (x1 - 1 == x2) {
			return Dir.left.ordinal();
		} else if (y1 + 1 == y2) {
			return Dir.up.ordinal();
		} else if (x1 + 1 == x2) {
			return Dir.right.ordinal();
		}
		return Dir.down.ordinal();
	}
}
