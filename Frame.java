import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
	
	public Frame(){
		setResizable(false);
		setSize(1920,1080);
		setLocation(0,0);
		setTitle("Juice Tycoon");
		
		JPanel menu = new JPanel();
		menu.setSize(width, 1080);
	}

	public static void main(String[] args) {
		new Frame();

	}

}
