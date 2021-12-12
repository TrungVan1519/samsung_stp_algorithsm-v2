package stp.arrays.duyetmang_bioauthen;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int size;
	static int[][] origin, input;
	static int[] dirRotate;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\duyetmang_bioauthen")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				size = s.nextInt();
				origin = new int[size][size];
				input = new int[size][size];
				dirRotate = new int[4]; // dirRotate*90 degree

				// input
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						origin[i][j] = s.nextInt();
					}
				}

				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						input[i][j] = s.nextInt();
					}
				}

				// solve
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (input[i][j] == origin[i][j]) {
							dirRotate[0]++;
						} 
						if (input[i][j] == origin[j][size - 1 - i]) {
							dirRotate[1]++;
						} 
						if (input[i][j] == origin[size - 1 - i][size - 1 - j]) {
							dirRotate[2]++;
						} 
						if (input[i][j] == origin[size - 1 - j][i]) {
							dirRotate[3]++;
						}
					}
				}

				for (int i = 0; i < dirRotate.length; i++) {
					if (dirRotate[i] == size * size) {
						System.out.println("#" + tc + " " + i);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
