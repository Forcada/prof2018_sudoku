package es.upm.grise.profundizacion2018.sudokuverifier;

import java.util.ArrayList;
import java.util.HashSet;

public class SudokuVerifier {
	
	public int verify (String candidateSolution) {
		
		//Check length
		if (!verifyLength(candidateSolution)) return -1;
		
		//Check numbers
		if (!verifyNumbers(candidateSolution)) return 1;
		
		//Check cells
		if (!verifyCells(candidateSolution)) return 2;
		
		//Check rows
		if (!verifyRows(candidateSolution)) return 3;
		
		//Check columns		
		if (!verifyColumns(candidateSolution)) return 4;
		
		return 0;
    }
	
	private boolean verifyLength(String sudoku) {
		return sudoku.length() == 81 ? true : false;
	}
	
	private boolean verifyNumbers (String sudoku) {
		for (int n = 0;n<sudoku.length();n++) {		
			if (Character.digit(sudoku.charAt(n), 10) < 0) return false;
		}
		return true;
	}
	
	private boolean verifyCells (String sudoku) {
		ArrayList<Integer> cell;
		for (int r = 0;r<sudoku.length();r = r + 9*3) {
			for (int c = 0;c<9;c = c+3) {
				cell = new ArrayList<Integer>();
				for (int m = 0;m<9*3;m = m+9) {
					for (int n = 0;n<3;n++) {
						cell.add(Character.getNumericValue(sudoku.charAt(r + c + m + n)));
					}			
					if (cell.size() == 9) {
						if(!notRepeated(cell)) return false;
						cell = new ArrayList<Integer>();
					}
				}
			}		
		}
		return true;
	}
	
	private boolean verifyRows (String sudoku) {
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int n = 0;n<sudoku.length();n++) {			
			row.add(Character.getNumericValue(sudoku.charAt(n)));
			if (row.size() == 9) {
				if(!notRepeated(row)) return false;
				row = new ArrayList<Integer>();
			}			
		}
		return true;
	}
	
	private boolean verifyColumns (String sudoku) {
		ArrayList<Integer> column;
		for (int m = 0;m<9;m++) {
			column = new ArrayList<Integer>();
			for (int n = 0;n<sudoku.length();n = n+9) {
				column.add(Character.getNumericValue(sudoku.charAt(m + n)));
				if (column.size() == 9) {
					if(!notRepeated(column)) return false;
					column = new ArrayList<Integer>();
				}	
			}
		}
		return true;
	}
	
	private boolean notRepeated (ArrayList<Integer> list) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i=1;i<10;i++) {
			numbers.add(i);
		}
		return new HashSet<Integer>(list).equals(new HashSet<Integer>(numbers));
	}
}
