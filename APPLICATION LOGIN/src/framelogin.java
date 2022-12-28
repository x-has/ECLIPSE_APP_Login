import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class framelogin extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img_logo = new ImageIcon(framelogin.class.getResource("res/PUB2 Original size.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_Username = new ImageIcon(framelogin.class.getResource("res/Picons8-male-user-100.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_password = new ImageIcon(framelogin.class.getResource("res/password.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_login = new ImageIcon(framelogin.class.getResource("res/Login100.png")).getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framelogin frame = new framelogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public framelogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(175, 146, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 11, 170, 20);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUsername.setBounds(210, 0, 40, 40);
		lblIconUsername.setIcon(new ImageIcon(img_Username));
		panel_1.add(lblIconUsername);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(175, 191, 250, 40);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		txtpassword = new JPasswordField();
		txtpassword.setBorder(null);
		txtpassword.setFont(new Font("Arial", Font.PLAIN, 12));
		txtpassword.setText("Password");
		txtpassword.setBounds(10, 11, 170, 20);
		panel_1_1.add(txtpassword);
		
		JLabel lblIconpassword = new JLabel("");
		lblIconpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconpassword.setBounds(210, 0, 40, 40);
		lblIconpassword.setIcon(new ImageIcon(img_password));
		panel_1_1.add(lblIconpassword);
		
		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.setBackground(new Color(95, 158, 160));
		pnlBtnLogin.setBounds(175, 253, 250, 60);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(62, 11, 122, 38);
		pnlBtnLogin.add(lblNewLabel);
		
		JLabel lblIconLogin = new JLabel("");
		lblIconLogin.setBounds(35, 11, 54, 39);
		lblIconLogin.setIcon(new ImageIcon(img_login));
		pnlBtnLogin.add(lblIconLogin);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				if(JOptionPane.showConfirmDialog(null, "are you sure you want to close this app ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					framelogin.this.dispose();
				}
			}
		});
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(580, 0, 20, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(232, 33, 125, 102);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		setLocationRelativeTo(null);
	
	}
	
	public static class Mysql_connection {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			try{  
				   Class.forName("com.mysql.cj.jdbc.Driver");
				    
				   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","Y1012JqKhKp2");  

				   Statement stmt=con.createStatement();
				    
				   ResultSet rs=stmt.executeQuery("select * from abonne"); 

				   while(rs.next())  
				    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				     
				   con.close();  
				   
				   }catch(Exception e){
				    System.out.println(e);
				   }
			

		}

}
}