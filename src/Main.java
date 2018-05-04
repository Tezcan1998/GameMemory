import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldUser;
	private boolean status=false;
	private JCheckBox checkBoxAdmin;
	
	Main getReference()
	{
		return this;
	}
	
	
	
	public int connectStudentDB(String nickname,String password){
		int id=-1;
    	try{
    		Class.forName("org.sqlite.JDBC");
            
            Connection con=(Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ASUS\\workspace\\GameMemory\\SQLite\\gamedb.sqlite");
            Statement st=(Statement) con.createStatement();
            String sql = ("select * from users;");
            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()) {
	            	if(nickname.equals(rs.getString("UserNickname")) && password.equals(rs.getString("UserPassword")))
	            	{
	            		
	                    this.status=true;
	                    id= rs.getInt("UserId");
	                    break;
	                    
	            	}
	            	
	            }
            
        	}
        	catch(Exception e){
             e.printStackTrace();
        	}
		return id;

    }
	
	public int connectAdminDB(String nickname,String password){
		int id=-1;
    	try{
    		Class.forName("org.sqlite.JDBC");
           
            Connection con=(Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ASUS\\workspace\\GameMemory\\SQLite\\gamedb.sqlite");
            Statement st=(Statement) con.createStatement();
            String sql = ("select * from admins;");
            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()) {
	            	if(nickname.equals(rs.getString("AdminNickname")) && password.equals(rs.getString("AdminPassword")))
	            	{
	            		
	                    this.status=true;
	                    id= rs.getInt("AdminId");
	                    break;
	                    
	            	}
	            	
	            }
            
        	}
        	catch(Exception e){
             e.printStackTrace();
        	}
		return id;

    }
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		setTextFieldUsername(new JTextField());
		getTextFieldUsername().setBounds(201, 86, 132, 25);
		panel.add(getTextFieldUsername());
		getTextFieldUsername().setColumns(10);
		
		setPasswordFieldUser(new JPasswordField());
		getPasswordFieldUser().setBounds(201, 122, 132, 25);
		panel.add(getPasswordFieldUser());
		
		JButton btnNewButton = new JButton("Log-in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	System.out.println(textFieldUsername.getText()+"   "+String.valueOf(passwordFieldUser.getPassword()));
				int tempId;
				
				if(checkBoxAdmin.isSelected())
				{
					tempId=connectAdminDB(getTextFieldUsername().getText(),String.valueOf(getPasswordFieldUser().getPassword()));
					if(tempId!=-1)
					{
						JOptionPane.showMessageDialog(null,"Access Successfull");
						AdminPage mainpage=new AdminPage(getReference(),tempId);
						mainpage.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Unseccessfull Login","Access Denied",JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
				    tempId=connectStudentDB(getTextFieldUsername().getText(),String.valueOf(getPasswordFieldUser().getPassword()));
					if(tempId!=-1)
					{
						JOptionPane.showMessageDialog(null,"Access Successfull");
						Logined mainpage = null;
						try {
							mainpage = new Logined(getReference(),tempId);
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						mainpage.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Unseccessfull Login","Access Denied",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(115, 183, 102, 33);
		panel.add(btnNewButton);
		
		JButton button = new JButton("Sign-up");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp newsignup=new SignUp(getReference());
				newsignup.setVisible(true);
			}
		});
		button.setBounds(231, 183, 102, 33);
		panel.add(button);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(115, 86, 76, 20);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(115, 122, 76, 20);
		panel.add(lblPassword);
		
		checkBoxAdmin = new JCheckBox("Admin");
		checkBoxAdmin.setBounds(178, 153, 97, 23);
		panel.add(checkBoxAdmin);
	}



	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}



	public void setTextFieldUsername(JTextField textFieldUsername) {
		this.textFieldUsername = textFieldUsername;
	}



	public JPasswordField getPasswordFieldUser() {
		return passwordFieldUser;
	}



	public void setPasswordFieldUser(JPasswordField passwordFieldUser) {
		this.passwordFieldUser = passwordFieldUser;
	}
}
