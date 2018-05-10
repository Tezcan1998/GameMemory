import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminPage extends JFrame {

	private JPanel contentPane;

	private Main main;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldNickname;
	private JTextField textFieldPasswod;
	private JTextField textFieldAge;
	private JTextField textFieldMail;
	private JLabel lblDisplayedName;
	private User user;
	
	
	public void updateProfilInfo() throws SQLException, ClassNotFoundException {
		
    	lblDisplayedName.setText(user.getName());
    	lblDisplayedNickname.setText(user.getNickname());
    	lblDisplayedSurname.setText(user.getSurname());
    	lblDisplayedAge.setText(Integer.toString(user.getAge()));
    	lblDisplayedCountry.setText(user.getCountry());
    	lblDisplayedMail.setText(user.getMail());

    	textFieldName.setText(rs.getString("UserName"));
    	textFieldNickname.setText(rs.getString("UserNickName"));
    	textFieldSurname.setText(rs.getString("UserSurname"));
    	textFieldAge.setText(Integer.toString(rs.getInt("UserAge")));
    	textFieldCountry.setText(rs.getString("UserCountry"));
    	textFieldMail.setText(rs.getString("UserMail"));



}

public void updateChanges()
{
//elleme
}

	
	
	public AdminPage(Main _main, User user) {
		this.user=user;
		this.main=_main;
		main.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 261);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Profil", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Name :");
		label.setBounds(10, 11, 45, 21);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Nickname :");
		label_1.setBounds(10, 43, 60, 21);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Country :");
		label_2.setBounds(10, 75, 60, 21);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Surname  :");
		label_3.setBounds(216, 11, 66, 21);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Age :");
		label_4.setBounds(216, 43, 45, 21);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Mail :");
		label_5.setBounds(216, 75, 45, 21);
		panel_1.add(label_5);
		
		lblDisplayedName = new JLabel("");
		lblDisplayedName.setBounds(65, 14, 60, 14);
		panel_1.add(lblDisplayedName);
		
		JLabel lblDisplayedNickname = new JLabel("");
		lblDisplayedNickname.setBounds(65, 46, 60, 14);
		panel_1.add(lblDisplayedNickname);
		
		JLabel lblDisplayedCountry = new JLabel("");
		lblDisplayedCountry.setBounds(65, 78, 60, 14);
		panel_1.add(lblDisplayedCountry);
		
		JLabel lblDisplayedSurname = new JLabel("");
		lblDisplayedSurname.setBounds(274, 14, 60, 14);
		panel_1.add(lblDisplayedSurname);
		
		JLabel lblDisplayedAge = new JLabel("");
		lblDisplayedAge.setBounds(271, 50, 60, 14);
		panel_1.add(lblDisplayedAge);
		
		JLabel lblDisplayedMail = new JLabel("");
		lblDisplayedMail.setBounds(271, 78, 60, 14);
		panel_1.add(lblDisplayedMail);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Show User Profile", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_6 = new JLabel("Name :");
		label_6.setBounds(10, 24, 48, 21);
		panel_2.add(label_6);
		
		JLabel label_8 = new JLabel("Nickname :");
		label_8.setBounds(10, 88, 59, 21);
		panel_2.add(label_8);
		
		JLabel label_7 = new JLabel("Surname :");
		label_7.setBounds(10, 56, 59, 21);
		panel_2.add(label_7);
		
		JLabel label_9 = new JLabel("Mail :");
		label_9.setBounds(195, 24, 48, 21);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("Age :");
		label_10.setBounds(195, 56, 48, 21);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("Password :");
		label_11.setBounds(195, 88, 59, 21);
		panel_2.add(label_11);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(68, 24, 86, 20);
		panel_2.add(textFieldName);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(68, 56, 86, 20);
		panel_2.add(textFieldSurname);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setColumns(10);
		textFieldNickname.setBounds(68, 88, 86, 20);
		panel_2.add(textFieldNickname);
		
		textFieldPasswod = new JTextField();
		textFieldPasswod.setColumns(10);
		textFieldPasswod.setBounds(264, 88, 86, 20);
		panel_2.add(textFieldPasswod);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(264, 56, 86, 20);
		panel_2.add(textFieldAge);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(264, 24, 86, 20);
		panel_2.add(textFieldMail);
		
		JButton button = new JButton("Update");
		button.setBounds(155, 154, 101, 32);
		panel_2.add(button);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
	}
}
