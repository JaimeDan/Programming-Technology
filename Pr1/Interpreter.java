package tp.pr1;

public class Interpreter {
	
	
	public Instruction generateInstruction (java.lang.String line) {
		String[] comando = line.split(" ");
		Instruction instruction;
		//REVISAR
		if(comando[0].equalsIgnoreCase("TURN")){
			if (comando[1].equalsIgnoreCase("RIGHT")){
				instruction = new Instruction(Action.TURN,Rotation.RIGHT );
			}
			else if (comando[1].equalsIgnoreCase("LEFT")){
				instruction = new Instruction(Action.TURN,Rotation.LEFT );
			}
			else{
				instruction = new Instruction(Action.TURN, Rotation.UNKNOWN);
			}
		}
		else if(comando[0].equalsIgnoreCase("QUIT")){
			instruction = new Instruction(Action.QUIT);
		}
		else if(comando[0].equalsIgnoreCase("MOVE")) {
			instruction = new Instruction(Action.MOVE);
		}
		else if(comando[0].equalsIgnoreCase("HELP")) {
			instruction = new Instruction(Action.HELP);
		}
		else instruction = new Instruction();
	return instruction;

	}
	
	public String interpreterHelp (){
		return "The valid instructions for WALL·E are:"
				+LINE_SEPARATOR+
				"MOVE"
				+LINE_SEPARATOR+
				"TURN <LEFT | RIGHT>"
				+LINE_SEPARATOR+
				"HELP"
				+LINE_SEPARATOR+
				"QUIT";
	}
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
}
