package tp.pr1;

public class Place {

	private boolean isSpaceShip;
	private String name;
	private String description;
	
	public Place (java.lang.String name, boolean isSpaceShip, java.lang.String description) {
		this.name = name;
		this.isSpaceShip = isSpaceShip;
		this.description = description;
	}
	
	boolean isSpaceship() {
		return this.isSpaceShip;	
	}
	
	
	public String toString() {
		
		return this.name + LINE_SEPARATOR + this.description;
		
		
	}private static final String LINE_SEPARATOR = System.getProperty("line.separator");

}

