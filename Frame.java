import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame{
	
	public Frame(){
		
		Stats stats = new Stats();
		
		setLayout(null);
		setResizable(false);
		setSize(1920,1080);
		setLocation(0,0);
		setTitle("Juice Tycoon");
		
		JPanel menu = new JPanel();
		menu.setSize(400, 1080);
		menu.setLocation(1521, 0);
		
		JPanel pics = new JPanel();
		pics.setSize(1520, 1080);
		pics.setLocation(0, 0);
		
		JLabel totalMoney = new JLabel();
		totalMoney.setSize(360, 50);
		totalMoney.setFont(new Font("Courier", Font.BOLD, 48));
		totalMoney.setLocation(20, 20);
		totalMoney.setVisible(true);
		menu.add(totalMoney);
		
		JLabel mps = new JLabel();
		mps.setSize(360, 25);
		mps.setFont(new Font("Courier", Font.PLAIN, 23));
		mps.setLocation(20, 100);
		mps.setVisible(true);
		menu.add(mps);
		
		JLabel lps = new JLabel();
		lps.setSize(360, 35);
		lps.setFont(new Font("Courier", Font.PLAIN, 33));
		lps.setLocation(20, 165);
		lps.setVisible(true);
		menu.add(lps);
		
		JLabel jps = new JLabel();
		jps.setSize(360, 35);
		jps.setFont(new Font("Courier", Font.PLAIN, 33));
		jps.setLocation(20, 230);
		jps.setVisible(true);
		menu.add(jps);
		
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				totalMoney.setText("$" + stats.getMoney());
				mps.setText("$" + stats.getMPS() + " /s");
				lps.setText(stats.getLPS() + "lemons/s");
				jps.setText(stats.getJPS() + "juice/s");

			}
		}, 0, 1000);
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		new Frame();
	}

}
