package game;

public enum Figures {
	NULL, CROSS, ZERO, ROMB;
	public static int counter = 1;
	public static Figures getFigure(){
		Figures tmp =  Figures.values()[counter];
		counter++;
		return tmp;
	}
	
	public static int getFigureCount(){
		return counter;
	}
	
	public static Figures getFigure(int Number){
		Figures tmp =  Figures.values()[Number];
		return tmp;
	}
	
}
