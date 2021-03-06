package tp.pr5.instructions;

import tp.pr5.NavigationModule;
import tp.pr5.RobotEngine;
import tp.pr5.instructions.exceptions.InstructionExecutionException;
import tp.pr5.instructions.exceptions.WrongInstructionFormatException;
import tp.pr5.items.Item;
import tp.pr5.items.ItemContainer;

public class DropInstruction extends UndoableInstruction {
	
	public DropInstruction() {
		
	}
	
	public DropInstruction(String robotsObject) {

		this.id = robotsObject;
	}



	public void configureContext(RobotEngine engine, NavigationModule navigation, ItemContainer robotContainer) {
		this.navigation = navigation;
		this.robotContainer = robotContainer;
		this.engine = engine;
	}

	public void execute() throws InstructionExecutionException {

		Item item = robotContainer.pickItem(id);
		if (item == null)
			throw new InstructionExecutionException("You do not have any " + id
					+ ".");
		if (navigation.findItemAtCurrentPlace(id))
			throw new InstructionExecutionException(
					"This item already exists in this place");
		if (!((item == null) || (navigation.findItemAtCurrentPlace(id)))) {
			navigation.dropItemAtCurrentPlace(item);
			engine.saySomething("Great! I have dropped " + id);
		}

	}
	
	public void undo() {
		
		Item item = navigation.pickItemFromCurrentPlace(id);
		this.robotContainer.addItem(item);
	}

	public String getHelp() {
		return "DROP|SOLTAR <id>";

	}

	public Instruction parse(String cad) throws WrongInstructionFormatException {
		String[] comando = cad.split(" ");
		if ((comando[0].equalsIgnoreCase("DROP") || comando[0]
				.equalsIgnoreCase("SOLTAR")) && (comando.length == 2)) {
			id = comando[1];
			return this;
		} else
			throw new WrongInstructionFormatException();

	}
	
	private RobotEngine engine;
	private NavigationModule navigation;
	private ItemContainer robotContainer;
	private String id;

}
