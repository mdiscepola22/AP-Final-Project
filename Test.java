import java.util.Timer;
import java.util.TimerTask;

public class Test {

	public static void main(String[] args) {
		Orchard orchard = new Orchard();
		Orchard o2 = new Orchard();
		Stats stats = new Stats();
		stats.addOrchard(orchard);
		stats.addOrchard(orchard);
		stats.startOrchardProduction();
		Factory factory = new Factory();
		Factory f2 = new Factory();
		stats.addFactory(f2);
		stats.addFactory(factory);
		stats.startFactoryProduction();
		System.out.println("LPS: " + stats.getLPS());
		System.out.println("JPS: " + stats.getJPS());
		System.out.println("MPS: " + stats.getMPS());
		
		
		
	}

}
