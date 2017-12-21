package tp.pr1;

public enum Direction {

	EAST, NORTH, SOUTH, UNKNOWN, WEST;

	public Direction Opposite(Direction direction) {
		if (direction.equals(EAST))
			return Direction.WEST;
		else if (direction.equals(WEST))
			return Direction.EAST;
		else if (direction.equals(NORTH))
			return Direction.SOUTH;
		else if (direction.equals(SOUTH))
			return Direction.NORTH;
		else
			return null;
	}

	public Direction nextDirection(Rotation rotation, Direction direction) {
		Direction nextDir = null;
		if (rotation.equals(Rotation.LEFT)) {
			if (direction.equals(Direction.EAST))
				nextDir = Direction.NORTH;
			else if (direction.equals(Direction.NORTH))
				nextDir = Direction.WEST;
			else if (direction.equals(Direction.WEST))
				nextDir = Direction.SOUTH;
			else if (direction.equals(Direction.SOUTH))
				nextDir = Direction.EAST;
			else 
				nextDir = direction;
		} else {
			if (direction.equals(Direction.EAST))
				nextDir = Direction.SOUTH;
			else if (direction.equals(Direction.SOUTH))
				nextDir = Direction.WEST;
			else if (direction.equals(Direction.WEST))
				nextDir = Direction.NORTH;
			else if (direction.equals(Direction.NORTH))
				nextDir = Direction.EAST;
			else 
				nextDir = direction;
			// this.direction + instruccion.getRotation();
		}
		return nextDir;
	}
}
