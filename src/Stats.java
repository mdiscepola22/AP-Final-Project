

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.Timer;
	import java.util.TimerTask;

	public class Stats {

		private ArrayList<Orchard> orchardList;
		private ArrayList<Factory> factoryList;
		private int lemonsProduced;
		private int totalMoney;
		private final int LEMON_PRICE;
		private Research r1;
		private int totalResearch;
		

		public Stats() {
			orchardList = new ArrayList<>();
			factoryList = new ArrayList<>();
			lemonsProduced = 0;
			totalMoney = 0;
			LEMON_PRICE = 1000;
			r1 = new Research();
			totalResearch = 0;
			orchardList.add(new Orchard());
			factoryList.add(new Factory());
		}

		public void addOrchard() {
			if(orchardList.size()<8) {
			orchardList.add(new Orchard());
			totalMoney-=2000;
			}
		}
		public int getLemonsProduced() {
			return lemonsProduced;
		}
		
		public int getTotalMoney() {
			return totalMoney;
		}
		
		public void addFactory() {
			if(factoryList.size() < 4) {
			factoryList.add(new Factory());
			totalMoney-=2000;
			}
		}
		
		public int getNumFactories() {
			return factoryList.size();
		}
		public int getNumOrchards() {
			return orchardList.size();
		}
		
		public void updateStats() {
			for (Orchard o:orchardList) {
				lemonsProduced+= o.getOutput();
			}
			System.out.println("Lemons Produced: " + lemonsProduced);
			for(Factory f: factoryList) {
				lemonsProduced=Math.max(lemonsProduced-f.getInput(), 0);
			}
			totalMoney+=LEMON_PRICE*getJPS();
			System.out.println("Total Money: " + totalMoney);
		}
		
		public void startProduction() {
			Timer t = new Timer();
			t.schedule(new TimerTask() {
				@Override
				public void run() {
					updateStats();
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
		class SortFactoryList implements Comparator<Factory> {
			public int compare(Factory a, Factory b) {
				return a.getOutput()-b.getOutput();
			}
		}
		
		public double getJPS() {
			double juiceProduced = 0;
			int lemonsRemaining = getLPS();
			Collections.sort(factoryList, new SortFactoryList());
			Collections.reverse(factoryList);

			for(int i=0;i<factoryList.size();i++) {
				juiceProduced+=(double)factoryList.get(i).getOutput()*Math.min(((double)lemonsRemaining/60.0),1);
				lemonsRemaining=Math.max(lemonsRemaining-factoryList.get(i).getInput(), 0);
			}
			return juiceProduced;
		}
		
		public double getMPS() {
			return (getJPS() * LEMON_PRICE);
			
		}
		
		public int getRPM() {
			return r1.getOutput()*12;
		}
		
		public void orchardUpgrade(int index) {
			if(totalMoney - orchardList.get(index).getCost() >= 0 && orchardList.get(index).getLevel() < 4)
			{
				orchardList.get(index).upgrade();
				totalMoney-=orchardList.get(index).getCost();
				totalResearch-=orchardList.get(index).getResearchCost();
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
		
		public void factoryUpgrade(int index) {
			if(totalMoney - factoryList.get(index).getCost() >= 0 && factoryList.get(index).getLevel() < 4)
			{
				factoryList.get(index).upgrade();
				totalMoney-=factoryList.get(index).getCost();
				totalResearch-=factoryList.get(index).getResearchCost();
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
		
		
		public ArrayList<Factory> getFactoryList()
		{
			return factoryList;
		}
		
		public ArrayList<Orchard> getOrchardsList()
		{
			return orchardList;
		}


	}


