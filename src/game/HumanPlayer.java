package game;

import java.util.Scanner;

public class HumanPlayer extends Player {
	//public Figures figure = Figures.getFigure();
	public void turn(Field field) {
		boolean match = false;
		Scanner sc = new Scanner(System.in);
		int x = 0, y = 0;
		while (!match) {
			System.out.println("Enter coordinates where to make move(x,y):");
			x = scanCoordinates(sc);
			y = scanCoordinates(sc);
			if (x > 0 && x < field.getMaxX() +1  && y > 0 && y < field.getMaxY() + 1) {
				if (field.makeMove(x-1, y-1, figure)) {
					match = true;
				} else
					System.out.println("This place is already used! Try again :)");
			} else {
				System.out.println("Invalid input! Try again!");;					
			}
		}
	}
	
	public static int scanCoordinates(Scanner sc){
		if (sc.hasNextInt()){
			return sc.nextInt();
		} else {
			sc.next();
			return -1;
		}		
	}
}
