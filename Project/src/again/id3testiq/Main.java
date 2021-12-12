package again.id3testiq;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static char[][] arr = new char[4][4];

	static boolean isValid;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("again\\id3testiq")));
			Scanner s = new Scanner(System.in);

			for (int i = 0; i < 4; i++) {
				String str = s.next();
				for (int j = 0; j < 4; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			isValid = false;
			for (int i = 0; i < 4 - 1; i++) {
				for (int j = 0; j < 4 - 1; j++) {
					if (arr[i][j] + arr[i + 1][j + 1] + arr[i + 1][j] + arr[i][j + 1] != 2 * ('.' + '#')) {
						isValid = true;
						break;
					}
				}
			}

			if (isValid) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
