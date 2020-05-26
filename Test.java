import java.util.Timer;
import java.util.TimerTask;

public class Test {

	public static void main(String[] args) {
		Orchard orchard = new Orchard();
		Stats stats = new Stats();
		stats.addOrchard(orchard);
		stats.startOrchardProduction();
		Factory factory = new Factory();
		stats.addFactory(factory);
		stats.startFactoryProduction();
		
		
		
	}

}
