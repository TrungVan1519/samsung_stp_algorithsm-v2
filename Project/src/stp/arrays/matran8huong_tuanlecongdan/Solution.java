package stp.arrays.matran8huong_tuanlecongdan;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {
	
	static int row, col;
	static char[][] arr;
	
	static int count;
	static int resX, resY;
	static int resCount;

	// 0-1 -1-1 -10 -11 01 11 10 1-1
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	/**
	 * Chú ý:
	 * >>> Sau khi đếm số lần bắt tay phải chia 2 vì khi lặp mảng, tất cả các phần tử thỏa mãn đều được tính nên sẽ bị lặp 2 lần
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\matran8huong_tuanlecongdan")));
			Scanner s = new Scanner(System.in);
			
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
			count = 0;
			resX = -1;
			resY = -1;
			resCount = 0;
			
			// >>> chọn chỗ cho Tý
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (arr[i][j] == '.') {
						if (count < check(i, j)) {
							count = check(i, j);
							resX = i;
							resY = j;
						}
					}
				}
			}
			
			// >>> Tý ngồi vào chỗ
			if (resX != -1 && resY != -1) {
				arr[resX][resY] = 'o'; 
			}
			
			// >>> đếm số lần bắt tay
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (arr[i][j] == 'o') {
						resCount += check(i, j);
					}
				}
			}
			
			// >>> vì lặp mỗi vị trí 2 lần nên phải chia tay
			resCount /= 2; 
			
			System.out.println(resCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int check(int x, int y) {
		int tx = 0, ty = 0;
		int count = 0;
		
		for (int i = 0; i < dx.length; i++) {
			tx = x + dx[i];
			ty = y + dy[i];
			
			if (tx < 0 || tx >= row || ty < 0 || ty >= col) {
				continue;
			}
			
			if (arr[tx][ty] == 'o') {
				count++;
			}
		}
		
		return count;
	}
}
