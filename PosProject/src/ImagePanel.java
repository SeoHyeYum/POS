import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

class BackgroundImagePanel extends JPanel{
	private Image img;
	
	public BackgroundImagePanel(Image img){
		this.img=img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));//넓이 높이 최대값 지정
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
	public void paintComponent(Graphics g){
		g.drawImage(img,0,0,null);
	}
}