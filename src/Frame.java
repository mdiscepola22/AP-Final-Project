import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		pics.setSize(1920, 1080);
		pics.setLocation(0, 0);
		pics.setLayout(null);
		
		
		
		
		Image scalefactory = new ImageIcon("./factory1.png").getImage().getScaledInstance(228, 184, Image.SCALE_SMOOTH);
		ImageIcon factory1 = new ImageIcon(scalefactory);
		JLabel f1 = new JLabel(factory1);
		f1.setSize(1490,1080);
		f1.setLocation(360,-109);
		add(f1);
		
		ImageIcon factory2 = new ImageIcon(scalefactory);
		JLabel f2 = new JLabel(factory2);
		f2.setSize(1490,1080);
		f2.setLocation(513,-23);
		add(f2);
		
		ImageIcon factory3 = new ImageIcon(scalefactory);
		JLabel f3 = new JLabel(factory3);
		f3.setSize(1490,1080);
		f3.setLocation(190,-13);
		add(f3);
		
		ImageIcon factory4 = new ImageIcon(scalefactory);
		JLabel f4 = new JLabel(factory4);
		f4.setSize(1490,1080);
		f4.setLocation(343,79);
		add(f4);
		
		
		
		
		Image scaleOrchard = new ImageIcon("./orchard1.png").getImage().getScaledInstance(228, 184, Image.SCALE_SMOOTH);
		ImageIcon orchard1 = new ImageIcon(scaleOrchard);
		JLabel o1 = new JLabel(orchard1);
		o1.setSize(228,184);
		o1.setLocation(619,122);
		add(o1);
		
		ImageIcon orchard2 = new ImageIcon(scaleOrchard);
		JLabel o2 = new JLabel(orchard2);
		o2.setSize(228, 184);
		o2.setLocation(770,208);
		add(o2);
		
		ImageIcon orchard3 = new ImageIcon(scaleOrchard);
		JLabel o3 = new JLabel(orchard3);
		o3.setSize(228,184);
		o3.setLocation(449,224);
		add(o3);
		
		ImageIcon orchard4 = new ImageIcon(scaleOrchard);
		JLabel o4 = new JLabel(orchard4);
		o4.setSize(228, 184);
		o4.setLocation(605,311);
		add(o4);
		
		ImageIcon orchard5 = new ImageIcon(scaleOrchard);
		JLabel o5 = new JLabel(orchard5);
		o5.setSize(228, 184);
		o5.setLocation(279,322);
		add(o5);
		
		ImageIcon orchard6 = new ImageIcon(scaleOrchard);
		JLabel o6 = new JLabel(orchard6);
		o6.setSize(228, 184);
		o6.setLocation(429,405);
		add(o6);
		
		ImageIcon orchard7 = new ImageIcon(scaleOrchard);
		JLabel o7 = new JLabel(orchard7);
		o7.setSize(228,184);
		o7.setLocation(105,415);
		add(o7);
		
		ImageIcon orchard8 = new ImageIcon(scaleOrchard);
		JLabel o8 = new JLabel(orchard8);
		o8.setSize(228,184);
		o8.setLocation(259,507);
		add(o8);
		
		
		
		
		ImageIcon base = new ImageIcon("./BaseMap.png");
		Image scalebase = base.getImage().getScaledInstance(1520, 811,Image.SCALE_SMOOTH);
		base = new ImageIcon(scalebase);
		JLabel base1 = new JLabel(base);
		base1.setSize(1490,1080);
		base1.setLocation(0,0);
		add(base1);
		
		
		
		
		
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
				try
				{
					stats.factoryUpgrade(Integer.parseInt((String) facUpgrade.getSelectedItem()));
					
				}
				catch(IllegalArgumentException x) {}
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
				try
				{
					stats.orchardUpgrade(Integer.parseInt((String) orcUpgrade.getSelectedItem()));
				}
				catch(IllegalArgumentException x) {}
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
		}, 0, 100);
		
		
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

