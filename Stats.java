import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Stats {

	private ArrayList<Orchard> orchardList;
	private ArrayList<Factory> factoryList;
	private int lemonsProduced;
	private double totalMoney;
	private final int LEMON_PRICE;
	private Research r1;
	private int totalResearch;
	

	public Stats() {
		orchardList = new ArrayList<>();
		factoryList = new ArrayList<>();
		lemonsProduced = 0;
		totalMoney = 0;
		LEMON_PRICE = 4;
		r1 = new Research();
		totalResearch = 0;
		addOrchard();
		addFactory();
	}

	public void addOrchard() {
		orchardList.add(new Orchard());
		totalMoney-=2000;
	}
	public int getLemonsProduced() {
		return lemonsProduced;
	}
	
	public double getTotalMoney() {
		return totalMoney;
		
	}
	
	public void addFactory() {
		factoryList.add(new Factory());
		totalMoney-=2000;
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
	
	public void startResearchProduction() {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				totalResearch+=r1.getOutput();
			}
		}, 0, 5000);
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
	
	public int getRPM() {
		return r1.getOutput()*12;
	}
	
	public void orchardUpgrade(Orchard orchard) {
		orchard.upgrade();
		totalMoney-=orchard.getCost();
		totalResearch-=orchard.getResearchCost();
	}
	
	public void factoryUpgrade(Factory factory) {
		factory.upgrade();
		totalMoney-=factory.getCost();
		totalResearch-=factory.getResearchCost();
	}
	
	


}

