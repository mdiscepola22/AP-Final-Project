import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Stats {

	private ArrayList<Orchard> orchardList;
	private ArrayList<Factory> factoryList;
	private int lemonsProduced;
	private double totalMoney;
	private int timerDelay;

	public Stats() {
		orchardList = new ArrayList<>();
		factoryList = new ArrayList<>();
		lemonsProduced = 0;
		totalMoney = 0;
		timerDelay = 5000;
	}

	public void addOrchard(Orchard orchard) {
		orchardList.add(orchard);
	}
	public int getLemonsProduced() {
		return lemonsProduced;
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
						totalMoney+=4;
						lemonsProduced-=f.getInput();
					}
				}
				System.out.println("Total Money: " + totalMoney);
			}
		}, 0, 1000);
	}


}

