package game;

public enum Figures {
	NULL, CROSS, ZERO;
	public static int counter = 1;
	public static Figures getFigure(){
		Figures tmp =  Figures.values()[counter];
		counter++;
		return tmp;
	}
}
