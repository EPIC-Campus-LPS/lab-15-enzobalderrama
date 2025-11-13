package pack;

public class Matrix {
	private static int[][] matrix;
	public static void main(String[] args) {
		matrix = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matrix[i][j] = (int)(Math.random()*15+1);
			}
		}
		System.out.println(Matrix.detectEquivalentAdjacentPairs(matrix));
		System.out.println(Matrix.checkDuplicates(matrix));
		System.out.println(Matrix.shiftRight(matrix, 3, 2));
		System.out.println(Matrix.shiftUp(matrix, 3, 2));
		System.out.println(Matrix.reverseRow(matrix, 2));
		System.out.println(Matrix.reverseColumn(matrix, 2));
	}
	public static int detectEquivalentAdjacentPairs(int[][] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr[i].length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
		}
		return count;
	}
	public static String checkDuplicates(int[][] arr){
		int[] arrcheck = new int[25];
		String fullstring = "";
		for (int i = 0; i < 25; i++) {
			arrcheck[i] = 0;
		}
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arrcheck[k] = arr[i][j];
				k++;
			}
		}
		for (int i = 0; i < 25; i++) {
			int count = 1;
			for (int j = i+1; j < 25; j++) {
				if (arrcheck[i] == arrcheck[j]) {
					count++;
					arrcheck[j] = -1;
				}
			}
			if (count > 1 && arrcheck[i] != -1) {
				fullstring += arrcheck[i] + ": " + count + "\n";
			}
		}
		return fullstring;
	}
	public static String shiftRight(int[][] arr, int shift, int row) {
		for (int i = 0; i < row; i++) {
			arr[row][i] = (arr[row][i] + shift) % 5;
		}
		String fullstring = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				fullstring += arr[i][j] + " ";
			}
			fullstring += "\n";
		}
		return fullstring;
	}
	public static String shiftUp(int[][] arr, int shift, int col) {
		for (int i = 0; i < col; i++) {
			arr[i][col] = (arr[i][col] + shift) % 5;
		}
		String fullstring = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				fullstring += arr[i][j] + " ";
			}
			fullstring += "\n";
		}
		return fullstring;
	}
	public static String reverseRow(int[][] arr, int row) {
		int s = 0;
		int e = arr.length-1;
		while (s < e) {
			int tempvar = arr[row][s];
			arr[row][s] = arr[row][e];
			arr[row][e] = tempvar;
			s++;
			e--;
		}
		String fullstring = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				fullstring += arr[i][j] + " ";
			}
			fullstring += "\n";
		}
		return fullstring;
	}
	public static String reverseColumn(int[][] arr, int col) {
		int s = 0;
		int e = arr.length-1;
		while (s < e) {
			int tempvar = arr[s][col];
			arr[s][col] = arr[e][col];
			arr[e][col] = tempvar;
			s++;
			e--;
		}
		String fullstring = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				fullstring += arr[i][j] + " ";
			}
			fullstring += "\n";
		}
		return fullstring;
	}
}