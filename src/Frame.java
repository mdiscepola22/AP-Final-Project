import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ComboBoxModel;
import javax.swing.Icon;
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
		
		
		final ArrayList<Image> facs = new ArrayList<Image>();
		final ArrayList<Image> orcs = new ArrayList<Image>();
		
		
		
		Image imageFac1 = new ImageIcon("./factory1.png").getImage().getScaledInstance(228, 184, Image.SCALE_SMOOTH);
		Image imageFac2 = new ImageIcon("./factory2.png").getImage().getScaledInstance(228, 184, Image.SCALE_SMOOTH);
		Image imageFac3 = new ImageIcon("./factory3.png").getImage().getScaledInstance(228, 184, Image.SCALE_SMOOTH);
		Image imageFac4 = new ImageIcon("./factory4.png").getImage().getScaledInstance(228, 184, Image.SCALE_SMOOTH);
		
		Image imageOrc1 = new ImageIcon("./orchard1.png").getImage().getScaledInstance(228, 184, Image.SCALE_SMOOTH);
		Image imageOrc2 = new ImageIcon("./orchard2.png").getImage().getScaledInstance(228, 184, Image.SCALE_SMOOTH);
		Image imageOrc3 = new ImageIcon("./orchard3.png").getImage().getScaledInstance(228, 184, Image.SCALE_SMOOTH);
		Image imageOrc4 = new ImageIcon("./orchard4.png").getImage().getScaledInstance(228, 184, Image.SCALE_SMOOTH);
		
		
		facs.add(imageFac1);
		facs.add(imageFac2);
		facs.add(imageFac3);
		facs.add(imageFac4);
		
		orcs.add(imageOrc1);
		orcs.add(imageOrc2);
		orcs.add(imageOrc3);
		orcs.add(imageOrc4);
		
		
		
		final ArrayList<JLabel> factories = new ArrayList<JLabel>();
		final ArrayList<JLabel> orchards = new ArrayList<JLabel>();
		
		
		for(int i = 0; i < 4; i++)
		{
			factories.add(new JLabel(new ImageIcon(imageFac1)));
			factories.get(i).setSize(1490,1080);
			add(factories.get(i));
		}
		
		for(int i = 0; i < 8; i++)
		{
			orchards.add(new JLabel(new ImageIcon(imageOrc1)));
			orchards.get(i).setSize(228,184);
			add(orchards.get(i));
		}
		
		
		
		factories.get(0).setLocation(360,-109);
		factories.get(1).setLocation(513,-23);
		factories.get(2).setLocation(190,-13);
		factories.get(3).setLocation(343,79);
		
		
		orchards.get(0).setLocation(619,122);
		orchards.get(1).setLocation(770,208);
		orchards.get(2).setLocation(449,224);
		orchards.get(3).setLocation(605,311);
		orchards.get(4).setLocation(279,322);
		orchards.get(5).setLocation(429,405);
		orchards.get(6).setLocation(105,415);
		orchards.get(7).setLocation(259,507);
		
		
		
		
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
					stats.factoryUpgrade(Integer.parseInt((String) facUpgrade.getSelectedItem()) - 1);
					//factories.get(Integer.parseInt((String) facUpgrade.getSelectedItem()) - 1).setIcon();
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
					stats.orchardUpgrade(Integer.parseInt((String) orcUpgrade.getSelectedItem()) - 1);
					//orchards.get(Integer.parseInt((String) orcUpgrade.getSelectedItem()) - 1).setIcon();
				}
				catch(IllegalArgumentException x) {}
			}
		});
		menu.add(upgradeOrc);
		
		
		JLabel rules = new JLabel("Max factories is 4, max orchards is 8. Level 2 upgrade costs $4k and 2 research. Level 3 upgrade costs $8k and 4 research. Level 4 upgrade costs $16k and 8 research.");
		rules.setSize(1920, 25);
		rules.setFont(new Font("Courier", Font.PLAIN, 19));
		rules.setLocation(55, 1050);
		rules.setVisible(true);
		add(rules);
		
		
		
		
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

