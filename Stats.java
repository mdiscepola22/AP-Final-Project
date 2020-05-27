import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Stats {

	private ArrayList<Orchard> orchardList;
	private ArrayList<Factory> factoryList;
	private int lemonsProduced;
	private double totalMoney;
	private final int LEMON_PRICE;
	

	public Stats() {
		orchardList = new ArrayList<>();
		factoryList = new ArrayList<>();
		lemonsProduced = 0;
		totalMoney = 0;
		LEMON_PRICE = 4;
	}

	public void addOrchard(Orchard orchard) {
		orchardList.add(orchard);
	}
	public int getLemonsProduced() {
		return lemonsProduced;
	}
	
	public double getTotalMoney() {
		return totalMoney;
	}
	
	public void addFactory(Factory factory) {
		factoryList.add(factory);
	}
	

	public void startOrchardProduction() {

		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				for (Orchard o:orchardList) {
					lemonsProduced+= o.getOutput();
				}
				System.out.println("Lemons Produced: " + lemonsProduced);

			}
		}, 0, 1000);
	}
	
	public void startFactoryProduction() {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				for(Factory f: factoryList) {
					if(lemonsProduced >= f.getInput()) {
						totalMoney+=LEMON_PRICE;
						lemonsProduced-=f.getInput();
					}
				}
				System.out.println("Total Money: " + totalMoney);
			}
		}, 0, 1000);
	}
	
	public int getLPS() {
		int count = 0;
		for(Orchard o:orchardList) {
			count+=o.getOutput();
		}
		return count;
	}
	
	public int getJPS() {
		int count =0;
		for(Factory f:factoryList) {
			count+=f.getOutput();
		}
		return count;
	}
	
	public int getMPS() {
		int count = 0;
		for(Factory f:factoryList) {
			count+=f.getOutput();
		}
		return count * LEMON_PRICE;
	}
	
	


}

