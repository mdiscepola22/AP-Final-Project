import java.util.Timer;
import java.util.TimerTask;

public class Test {

	public static void main(String[] args) {
		
		Stats stats = new Stats();
		
		stats.startOrchardProduction();
		stats.startFactoryProduction();
		System.out.println("LPS: " + stats.getLPS());
		System.out.println("JPS: " + stats.getJPS());
		System.out.println("MPS: " + stats.getMPS());
		
		
		
	}

}
