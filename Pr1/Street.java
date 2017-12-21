package tp.pr1;

public class Street {
	
	public Street (Place source, Direction direction, Place target) {
		this.source = source;
		this.direction = direction;
		this.target = target;
		
	}
	
	public boolean comeOutFrom(Place place, Direction whichDirection) {
		
		return ((place.equals(this.source) && this.direction.equals(whichDirection)) 
				||
				(place.equals(this.target) && this.direction.equals(whichDirection.Opposite(whichDirection)))
				);
	}
	
	public Place nextPlace (Place whereAmI) {
		if (whereAmI.equals(this.source)) return this.target;
		else if (whereAmI.equals(this.target)) return this.source;
		else return null;
	}
	//triple
	public boolean compare (Place place){
		return this.source.equals(place);
	}
	private Place source;
	private Direction direction;
	private Place target;
}
