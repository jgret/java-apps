package main;

import sudoku.Sudoku;
import sudoku.SudokuSolver;

/**
 * Link: https://codegolf.stackexchange.com/questions/190727/the-fastest-sudoku-solver
 */

public class Main {

	public static void main(String[] args) {

		Sudoku sudoku = new Sudoku();
		SudokuSolver solver = new SudokuSolver();
		
		if (!sudoku.load("res/sudoku/demo10.txt"))
			System.out.println("Failed to load Sudoku");

		sudoku.print();
		
		if (!sudoku.check()) {			
			System.out.println("Sudoku is invalid!");
			return;
		}

		long startTime = System.nanoTime();
		solver.solve(sudoku);
		long time = System.nanoTime() - startTime;

		System.out.println();
		sudoku.print();
		System.out.println();
		System.out.println("Solver took " + ((float) time / 1000000) + "ms");	

	}

}
