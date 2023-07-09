package sudoku;

public class SudokuSolver {
	
	
	private boolean recSolve(Sudoku s, int idx) {
		
		if (idx > 81)
			return true;
		
		int row = idx / 9;
		int col = idx % 9;
		boolean done = false;
		
		char c = s.get(row, col);
		
		if (c == '.') {
			
			for (char num = '1'; num <= '9'; num++) {
				
				// try number
				s.set(row, col, num);
				
				if (s.check()) { // if it works, try next field
					
					done = recSolve(s, idx + 1);
					if (done)
						return true;
				}
			}

			s.set(row, col, '.');
			return false;
			
		} else {
			done = recSolve(s, idx + 1);
		}
		
		return done;
	}
	
	public boolean solve(Sudoku s) {
		return recSolve(s, 0);
	}
	
}
