import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FinalPayUI {
	private JFrame frame;
	private String btnImage = ".\\image\\";
	private BackgroundImagePanel finalPayUIPanel=new BackgroundImagePanel(new ImageIcon(".\\image\\finalPayUI.jpg").getImage());//최종 결제 이미지	
	private String toEmail;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalPayUI window = new  FinalPayUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FinalPayUI(){
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
		frame.add(finalPayUIPanel);
	
		finalPayUIPanel.setLayout(null);
		finalPayUIPanel.setBounds(0, 0, 1280, 800);
			
		JButton backButton = new JButton();
		backButton.setIcon(new ImageIcon(btnImage+"backButton.png"));
		backButton.setBounds(20, 32, 54, 33);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);	 
		finalPayUIPanel.add(backButton);
		
		backButton.addActionListener(new ActionListener() {//뒤로가기 버튼 누를시
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				//결제 페이지로 이동
			}
		});			
		
		JTextField emailTextField = new JTextField();
		emailTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		emailTextField.setBounds(216, 381, 323, 34);
		finalPayUIPanel.add(emailTextField);
		emailTextField.setColumns(10);
		
		JButton payButton = new JButton();
		payButton.setIcon(new ImageIcon(btnImage+"pay.jpg"));
		payButton.setRolloverIcon(new ImageIcon(btnImage+"pay2.jpg"));
		payButton.setBounds(73, 650, 738, 75);
		finalPayUIPanel.add(payButton);
	
		payButton.addActionListener(new ActionListener() {//결제하기 버튼 누를시
			public void actionPerformed(ActionEvent e) {
				PaySystem pay=new PaySystem();
				toEmail=emailTextField.getText();
				
				System.out.println(toEmail);
				int i=0;
				   if(toEmail.length()!=i){
					   pay.getPayMentEmail(toEmail);
					   //결재내역 화면으로 이동
					   }
				   else{
					 //결재내역 화면으로 이동
				   }           	
			}
		});			
	}	
}



	
