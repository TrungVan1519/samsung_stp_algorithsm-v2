package stp.arrays.binhthuong_sonen1;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int N;
	
	static int resSum;

	/**
	 * Cách giải:
	 * >>> Chia lấy dư number khi number > 0
	 * >>> Cộng phần dư vào resSum
	 * >>> Chia lấy phần nguyên number để giảm number 10 lần sau mỗi vòng lặp
	 * 
	 * Chú ý:
	 * >>> Sau khi nén hết number phải nén tiếp resSum nếu resSum > 9
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\binhthuong_sonen1")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				// input
				N = s.nextInt();

				// solve
				resSum = sum(N);
				while (resSum > 9) {
					resSum = sum(resSum);
				}

				System.out.println("#" + tc + " " + resSum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static int sum(int num) {
		int sum = 0;

		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}

		return sum;
	}
}
