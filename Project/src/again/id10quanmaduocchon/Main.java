package again.id10quanmaduocchon;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static int size, K, M, D;
	static char[][] arr;
	static int[] Ks, Ms, Ds;

	static int resX, resCount;

	// -1-2 -2-1 -21 -12 12 21 2-1 1-2
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("again\\id10quanmaduocchon")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				size = s.nextInt();
				K = s.nextInt();
				M = s.nextInt();
				D = s.nextInt();

				arr = new char[size][size];
				Ks = new int[2 * K];
				Ms = new int[2 * M];
				Ds = new int[2 * D];

				for (int i = 0; i < Ks.length; i++) {
					Ks[i] = s.nextInt();
				}

				for (int i = 0; i < Ms.length; i++) {
					Ms[i] = s.nextInt();
				}

				for (int i = 0; i < Ds.length; i++) {
					Ds[i] = s.nextInt();
				}

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

				resCount = 0;
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
			// TODO: handle exception
		}
	}

	private static int check(int i, int j) {
		int ti, tj;
		int count = 0;

		for (int k = 0; k < dx.length; k++) {
			ti = i + dx[k];
			tj = j + dy[k];

			if (ti < 0 || ti >= size || tj < 0 || tj >= size) {
				continue;
			}

			if (arr[ti][tj] == 'K' || arr[ti][tj] == 'M') {
				count++;
			}
		}
		return count;
	}
}
