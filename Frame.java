import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame{
	
	public Frame(){
		
		final Stats stats = new Stats();
		stats.startProduction();
		stats.startResearchProduction();
		
		setLayout(null);
		setResizable(false);
		setSize(1920,1080);
		setLocation(0,0);
		setTitle("Juice Tycoon");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		
		JPanel menu = new JPanel();
		menu.setSize(400, 1080);
		menu.setLocation(1521, 0);
		menu.setLayout(null);
		
		JPanel pics = new JPanel();
		pics.setSize(1520, 1080);
		pics.setLocation(0, 0);
		pics.setLayout(null);
		
		final JLabel totalMoney = new JLabel("total money");
		totalMoney.setSize(360, 52);
		totalMoney.setFont(new Font("Courier", Font.BOLD, 48));
		totalMoney.setLocation(20, 20);
		totalMoney.setVisible(true);
		menu.add(totalMoney);
		
		final JLabel mps = new JLabel("mps");
		mps.setSize(360, 34);
		mps.setFont(new Font("Courier", Font.PLAIN, 30));
		mps.setLocation(20, 100);
		mps.setVisible(true);
		menu.add(mps);
		
		final JLabel lps = new JLabel("lps");
		lps.setSize(360, 34);
		lps.setFont(new Font("Courier", Font.PLAIN, 30));
		lps.setLocation(20, 160);
		lps.setVisible(true);
		menu.add(lps);
		
		final JLabel jps = new JLabel("jps");
		jps.setSize(360, 34);
		jps.setFont(new Font("Courier", Font.PLAIN, 30));
		jps.setLocation(20, 220);
		jps.setVisible(true);
		menu.add(jps);
		
		final JLabel rpm = new JLabel("rpm");
		rpm.setSize(360, 46);
		rpm.setFont(new Font("Courier", Font.PLAIN, 40));
		rpm.setLocation(20, 280);
		rpm.setVisible(true);
		menu.add(rpm);
		
		
		JButton buyFac = new JButton("Buy a Factory for $2000");
		buyFac.setSize(360, 60);
		buyFac.setLocation(20, 360);
		buyFac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				stats.addFactory();
			}
		});
		menu.add(buyFac);
		
		
		JButton buyOrc = new JButton("Buy an Orchard for $2000");
		buyOrc.setSize(360, 60);
		buyOrc.setLocation(20, 450);
		buyOrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				stats.addOrchard();
			}
		});
		menu.add(buyOrc);
		
		
		final JComboBox<String> facUpgrade = new JComboBox<String>();
		facUpgrade.setSize(118, 40);
		facUpgrade.setLocation(20, 560);
		facUpgrade.addItem("Choose Factory");
		menu.add(facUpgrade);
		
		JButton upgradeFac = new JButton("Upgrade Factory");
		upgradeFac.setSize(230, 60);
		upgradeFac.setLocation(150, 550);
		upgradeFac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(facUpgrade.getSelectedIndex() != 0)
					stats.factoryUpgrade(Integer.parseInt((String) facUpgrade.getSelectedItem()));
			}
		});
		menu.add(upgradeFac);
		
		
		final JComboBox<String> orcUpgrade = new JComboBox<String>();
		orcUpgrade.setSize(118, 40);
		orcUpgrade.setLocation(20, 650);
		orcUpgrade.addItem("Choose Orchard");
		menu.add(orcUpgrade);
		
		JButton upgradeOrc = new JButton("Upgrade Orchard");
		upgradeOrc.setSize(230, 60);
		upgradeOrc.setLocation(150, 640);
		upgradeOrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(orcUpgrade.getSelectedIndex() != 0)
					stats.orchardUpgrade(Integer.parseInt((String) orcUpgrade.getSelectedItem()));
			}
		});
		menu.add(upgradeOrc);
		
		
		
		
		
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				totalMoney.setText("$" + stats.getTotalMoney());
				mps.setText("$" + stats.getMPS() + " /s");
				lps.setText(stats.getLPS() + " lemons/s");
				jps.setText(stats.getJPS() + " juice/s");
				rpm.setText(stats.getRPM() + " research/m");
				
				
				if(facUpgrade.getItemCount() < stats.getNumFactories() + 1)
				{
					facUpgrade.addItem("" + stats.getNumFactories());
				}
				
				if(orcUpgrade.getItemCount() < stats.getNumOrchards() + 1)
				{
					orcUpgrade.addItem("" + stats.getNumOrchards());
				}

			}
		}, 5, 100);
		
		
		menu.setVisible(true);
		pics.setVisible(true);
		add(menu);
		add(pics);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Frame();
	}

}
