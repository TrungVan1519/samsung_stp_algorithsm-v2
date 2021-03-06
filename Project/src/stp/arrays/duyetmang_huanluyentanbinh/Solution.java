package stp.arrays.duyetmang_huanluyentanbinh;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int size;
	static int[] scores, indexs;
	static boolean[] isEstimated;

	static int resScore;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(
					MyUtils.getAbsolutePath("Project/src/stp/arrays/duyetmang_huanluyentanbinh/input.txt", "mac")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				size = s.nextInt();
				scores = new int[size];
				indexs = new int[size];

				// input
				for (int i = 0; i < size; i++) {
					scores[i] = s.nextInt();
				}

				for (int i = 0; i < size; i++) {
					indexs[i] = s.nextInt();
				}

				// solve
				resScore = 0;
				isEstimated = new boolean[size];
				for (int i = 0; i < size; i++) {
					// estimate this target
					isEstimated[indexs[i] - 1] = true;

					if (i == size - 1) {
						resScore += scores[indexs[i] - 1];
					} else {
						resScore += checkBoth(indexs[i] - 1);
					}
				}

				System.out.println("#" + tc + " " + resScore);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int checkBoth(int index) {
		int score = 1;
		boolean hasLeft = false, hasRight = false;

		// check left
		for (int i = index - 1; i >= 0; i--) {
			if (isEstimated[i] == false) {
				score *= scores[i];
				hasLeft = true;
				break;
			}
		}

		// check right
		for (int i = index + 1; i < size; i++) {
			if (isEstimated[i] == false) {
				score *= scores[i];
				hasRight = true;
				break;
			}
		}

		if (!hasLeft && !hasRight) {
			return scores[index];
		}

		return score;
	}
}
