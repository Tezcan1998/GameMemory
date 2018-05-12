import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import com.mysql.*;
import java.sql.*;
import java.util.ArrayList;
public class SignUp extends JFrame {

	private JPanel contentPane;
	private Main main;
	private JTextField textFieldName;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textFieldSurname;
	private JTextField textFieldMail;
	private JTextField textFieldCountry;
	private JPasswordField passwordFieldFirst;
	private JPasswordField passwordFieldSecond;
	private JTextField textFieldNick;
	private JTextField textFieldAge;
	private JComboBox comboBoxMailType;
	
	SignUp getReference()
	{
		return this;
	}
	
	@SuppressWarnings("deprecation")
	//TODO: configure the checkBoxes(), it will check all boxes if they are empty or not.
	boolean checkBoxes()
	{
		boolean boxesSituation=false;
		if(String.valueOf(textFieldName.getText()).equals("") ||  String.valueOf(textFieldMail.getText()).equals("") || String.valueOf(textFieldSurname.getText()).equals("") || String.valueOf(textFieldCountry.getText()).equals("") || String.valueOf(textFieldAge.getText()).equals("") || String.valueOf(textFieldNick.getText()).equals("") || String.valueOf(passwordFieldFirst.getPassword()).equals("") || String.valueOf(passwordFieldSecond.getPassword()).equals(""))
		{
			System.out.println("Yes null boxes");
			boxesSituation=false;
		}
		
		else
		{
			System.out.println("No null boxes...");
			if(String.valueOf(passwordFieldFirst.getPassword()).equals(String.valueOf(passwordFieldSecond.getPassword())))
			{
				System.out.println("Checked passwords...");
				boxesSituation=true;
			}
			else
			{
				System.out.println("everything okey");
				boxesSituation=false;
			}
		}
		
		
		return boxesSituation;
		
	}
	
	boolean RegisterInfo()
	{
		boolean situation=false;
		
		if(checkBoxes()==true)
		{
			
			if(String.valueOf(passwordFieldFirst.getPassword()).equals(String.valueOf(passwordFieldSecond.getPassword())))
			{
				
				try{
					
					Class.forName("org.sqlite.JDBC");
					Connection con=(Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Can\\eclipse-workspace\\MemoryGame\\SQLite\\gamedb.sqlite");
					System.out.println("Con Durum :"+con);
					Statement st=(Statement) con.createStatement();
					
					
		          String sql = "INSERT INTO players(UserNickname,UserPassword,UserName,UserSurname,UserAge,UserCountry,UserMail) "
		          		+ "VALUES ('"+textFieldNick.getText()+"','"+String.valueOf(passwordFieldFirst.getPassword())+"','"+textFieldName.getText()+"',"
		          				+ "'"+textFieldSurname.getText()+"','"+textFieldAge.getText()+"','"+textFieldCountry.getText()+"',"
		          						+ "'"+(textFieldMail.getText()+"@"+comboBoxMailType.getSelectedItem().toString())+"')";
		          st.executeUpdate(sql);
					
					
			            situation=true;
		            
		        	}
		        	catch(Exception e){
		             e.printStackTrace();
		        	}

			}
			
			
		}
		
		
		
		return situation;
		
	}
	
	
	
	void cleanUserAndPasswordBoxes()
	{
		
		if(this.main.getTextFieldUsername().getText().equals("") && String.valueOf(this.main.getPasswordFieldUser().getPassword()).equals(""))
		{
			
		}
		else
		{
			if(!(this.main.getTextFieldUsername().getText().equals("")))
			{
				System.out.println("User");
				this.main.getTextFieldUsername().setText("");
			}
			if(!(String.valueOf(this.main.getPasswordFieldUser().getPassword()).equals("")))
			{
				System.out.println("Password");
				this.main.getPasswordFieldUser().setText("");
			}
			
					
			
		}
		
		
		
		
	}
	
	
	public SignUp(Main main_) {
		this.main=main_;
		main.setVisible(false);
		
		//this.main.getTextFieldUsername().setText("");
		//this.main.getPasswordFieldUser().setText("");
		cleanUserAndPasswordBoxes();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 467, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setBounds(10, 11, 42, 27);
		panel.add(lblNewLabel);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(84, 14, 96, 20);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(RegisterInfo()==true)
				{
					JOptionPane.showMessageDialog(null, "Registered Successfully...");
					main.setVisible(true);
					getReference().setVisible(false);
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Registered Failed!!!.","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		btnRegister.setBounds(172, 171, 97, 33);
		panel.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				getReference().setVisible(false);
				JOptionPane.showMessageDialog(null, "Backing.....","Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnBack.setBounds(360, 209, 64, 41);
		panel.add(btnBack);
		
		
		
		JLabel lblSurname = new JLabel("Surname :");
		lblSurname.setBounds(10, 49, 64, 27);
		panel.add(lblSurname);
		
		JLabel lblGmail = new JLabel("Mail:");
		lblGmail.setBounds(212, 11, 30, 27);
		panel.add(lblGmail);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(84, 52, 96, 20);
		panel.add(textFieldSurname);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(240, 14, 86, 20);
		panel.add(textFieldMail);
		
		String mailtype[]= {"hotmail.com","gmail.com","yahoo.com"};
		
		comboBoxMailType = new JComboBox(mailtype);
		
		comboBoxMailType.setBounds(356, 14, 86, 20);
		
		panel.add(comboBoxMailType);
		
		JLabel label = new JLabel("@");
		label.setBounds(336, 11, 21, 27);
		panel.add(label);
		
		textFieldCountry = new JTextField();
		textFieldCountry.setColumns(10);
		textFieldCountry.setBounds(280, 52, 96, 20);
		panel.add(textFieldCountry);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setBounds(202, 49, 49, 27);
		panel.add(lblCountry);
		
		passwordFieldFirst = new JPasswordField();
		passwordFieldFirst.setBounds(84, 127, 96, 20);
		panel.add(passwordFieldFirst);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 127, 64, 20);
		panel.add(lblPassword);
		
		JLabel lblPassword_1 = new JLabel("Re-Password:");
		lblPassword_1.setBounds(190, 127, 97, 21);
		panel.add(lblPassword_1);
		
		passwordFieldSecond = new JPasswordField();
		passwordFieldSecond.setBounds(280, 127, 96, 20);
		panel.add(passwordFieldSecond);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setBounds(198, 90, 71, 20);
		panel.add(lblNickname);
		
		textFieldNick = new JTextField();
		textFieldNick.setColumns(10);
		textFieldNick.setBounds(280, 90, 96, 20);
		panel.add(textFieldNick);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(84, 90, 96, 20);
		panel.add(textFieldAge);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(10, 87, 42, 27);
		panel.add(lblAge);
		
		
	}
}
