package stp.arrays.matran8huong_quanmaduocchon;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Scanner;

import utils.MyUtils;

public class Solution {

	static int T;

	static int size, K, M, D;
	static char[][] arr;
	static int[] Ks, Ms, Ds;

	static int resCount, resX;

	// -1-2 -2-1 -21 -12 12 21 2-1 1-2
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	/**
	 * Chú ý:
	 * >>> Không lặp toàn bộ ma trận mà chỉ lặp mảng Ks để lấy ra vị trí 3 Knights sau đó mới solve
	 * >>> Không tạo thêm biến int rowKs, rowMs và rowDs vì nó làm time limit exceed
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("stp\\arrays\\matran8huong_quanmaduocchon")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				size = s.nextInt();
				K = s.nextInt();
				M = s.nextInt();
				D = s.nextInt();

				arr = new char[size][size];
				Ks = new int[K * 2];
				Ms = new int[M * 2];
				Ds = new int[D * 2];

				// input
				for (int i = 0; i < Ks.length; i++) {
					Ks[i] = s.nextInt();
				}

				for (int i = 0; i < Ms.length; i++) {
					Ms[i] = s.nextInt();
				}

				for (int i = 0; i < Ds.length; i++) {
					Ds[i] = s.nextInt();
				}

				// fill Ks, Ms, Ds into arr
				for (int i = 0; i < Ks.length; i++) {
					if (i % 2 == 0) {
						arr[Ks[i]][Ks[i + 1]] = 'K';
					}
				}
				
				for (int i = 0; i < Ms.length; i++) {
					if (i % 2 == 0) {
						arr[Ms[i]][Ms[i + 1]] = 'M';
					}
				}
				
				for (int i = 0; i < Ds.length; i++) {
					if (i % 2 == 0) {
						arr[Ds[i]][Ds[i + 1]] = 'D';
					}
				}

				// solve
				resCount = 0;
				resX = 0;
				for (int i = 0; i < Ks.length; i++) {
					if (i % 2 == 0) {
						if (resCount < check(Ks[i], Ks[i + 1])) {
							resCount = check(Ks[i], Ks[i + 1]);
							resX = i;
						}
					}
				}

				System.out.println("#" + tc + " " + Ks[resX] + " " + Ks[resX + 1] + " " + resCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int check(int x, int y) {
		int tx, ty;
		int count = 0;

		for (int i = 0; i < dx.length; i++) {
			tx = x + dx[i];
			ty = y + dy[i];

			if (tx < 0 || tx >= size || ty < 0 || ty >= size) {
				continue;
			}

			if (arr[tx][ty] == 'K' || arr[tx][ty] == 'M') {
				count++;
			}
		}

		return count;
	}
}
