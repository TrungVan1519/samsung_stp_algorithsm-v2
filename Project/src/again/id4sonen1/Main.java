package again.id4sonen1;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyUtils;

public class Main {

	static int T;

	static long num, resSum;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyUtils.getAbsolutePath("again\\id4sonen1")));
			Scanner s = new Scanner(System.in);

			T = s.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				num = s.nextLong();

				resSum = getSum(num);
				while (resSum > 9) {
					resSum = getSum(resSum);
				}

				System.out.println("#" + tc + " " + resSum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static long getSum(long number) {
		long sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
}
