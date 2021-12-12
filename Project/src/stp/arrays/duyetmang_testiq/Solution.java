package stp.arrays.duyetmang_testiq;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int size = 4;
	static char[][] arr;

	static int resCount;

	/**
	 * Cách giải:
	 * >>> Nếu hình vuông to chỉ toàn tồn tại hình vuông con 2x2 chứa 2 ký tự '#' và 2 ký tự '.' thì in 'NO'
	 * >>> Còn lại thì in 'YES' dù hình vuông to tồn tại ít nhất 1 hình vuông con 2x2 không chứa 2 ký tự '#' và 2 ký tự '.'
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\duyetmang_testiq")));
			Scanner s = new Scanner(System.in);

			arr = new char[size][size];

			// input
			for (int i = 0; i < size; i++) {
				String str = s.next();
				for (int j = 0; j < size; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// solve
			resCount = 0;
			for (int i = 0; i < size - 1; i++) {
				for (int j = 0; j < size - 1; j++) {
					if (arr[i][j] + arr[i + 1][j + 1] + arr[i + 1][j] + arr[i][j + 1] != 2 * ('#' + '.')) {
						resCount++;
					}
				}
			}

			if (resCount > 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
