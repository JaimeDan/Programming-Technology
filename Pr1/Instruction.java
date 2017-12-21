package tp.pr1;

public class Instruction {
	
	
	public Instruction (){
		this.action = Action.UNKNOWN;
	}
	
	public Instruction (Action action){
		this.action = action;
	}

	public Instruction (Action action, Rotation rotation){
		this.action = action;
		this.rotation = rotation;
	}
	
	public Action getAction(){
		return this.action ;	
	}
	
	public Rotation getRotation(){
		return this.rotation;
	}
	
	boolean isValid(){
		return  !((this.action.equals("UNKNOWN")) || ((this.action.equals("TURN") && this.rotation.equals("UNKNOWN"))) ) ; 
	}
	private Action action;
	private Rotation rotation;
}
