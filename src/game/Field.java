package game;

import java.util.*;

public class Field {
	List<List<Figures>> figureTable;
	private int maxX;
	private int maxY;
	private int[] lastNullCoordinate = new int[2];

	public Field(int X, int Y) {
		maxX = X;
		maxY = Y;
		figureTable = new ArrayList<List<Figures>>();

		for (int i = 0; i < maxY; i++) {
			List<Figures> list = new ArrayList<Figures>(maxX);
			for (int j = 0; j < maxX; j++) {
				list.add(Figures.NULL);
			}
			figureTable.add(list);
		}
	}

	public boolean makeMove(int X, int Y, Figures figure) {
		if (figureTable.get(X).get(Y) == Figures.NULL) {
			figureTable.get(X).set(Y, figure);
			return true;
		}
		return false;
	}
	public boolean haveMoves(){
		boolean haveNulles = false;
		int row = 0;
		while(!haveNulles && row < maxY){
			for(int column = 0; column < maxX; column++){
				if(figureTable.get(column).get(row) == Figures.NULL)
					haveNulles = true;
			}
			row++;
		}
		return haveNulles;
	}
	public boolean checkWin(Figures figure) {
		int maxNullCount = 0;
		if (checkColum(figure, maxNullCount)) {
			return true;
		} else {
			if (checkRow(figure, maxNullCount)) {
				return true;
			} else {
				if (checkFirstDiagonal(figure, maxNullCount)) {
					return true;
				} else {
					if (checkSecondDiagonal(figure, maxNullCount)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean checkColum(Figures figure, int maxNullCount) {
		boolean match = false;
		int column = 0;
		int nullCount = 0;

		while (column < maxX && !match) {
			for (int row = 0; row < maxY; row++) {
				if (figureTable.get(column).get(row) == figure) {
					match = true;
				} else {
					if (figureTable.get(column).get(row) == Figures.NULL
							&& nullCount < maxNullCount) {
						lastNullCoordinate[0] = column;
						lastNullCoordinate[1] = row;
						nullCount++;
						match = true;
					} else {
						match = false;
						nullCount = 0;
						break;
					}
				}
			}
			column++;
		}

		return match;
	}

	public boolean checkRow(Figures figure, int maxNullCount) {
		boolean match = false;
		int row = 0;
		int nullCount = 0;

		while (row < maxY && !match) {
			for (int column = 0; column < maxX; column++) {
				if (figureTable.get(column).get(row) == figure) {
					match = true;
				} else {
					if (figureTable.get(column).get(row) == Figures.NULL
							&& nullCount < maxNullCount) {
						lastNullCoordinate[0] = column;
						lastNullCoordinate[1] = row;
						nullCount++;
						match = true;
					} else {
						nullCount = 0;
						match = false;
						break;
					}
				}
			}
			row++;
		}
		return match;
	}

	public boolean checkFirstDiagonal(Figures figure, int maxNullCount) {
		boolean match = false;
		int nullCount = 0;

		if (maxX == maxY && !match) {
			for (int i = 0; i < maxX; i++) {
				if (figureTable.get(i).get(i) == figure) {
					match = true;
				} else {
					if (figureTable.get(i).get(i) == Figures.NULL
							&& nullCount < maxNullCount) {
						lastNullCoordinate[0] = i;
						lastNullCoordinate[1] = i;
						nullCount++;
						match = true;
					} else {
						nullCount = 0;
						match = false;
						break;
					}
				}
			}
		}

		return match;
	}

	public boolean checkSecondDiagonal(Figures figure, int maxNullCount) {
		boolean match = false;
		int nullCount = 0;

		if (maxX == maxY && !match) {
			for (int i = 0; i < maxY; i++) {
				if (figureTable.get(i).get(maxY - 1 - i) == figure) {
					match = true;
				} else if (figureTable.get(i).get(maxY - 1 - i) == Figures.NULL
						&& nullCount < maxNullCount) {
					lastNullCoordinate[0] = i;
					lastNullCoordinate[1] = maxY - 1 - i;
					nullCount++;
					match = true;
				} else {
					nullCount = 0;
					match = false;
					break;
				}
			}
		}

		return match;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public int getLastNullXcoordinate() {
		return lastNullCoordinate[0];
	}

	public int getLastNullYcoordinate() {
		return lastNullCoordinate[1];
	}

	public void showField() {
		for (List<Figures> f_list : figureTable) {
			for (Figures f : f_list) {
				System.out.print(f + " | ");
			}
			System.out.println();
		}
	}
}
