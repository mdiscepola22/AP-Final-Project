
public class Orchard {
	private int cost;
	private int output;
	private int researchCost;


	public Orchard() {
		cost = 2000;
		output = 30 ;
		researchCost = 2;
	}

	public void upgrade() {
		//change building appearance
		cost *=2;
		output*=2;
		researchCost *=2;;
		
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
}
