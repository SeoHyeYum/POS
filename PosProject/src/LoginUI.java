import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class LoginUI {	
	private JFrame frame;
	private String btnImage = ".\\image\\";
	private BackgroundImagePanel loginPanel=new BackgroundImagePanel(new ImageIcon(".\\image\\loginUI.jpg").getImage());//로그인 이미지	
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LoginUI() { 
		initialize();
	   }
	
	private void initialize(){				
		frame =new JFrame();	
		frame.setTitle("Pos");      
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(loginPanel);//로그인 이미지 패널 추가
		
		loginPanel.setLayout(null);
		loginPanel.setBounds(0, 0, 400, 400);
		
	    JLabel passwordLabel=new JLabel("Password");
	    loginPanel.add(passwordLabel);//패스워드 라벨 추가
	    passwordLabel.setForeground(Color.LIGHT_GRAY);
	    passwordLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
	    passwordLabel.setBounds(50,179, 72, 25);
	       
	    JPasswordField passwordTextField = new JPasswordField(10);
	    loginPanel.add(passwordTextField);//패스워드 텍스트필드 추가
	    passwordTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
	    passwordTextField.setBounds(142, 180, 110, 25);
	    
	    JButton loginButton = new JButton();
	    loginPanel.add(loginButton);//로그인 버튼 추가
	    loginButton.setBounds(272, 180, 45, 24);
	    loginButton.setBackground(Color.WHITE);
	    loginButton.setRolloverIcon(new ImageIcon(btnImage+"loginbutton2.jpg"));
	    loginButton.setIcon(new ImageIcon(btnImage+"loginButton.jpg"));
	    loginButton.setBorderPainted(true);
	             
	    loginButton.addActionListener(new ActionListener() {//로그인 이벤트 발생	  
				public void actionPerformed(ActionEvent e) {
					LoginSystem db=new LoginSystem();
					String password = new String(passwordTextField.getPassword());
				
					try {
						if(db.checkPw(password)){
							System.out.println(db.checkPw(password));
							frame.setVisible(false);
							new MainUI();
						}
						else{
						 JOptionPane.showMessageDialog(null,"비밀번호가 잘못됐습니다.","Password Error",JOptionPane.ERROR_MESSAGE);
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		         }
		      });    
	}
	
}
