public class Factory {
	private int cost;
	private int input;
	private int output;
	private int researchCost;
	private int level;
	
	

	public Factory() {
		cost = 4000;
		input = 60;
		output = 1;
		researchCost = 2;
		level = 0;
	}

	public void upgrade() {
		//change building appearance
		output*=2;
		cost*=2;
		researchCost *=2;
		level++;
		
	}

	public int getCost() {
		return cost;
	}

	public int getInput() {
		return input;
	}

	public int getOutput() {
		return output;
	}

	public int getResearchCost() {
		return researchCost;
	}
	
	public int getLevel()
	{
		return level;
	}
}

