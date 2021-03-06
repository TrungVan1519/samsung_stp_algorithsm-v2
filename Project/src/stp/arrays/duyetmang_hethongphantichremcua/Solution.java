package stp.arrays.duyetmang_hethongphantichremcua;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int M, N;
	static char[][] arr;

	static int[] types;
	static String resStr;

	/**
	 * Cách giải: 
	 * >>> Lặp các phần tử đầu tiên của từng ô cửa sổ 
	 * >>> Sau đó lặp theo chỉ số hàng để kiểm tra kiểu cửa sổ 
	 * >>> Dùng 1 mảng types và tăng chỉ số với kiểu thích hợp
	 * 
	 * Chú ý: 
	 * >>> Ta chỉ cần kiểm tra phần tử đầu tiên của từng ô cửa sổ nên chỉ cần cho chạy chỉ số cột i 
	 * >>> Phải chạy i vs j từ 1 để bỏ qua khung cửa sổ và cho i+=5 vs j+=5 
	 * >>> Trong hàm check để check từng hàng cửa sổ thì phải cho i=x và i<x+5
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\duyetmang_hethongphantichremcua")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				M = s.nextInt();
				N = s.nextInt();
				int row = 5 * M + 1;
				int col = 5 * N + 1;
				arr = new char[row][col];
				types = new int[5];

				// input
				for (int i = 0; i < row; i++) {
					String str = s.next();
					for (int j = 0; j < col; j++) {
						arr[i][j] = str.charAt(j);
					}
				}

				// solve
				resStr = "";
				for (int i = 1; i < row; i += 5) {
					for (int j = 1; j < col; j += 5) {
						check(i, j);
					}
				}

				for (int i = 0; i < types.length; i++) {
					resStr += types[i] + " ";
				}

				System.out.println("#" + tc + " " + resStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void check(int x, int y) {
		int index = 0;

		for (int i = x; i < x + 5; i++) {
			if (arr[i][y] == '*') {
				index++;
			}
		}

		types[index]++;
	}
}
