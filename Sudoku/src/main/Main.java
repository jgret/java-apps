package main;

import sudoku.Sudoku;
import sudoku.SudokuSolver;

public class Main {

	public static void main(String[] args) {

//		for (int num = 0; num < 10; num++) {
//			
//			Sudoku s = new Sudoku();
//			boolean ret = s.load("res/sudoku/demo" + num + ".txt");
//			
//			if (!ret)
//				System.out.println("Failed to load Sudoku");
//			
//			s.print();
//			System.out.println("Sudoku Valid: " + s.check());
//		
//		}

		Sudoku s = new Sudoku();
		
		if (!s.load("res/sudoku/demo0.txt"))
			System.out.println("Failed to load Sudoku");

		s.print();
		System.out.println("Sudoku Valid: " + s.check());
		
		
		long startTime = System.nanoTime();
		SudokuSolver solver = new SudokuSolver();
		solver.solve(s);
		long time = System.nanoTime() - startTime;
		System.out.println("Solver took " + (time / 1000000) + "ms");	
		s.print();

	}

}
