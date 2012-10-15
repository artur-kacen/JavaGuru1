package game;

import java.util.*;

public class Field {
	List<List<Figures>> figureTable;
	private int maxX;
	private int maxY;

	public Field(int X, int Y) {
		maxX = X;
		maxY = Y;
		figureTable = new ArrayList<List<Figures>>();
		
		for (int i = 0; i < maxY; i++){
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

	public boolean checkWin(Figures figure) {
		boolean match = false;
		int row = 0;
		int collumn = 0;
		while(collumn < maxX && !match){
			for (int i = 0; i < maxY -1; i++){
				if (figureTable.get(collumn).get(i) == figure && figureTable.get(collumn).get(i) == figureTable.get(collumn).get(i+1)) {
					match = true;
				} else {
					match = false;
					break;
				}
			}
			collumn++;
		}
		
		while(row < maxY && !match){
			for (int i = 0; i < maxY -1; i++){
				if (figureTable.get(i).get(row) == figure && figureTable.get(i).get(row) == figureTable.get(i+1).get(row) ) {
					match = true;
				} else {
					match = false;
					break;
				}
			}
			row++;
		}
		
		if (match){
			return true;
		} else {
			return false;
		}
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}
	
	public void showField(){
		for (List<Figures> f_list: figureTable){
			for (Figures f: f_list){
				System.out.print(f +  " | ");
			}
			System.out.println();
		}
	}
}
