package plane1;


import javax.swing.JFrame;

public class PlaneFrame extends JFrame{
	public PlaneFrame() {
		PlanePanel p = new PlanePanel();
		this.setContentPane(p);
		this.setVisible(true);
		this.setSize(PlanePanel.Width, PlanePanel.Height);
		this.setIconImage(PlanePanel.icon);
		this.setResizable(false);
		this.setTitle("飞机大战");
		this.setLocationRelativeTo(null);//将位置居中
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(p);
		p.GO();
	}
	public static void main(String[] args) {
		new PlaneFrame();
	}
}
