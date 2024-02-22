import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PrizeUI2{
	private JFrame frame;
	private String btnImage = ".\\image\\";
	private BackgroundImagePanel prizePanel=new BackgroundImagePanel(new ImageIcon(".\\image\\prizeUI.jpg").getImage());//��ǰ �̹���	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrizeUI2 window = new PrizeUI2();		
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PrizeUI2(){
		initialize();	
	}
	
	private void initialize(){
		frame=new JFrame();	
		frame.setSize(1280,800);
		frame.setTitle("Pos");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(prizePanel);//��ǰ �̹��� �г� �߰�
		
		prizePanel.setLayout(null);
		prizePanel.setBounds(0, 0, 1280, 800);
	}
	
	public void setVisible(boolean b) {
		// TODO �ڵ� ������ �޼ҵ� ����
		frame.setVisible(b);	
	}
}
