package stp.arrays.duyetmang_daovangremix;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int row, col;
	static char[][] arr;

	static int goldRow, goldCol;
	static int resSum;

	/**
	 * Cách giải:
	 * >>> Lặp mảng và check arr[i][j] == '0' hay không
	 * >>> Nếu != '0' thì bỏ qua
	 * >>> Nếu == '0' thì check cả hàng và cột chứa arr[i][j] có chứa toàn '0' không
	 * >>>		Nếu không chứa toàn '0' thì bỏ qua
	 * >>>		Nếu có chứa toàn '0' thì sẽ tăng goldRow++ hoặc goldCol++ tùy theo đang xét hàng hay cột
	 * >>> Tính ra số hàng và số cột thực sự bằng cách chia số goldRow và goldCol lần lượt cho col và row
	 * >>> Tính tổng số vàng bằng cách cộng goldRow vs goldCol và trừ cho số vàng bị trùng giữa các hàng và cột
	 * 
	 * Chú ý:
	 * >>> Khi check cả hàng chứa arr[i][j] có chứa toàn '0' thì chỉ số row i là cố định nên chỉ cần cho chạy chỉ số col j
	 * >>> Tương tự vs check cả cột chứa arr[i][j] có chứa toàn '0' thì chỉ số col j là cố định nên chỉ cần cho chạy chỉ số row i
	 * >>> Cực kỳ phải chú ý tính số hàng và số cột thực sự
	 * >>>		số hàng = số vàng trên hàng / số cột (phải là SỐ CỘT chứ không phải số hàng)
	 * >>>		số cột = số vàng trên cột / số hàng (phải là SỐ HÀNG chứ không phải số cột)
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\duyetmang_daovangremix")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				row = s.nextInt();
				col = s.nextInt();
				arr = new char[row][col];

				// input
				for (int i = 0; i < row; i++) {
					String str = s.next();
					for (int j = 0; j < col; j++) {
						arr[i][j] = str.charAt(j);
					}
				}
				
				// solve
				goldRow = 0;
				goldCol = 0;
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (arr[i][j] == '0') {
							if (checkRow(i)) {
								goldRow++;
							}

							if (checkCol(j)) {
								goldCol++;
							}
						}
					}
				}
				
				int validRow = goldRow / col;
				int validCol = goldCol / row;
				resSum = goldRow + goldCol - validRow * validCol;
				System.out.println("#" + tc + " " + resSum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean checkRow(int i) {
		for (int j = 0; j < col; j++) {
			if (arr[i][j] != '0') {
				return false;
			}
		}
		return true;
	}

	private static boolean checkCol(int j) {
		for (int i = 0; i < row; i++) {
			if (arr[i][j] != '0') {
				return false;
			}
		}
		return true;
	}
}
