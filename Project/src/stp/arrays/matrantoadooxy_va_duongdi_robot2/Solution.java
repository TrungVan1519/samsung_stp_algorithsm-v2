package stp.arrays.matrantoadooxy_va_duongdi_robot2;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int desX, desY;

	static int length;
	static char[] robotA, robotB;

	static int txRobotA, tyRobotA, dirRobotA;
	static int txRobotB, tyRobotB, dirRobotB;
	static boolean robotAFinished, robotBFinished;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static enum Dir {
		LEFT, UP, RIGHT, DOWN
	};

	/**
	 * Chú ý:
	 * >>> Bài này vẫn dùng ma trận tọa độ Oxy thay cho ma trận đường đi
	 * >>> Khác với bài pacman, bài này thì 2 robot phải lặp 2 for khác nhau và chỉ dừng khi hết String di chuyển hoặc về đích vì 2 robot là độc lập với nhau, 
	 * 			còn pacman vs ghost bị ràng buộc kết thúc khi chúng đâm đầu vào nhau
	 * >>> Cẩn thận nhầm biến dx, dy với robotA và robotB vì code hơi dài nên dễ bị nhầm tên biến
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\matrantoadooxy_va_duongdi_robot2")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				desX = s.nextInt();
				desY = s.nextInt();
				length = s.nextInt();
				robotA = new char[length];
				robotB = new char[length];

				// input
				String strRobotA = s.next();
				for (int i = 0; i < length; i++) {
					robotA[i] = strRobotA.charAt(i);
				}

				String strRobotB = s.next();
				for (int i = 0; i < length; i++) {
					robotB[i] = strRobotB.charAt(i);
				}

				// solve
				txRobotA = 0;
				tyRobotA = 0;
				dirRobotA = Dir.UP.ordinal();
				robotAFinished = false;
				for (int i = 0; i < length; i++) {
					if (txRobotA == desX && tyRobotA == desY) {
						robotAFinished = true;
						break;
					}

					if (robotA[i] == 'C') {
						txRobotA += dx[dirRobotA];
						tyRobotA += dy[dirRobotA];
					} else if (robotA[i] == 'L') {
						dirRobotA = turnLeft(dirRobotA);
						txRobotA += dx[dirRobotA];
						tyRobotA += dy[dirRobotA];
					} else if (robotA[i] == 'R') {
						dirRobotA = turnRight(dirRobotA);
						txRobotA += dx[dirRobotA];
						tyRobotA += dy[dirRobotA];
					} else if (robotA[i] == 'B') {
						dirRobotA = turnBack(dirRobotA);
						txRobotA += dx[dirRobotA];
						tyRobotA += dy[dirRobotA];
					} else if (robotA[i] == 'W') {
						dirRobotA = Dir.LEFT.ordinal();
						txRobotA--;
					} else if (robotA[i] == 'N') {
						dirRobotA = Dir.UP.ordinal();
						tyRobotA++;
					} else if (robotA[i] == 'E') {
						dirRobotA = Dir.RIGHT.ordinal();
						txRobotA++;
					} else if (robotA[i] == 'S') {
						dirRobotA = Dir.DOWN.ordinal();
						tyRobotA--;
					}
				}

				txRobotB = 0;
				tyRobotB = 0;
				dirRobotB = Dir.UP.ordinal();
				robotBFinished = false;
				for (int i = 0; i < length; i++) {
					if (txRobotB == desX && tyRobotB == desY) {
						robotBFinished = true;
						break;
					}

					if (robotB[i] == 'C') {
						txRobotB += dx[dirRobotB];
						tyRobotB += dy[dirRobotB];
					} else if (robotB[i] == 'L') {
						dirRobotB = turnLeft(dirRobotB);
						txRobotB += dx[dirRobotB];
						tyRobotB += dy[dirRobotB];
					} else if (robotB[i] == 'R') {
						dirRobotB = turnRight(dirRobotB);
						txRobotB += dx[dirRobotB];
						tyRobotB += dy[dirRobotB];
					} else if (robotB[i] == 'B') {
						dirRobotB = turnBack(dirRobotB);
						txRobotB += dx[dirRobotB];
						tyRobotB += dy[dirRobotB];
					} else if (robotB[i] == 'W') {
						dirRobotB = Dir.LEFT.ordinal();
						txRobotB--;
					} else if (robotB[i] == 'N') {
						dirRobotB = Dir.UP.ordinal();
						tyRobotB++;
					} else if (robotB[i] == 'E') {
						dirRobotB = Dir.RIGHT.ordinal();
						txRobotB++;
					} else if (robotB[i] == 'S') {
						dirRobotB = Dir.DOWN.ordinal();
						tyRobotB--;
					}
				}

				if (robotAFinished && robotBFinished) {
					System.out.println("#" + tc + " Good game!");
				} else if (robotAFinished && !robotBFinished) {
					System.out.println("#" + tc + " Team A win");
				} else if (!robotAFinished && robotBFinished) {
					System.out.println("#" + tc + " Team B win");
				} else {
					// case 1:
					String result = "#" + tc + " " + calculateDistance(txRobotA, tyRobotA, desX, desY) + " "
							+ calculateDistance(txRobotB, tyRobotB, desX, desY);
					System.out.println(result);
//					// case 2:
//					System.out.printf("%.2f", Math.sqrt((desX - txRobotA) * (desX - txRobotA) + (desY - tyRobotA) * (desY - tyRobotA)));
//					// case 3:
//					System.out.println(String.format("%.2f", Math.sqrt((desX - txRobotA) * (desX - txRobotA) + (desY - tyRobotA) * (desY - tyRobotA))));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String calculateDistance(int x1, int y1, int x2, int y2) {
		return new DecimalFormat("0.000").format(Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)));
	}

	private static int turnLeft(int oldDir) {
		return (oldDir + 3) % 4;
	}

	private static int turnRight(int oldDir) {
		return (oldDir + 1) % 4;
	}

	private static int turnBack(int oldDir) {
		return (oldDir + 2) % 4;
	}
}
