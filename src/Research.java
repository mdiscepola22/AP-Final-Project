
public class Research {
	
	private int cost;
	private int output;
	public Research() {
		cost = 2000;
		output = 2;
	}
	
	public void upgrade() {
		output*=4;
		cost*=2;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getOutput() {
		return output;
	}


}
