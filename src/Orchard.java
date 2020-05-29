
public class Orchard {
	private int cost;
	private int output;
	private int researchCost;
	private int level;


	public Orchard() {
		cost = 2000;
		output = 30 ;
		researchCost = 2;
		level = 0;
	}

	public void upgrade() {
		//change building appearance
		cost *=2;
		output*=2;
		researchCost *=2;
		level++;
		
	}




	public int getCost() {
		return cost;
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
