import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Stats {

	private ArrayList<Orchard> orchardList;
	private ArrayList<Factory> factoryList;
	private int lemonsProduced;
	private int totalMoney;

	public Stats() {
		orchardList = new ArrayList<>();
		factoryList = new ArrayList<>();
		lemonsProduced = 0;
		totalMoney = 0;
	}

	public void addOrchard(Orchard orchard) {
		orchardList.add(orchard);
	}
	public int getLemonsProduced() {
		return lemonsProduced;
	}

	public void startOrchardProduction() {

		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				for (Orchard o:orchardList) {
					lemonsProduced+= o.getOutput();
				}
				System.out.println(lemonsProduced);

			}
		}, 0, 1000);
	}


}

