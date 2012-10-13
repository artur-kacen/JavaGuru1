package game;

import java.util.Scanner;

public interface Game {

	public class TickTackToe {
		Field field;
		private Player[] players;
		private int currentPlayer;
		private int playerCount;

		public TickTackToe(int playerCount, int fieldX, int fieldY) {
			players = new Player[playerCount];
			field = new Field(fieldX, fieldY);
			this.playerCount = playerCount;

			for (int i = 0; i < playerCount; i++) {
				System.out.println("Player Nr. " + (i + 1)
						+ " will be ([P]layer or [C]omputer):");
				Scanner sc = new Scanner(System.in);
				boolean match;
				do {
					match = true;
					String type = sc.nextLine();
					if (type.equalsIgnoreCase("p")) {
						players[i] = new HumanPlayer();
					} else if (type.equalsIgnoreCase("c")) {
						players[i] = new AIPlayer();
					} else {
						System.out.println("Incorrect type. Try again!");
						match = false;
					}
				} while (!match);
			}
			selectFigure();
		}
		
		private void selectFigure(){
			for (int i = 0; i < playerCount; i++){
				players[i].figure = Figures.getFigure();
			}
		}
		
		private boolean gameEnd() {
			if (field.checkWin(players[currentPlayer].figure)) {
				return true;
			} else {
				switchPlayer();
				return false;
			}
		}

		private void switchPlayer() {
			currentPlayer++;
			if (currentPlayer > playerCount) {
				currentPlayer = 0;
			}
		}

		public void play() {
			while (!gameEnd()) {
				players[currentPlayer].turn(field);
				//switchPlayer();
			}
		}
		
	}
}
