public class Factory {
	private int cost;
	private int input;
	private int output;
	private int researchCost;
	private static int totalJuice = 0;

	public Factory() {
		 cost = 2000;
		input = 8;
		output = 1;
		researchCost = 2;
	}

	public void upgrade() {
		//change building appearance
		output+=2;
		cost*=2;
		researchCost *=2;
	}



	public static int getTotalJuice() {
		return totalJuice;
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
}



