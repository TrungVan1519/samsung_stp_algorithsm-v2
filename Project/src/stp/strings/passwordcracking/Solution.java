package stp.strings.passwordcracking;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int changeCount;

	static int[][] arr;
	static int[][] changeArr;
	static int[] tmpArr;
	static int tmpIndex;

	static String resStr;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\strings\\passwordcracking")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				changeCount = s.nextInt();
				changeArr = new int[changeCount][2];

				arr = new int[5][5];
				tmpArr = new int[5 * 5];

				// input
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						arr[i][j] = s.nextInt();
					}
				}

				for (int i = 0; i < changeCount; i++) {
					changeArr[i][0] = s.nextInt();
					changeArr[i][1] = s.nextInt();
				}

				// solve
				tmpIndex = 0;
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						tmpArr[tmpIndex++] = arr[i][j];
					}
				}

				for (int i = 0; i < changeCount; i++) {
					int rsc = changeArr[i][0] - 1;
					int des = changeArr[i][1] - 1;

					if (rsc < des) {
						int tmpNumber = tmpArr[rsc];

						for (int j = rsc; j < des; j++) {
							tmpArr[j] = tmpArr[j + 1];
						}

						tmpArr[des] = tmpNumber;
					} else if (rsc > des) {
						int tmpNumber = tmpArr[rsc];

						for (int j = rsc; j > des; j--) {
							tmpArr[j] = tmpArr[j - 1];
						}

						tmpArr[des] = tmpNumber;
					}
				}

				resStr = "";
				for (int i = 0; i < tmpArr.length; i++) {
					if (i % 5 == 0) {
						resStr += "\n";
					}
					resStr += tmpArr[i] + " ";
				}
				System.out.println("Case #" + tc + ":" + resStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
