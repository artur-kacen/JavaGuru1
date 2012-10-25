package game;

import java.util.Random;

public class AIPlayer extends Player{
	public void turn (Field field){
		System.out.println("Computer move");
		if(findMoveToWin(field)){
			System.out.println("WIN!");
			field.makeMove(field.getLastNullXcoordinate(), field.getLastNullYcoordinate(), figure);
		} else {
			if(findMoveToDefence(field)){
				System.out.println("DEF!");
				field.makeMove(field.getLastNullXcoordinate(), field.getLastNullYcoordinate(), figure);
			} else {
				makeRandomMove(field);	
				System.out.println("RND!");
			}
			
		}		
	}
private boolean findMoveToWin(Field field){
	int availableNullCount = 1;
	if (field.checkRow(figure, availableNullCount)){
		return true;
	} else
	if (field.checkColum(figure, availableNullCount)){
		return true;
	} else
	if (field.checkFirstDiagonal(figure, availableNullCount)){
		return true;
	} else
	if (field.checkSecondDiagonal(figure, availableNullCount)){
		return true;
	} else			
	return false;
}
private boolean findMoveToDefence(Field field){
	int availableNullCount = 1;

	for (int i = 1; i < Figures.getFigureCount(); i++){
		Figures enemyFigure = Figures.getFigure(i);
		if (field.checkRow(enemyFigure, availableNullCount)){
			return true;
		}
		if (field.checkColum(enemyFigure, availableNullCount)){
			return true;
		}
		if (field.checkFirstDiagonal(enemyFigure, availableNullCount)){
			return true;
		}
		if (field.checkSecondDiagonal(enemyFigure, availableNullCount)){
			return true;
		}			
	}
	return false;
}
private void makeRandomMove(Field field){
	Random rn = new Random();
	int x = 0;
	int y = 0;
	x = rn.nextInt(field.getMaxX());
	y = rn.nextInt(field.getMaxY());
	
	do{
		x = rn.nextInt(field.getMaxX());
		y = rn.nextInt(field.getMaxY());
	} while (!field.makeMove(x, y, figure));
}

}
