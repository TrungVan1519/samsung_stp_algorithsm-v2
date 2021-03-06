package utils;

public class MyUtils {

	public static String getAbsolutePath(String packageName, String... os) {
		if (os.length > 0 && os[0].compareTo("mac") == 0) {
			return "/Users/trungvan/Dev/Java/Samsung STP/samsung_stp_algorithsm-v.2.0.0/" + packageName;
		}

		return "C:\\Users\\Admin\\Desktop\\STP\\Project\\src\\" + packageName + "\\input.txt";
	}

	public static void showMatrix(int[][] arr, int row, int col) {
		String tmp = "";
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				tmp += arr[i][j] + " ";
			}
			tmp += "\n";
		}
		System.out.println(tmp);
	}

	public static void showMatrix(char[][] arr, int row, int col) {
		String tmp = "";
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				tmp += arr[i][j] + " ";
			}
			tmp += "\n";
		}
		System.out.println(tmp);
	}

	public static void showArr(char[] arr, int i, int j) {
		String tmp = "";
		for (int k = i; k <= j; k++) {
			tmp += arr[k];
		}
		System.out.println(tmp);
	}

	public static void showArr(int[] arr, int i, int j) {
		String tmp = "";
		for (int k = i; k <= j; k++) {
			tmp += arr[k] + " ";
		}
		System.out.println(tmp);
	}
}
