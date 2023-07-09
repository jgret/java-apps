package sudoku;

import java.io.*;
import java.util.ArrayList;

public class Sudoku {

	private char[][] fields;

	public Sudoku() {
		this.fields = new char[9][9];
	}

	public boolean load(String filename) {

		boolean loaded = false;

		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));

			// read in line by line
			for (int i = 0; i < 9; i++) {
				String line = in.readLine();

				if (line != null) {

					char[] ch = line.toCharArray();
					for (int j = 0; j < 9; j++) {

						if (ch[j] < '1' || ch[j] > '9')
							fields[i][j] = '.';
						else
							fields[i][j] = ch[j];

					}

				}
			}

			in.close();

			loaded = true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return loaded;
	}

	private boolean isValidField(int row, int col) {
		return row < 9 && row >= 0 && col < 9 && col >= 0;
	}

	public char get(int row, int col) {
		if (!isValidField(row, col))
			return '.';

		return fields[row][col];
	}

	public boolean set(int row, int col, char c) {
		if (!isValidField(row, col))
			return false;

		if ((c < '1' || c > '9') && c != '.')
			return false;

		fields[row][col] = c;
		return true;
	}

	public boolean check() {

		boolean check = true;

		// check lines
		for (int row = 0; row < 9; row++) {

			for (char num = '1'; num <= '9'; num++) {

				int count = 0;

				for (int col = 0; col < 9; col++) {
					if (fields[row][col] == num)
						count++;
				}

				if (count != 0 && count != 1)
					check = false;

			}

		}
		
		if (!check) {
			// System.out.println("Row Check Failed");
			return false;
		}
		
		// check cols
		for (int col = 0; col < 9; col++) {


			for (char num = '1'; num <= '9'; num++) {

				int count = 0;
				for (int row = 0; row < 9; row++) {

					if (fields[row][col] == num)
						count++;
				}

				if (count != 0 && count != 1)
					check = false;

			}

		}
		
		if (!check) {
			// System.out.println("Column Check Failed");
			return false;
		}
		
		
		for (int i = 0; i < 9; i++) {

			int rowOffset = (i / 3) * 3;
			int colOffset = (i % 3) * 3;
			
			for (char num = '1'; num <= '9'; num++) {

				int count = 0;

				for (int j = 0; j < 9; j++) {
					if (fields[rowOffset + (j / 3)][colOffset + (j % 3)] == num)
						count++;
				}

				if (count != 0 && count != 1)
					check = false;

			}
			
		}
		

		if (!check) {
			// System.out.println("Field Check Failed");
			return false;
		}

		return check;
	}
	
	public void print() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				System.out.print(fields[row][col]);
			}
			System.out.println();
		}
	}

}
