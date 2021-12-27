package again2._011pacman;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int size, length;
	static int[][] arr;

	static String pacman, ghost;
	static int tiPacman, tjPacman, dirPacman, tiGhost, tjGhost, dirGhost, goldPacman, goldGhost;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static enum Dir {
		left, up, right, down
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(MyUtils.getAbsolutePath("/Project/src/again2/_011pacman/input.txt", "mac")));
		Scanner s = new Scanner(System.in);

		T = s.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			size = s.nextInt();
			length = s.nextInt();

			arr = new int[size][size];

			// input
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					arr[i][j] = s.nextInt();
				}
			}

			String pacman = s.next();
			String ghost = s.next();

			// solve
			tiPacman = 0;
			tjPacman = 0;
			dirPacman = Dir.down.ordinal();

			tiGhost = size - 1;
			tjGhost = size - 1;
			dirGhost = Dir.up.ordinal();

			goldPacman = 0;
			goldGhost = 0;
			for (int i = 0; i < pacman.length(); i++) {
				// pacman
				if (pacman.charAt(i) == 'R') {
					dirPacman = turnRight(dirPacman);
				} else if (pacman.charAt(i) == 'L') {
					dirPacman = turnLeft(dirPacman);
				}

				tiPacman += dx[dirPacman];
				tjPacman += dy[dirPacman];

				if (tiPacman < 0 || tiPacman >= size || tjPacman < 0 || tjPacman >= size) {
					break;
				}

				// ghost
				if (ghost.charAt(i) == 'R') {
					dirGhost = turnRight(dirGhost);
				} else if (ghost.charAt(i) == 'L') {
					dirGhost = turnLeft(dirGhost);
				}

				tiGhost += dx[dirGhost];
				tjGhost += dy[dirGhost];

				if (tiGhost < 0 || tiGhost >= size || tjGhost < 0 || tjGhost >= size) {
					break;
				}

				// handle collision
				if (tiPacman == tiGhost && tjPacman == tjGhost) {
					break;
				} else {
					goldPacman += arr[tiPacman][tjPacman];
					arr[tiPacman][tjPacman] = 0;
					goldGhost += arr[tiGhost][tjGhost];
					arr[tiGhost][tjGhost] = 0;
				}
			}

			System.out.printf("#%d %d %d\n", tc, goldPacman, goldGhost);
		}
	}

	private static int turnRight(int oldDir) {
		return (oldDir + 1) % 4;
	}

	private static int turnLeft(int oldDir) {
		return (oldDir + 3) % 4;
	}
}
