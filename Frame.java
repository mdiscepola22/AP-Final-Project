import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame{
	
	public Frame(){
		setResizable(false);
		setSize(1920,1080);
		setLocation(0,0);
		setTitle("Juice Tycoon");
		
		JPanel menu = new JPanel();
		menu.setSize(400, 1080);
		
		JLabel totalMoney = new JLabel();
		totalMoney.setSize(360, 50);
		totalMoney.setFont(new Font("Courier", Font.PLAIN, 48));
		
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				totalMoney.setText(text);

			}
		}, 0, 1000);
		
		
		
	}

	public static void main(String[] args) {
		new Frame();
	}

}
