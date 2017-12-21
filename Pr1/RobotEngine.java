package tp.pr1;

import java.util.Scanner;

public class RobotEngine {
	public RobotEngine(Place initialPlace, Direction direction, Street[] cityMap) {

		this.cityMap = cityMap;
		this.direction = direction;
		this.place = initialPlace;
	}

	// triplaco
	public int busqueda(Place searchedPlace) {
		int resultado = -1;
		for (int i = 0; i < this.cityMap.length; ++i)
			if (cityMap[i].comeOutFrom(searchedPlace, this.direction)) {
				resultado = i;
				break;
			}
		return resultado;
	}

	void startEngine() {
		Interpreter interprete = new Interpreter();
		Instruction instruccion = new Instruction();
		String command = new String();
		int indice = busqueda(this.place);
		// RobotEngine motor = new RobotEngine(initialPlace, Direction.NORTH,
		// cityMap);
		// en el main se crea un robotengine y se usa ese y ya esta, coño.
		System.out.println(this.place.toString());
		// hay que añadir la dirección a la que está mirando el WALL·E este
		System.out.println("WALL·E is looking at direction "
				+ this.direction.toString());
		System.out.println("WALL·E> ");

		Scanner comando = new Scanner(System.in);

		command = comando.nextLine();
		instruccion = interprete.generateInstruction(command);
		while (!(instruccion.getAction().equals(Action.QUIT) || this.place
				.isSpaceship())) {
			if (instruccion.getAction().equals(Action.HELP))
				System.out.println(interprete.interpreterHelp());
			else if (instruccion.getAction().equals(Action.TURN) && !(instruccion.getRotation().equals(Rotation.UNKNOWN))) {
				//if (instruccion.getRotation().toString().equalsIgnoreCase("left") || instruccion.getRotation().toString().equalsIgnoreCase("right")){
					//System.out.println(instruccion.getRotation().toString());
					this.direction = direction.nextDirection(
							instruccion.getRotation(), this.direction);
				//}
				//codigo repetido, hay que pensar en algo...
				//else System.out.println("WALL·E says: I do not understand. Please repeat");
			}else if (instruccion.getAction().equals(Action.MOVE)) {
				// si existe una calle en la dirección actual del robot...
				if (indice >= 0) {
					this.place = cityMap[indice].nextPlace(place);
					System.out.println("WALL·E says: Moving in direction "
							+ this.direction.toString() + LINE_SEPARATOR
							+ this.place.toString());
				}
				// en caso contrario
				else
					System.out.println("no se que hay ahi.");
			}else System.out.println("WALL·E says: I do not understand. Please repeat");
			//hay que cambiar para que cuando salga lo de arriba no salga lo de abajo.
			System.out.println("WALL·E is looking at direction "
					+ this.direction.toString());

			// System.out.print(this.place.isSpaceship());
			if (!this.place.isSpaceship()) {
				indice = busqueda(this.place);
				System.out.println("WALL·E> ");
				// comando = new Scanner(System.in);
				// comando = comando(System.in);
				command = comando.nextLine();
				instruccion = interprete.generateInstruction(command);
			}

		}

		if (this.place.isSpaceship())
			System.out
					.println("WALL·E says: I am at my spaceship. Shutting down... Bye bye.");
		else
			System.out.println("WALL·E says: Bye bye.");
	}

	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");
	private Place place;
	private Direction direction;
	private Street[] cityMap;
}

/*
 * Instruction instruccion = new Instruction(); Interpreter interprete = new
 * Interpreter(); System.out.println("(WALL·E>)") Scanner comando = new
 * Scanner(System.in); String command = new String(); command =
 * comando.nextLine(); instruccion = interprete.generateInstruction(command);
 * //.generateInstruction(command); while
 * (!(instruccion.getAction().equals(Action.QUIT))){ if
 * (instruccion.getAction().equals(Action.HELP)){
 * System.out.println(interprete.interpreterHelp()); }else if
 * (instruccion.getAction().equals(Action.TURN)){ instruccion.getRotation(); }
 * 
 * 
 * command = comando.nextLine(); instruccion =
 * interprete.generateInstruction(command); } //
 */
