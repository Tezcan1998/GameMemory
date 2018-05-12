import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AdminPage extends JFrame {

	private JPanel contentPane;

	private Main main;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldNickname;
	private JTextField textFieldPassword;
	private JTextField textFieldAge;
	private JTextField textFieldCountry;
	private JTextField textFieldMail;
	private JLabel lblDisplayedName,lblDisplayedNickname,lblDisplayedSurname,lblDisplayedAge,lblDisplayedCountry,lblDisplayedMail;
	private User user;
	private User player;
	private JTextField textFieldUserName;
	private JTextField textFieldUserSurname;
	private JTextField textFieldUserNickname;
	private JTextField textFieldUserPassword;
	private JComboBox comboBox;
	
	private ArrayList<String> fullinfo;
	private ArrayList<Integer> id;
	private AdminConnection db;
	
	private int selectedIndex;
	
	
	
	
	
	public void updateProfilInfo()  {
		
    	lblDisplayedName.setText(user.getName());
    	lblDisplayedNickname.setText(user.getNickname());
    	lblDisplayedSurname.setText(user.getSurname());
    	lblDisplayedAge.setText(Integer.toString(user.getAge()));
    	lblDisplayedCountry.setText(user.getCountry());
    	lblDisplayedMail.setText(user.getMail());

    	textFieldName.setText(user.getName());
    	textFieldNickname.setText(user.getNickname());
    	textFieldSurname.setText(user.getSurname());
    	textFieldAge.setText(Integer.toString(user.getAge()));
    	textFieldCountry.setText(user.getCountry());
    	textFieldMail.setText(user.getMail());
    	textFieldPassword.setText("");


}

	public void updateChanges()
{
	
	user.setName(textFieldName.getText());
	user.setSurname(textFieldSurname.getText());
	user.setNickname(textFieldNickname.getText());
	user.setAge(Integer.parseInt(textFieldAge.getText()));
	user.setMail(textFieldMail.getText());
	user.setCountry(textFieldCountry.getText());
	db.updateProfile(user,textFieldPassword.getText() );
	updateProfilInfo();
	JOptionPane.showMessageDialog(null,"Update Successfull");
	
}

	
	public void showPlayerProfile()
	{
		
		db.getPlayerInfo(player,id.get(selectedIndex));
		textFieldUserName.setText(player.getName());
		textFieldUserSurname.setText(player.getSurname());
		textFieldUserNickname.setText(player.getNickname());
		
		
	}

	
	public void updatePlayerProfile()
	{
		textFieldUserName.setText("");
		textFieldUserSurname.setText("");
		textFieldUserNickname.setText("");
		textFieldUserPassword.setText("");
		db.updatePlayerProfile(selectedIndex,player,textFieldUserPassword.getText());
		
	}
	public void loadComboBox()
	{
		fullinfo=new ArrayList<String>();
		id=new ArrayList<Integer>();
		db.getProfiles(fullinfo, id);
		comboBox.setModel(new DefaultComboBoxModel(fullinfo.toArray()));
	}
	
	public AdminPage(Main _main, User user) {
		db=new AdminConnection();
		this.user=user;
		this.main=_main;
		selectedIndex=0;
		player=new Player();
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
		
		lblDisplayedNickname = new JLabel("");
		lblDisplayedNickname.setBounds(65, 46, 60, 14);
		panel_1.add(lblDisplayedNickname);
		
		lblDisplayedCountry = new JLabel("");
		lblDisplayedCountry.setBounds(65, 78, 60, 14);
		panel_1.add(lblDisplayedCountry);
		
		lblDisplayedSurname = new JLabel("");
		lblDisplayedSurname.setBounds(274, 14, 60, 14);
		panel_1.add(lblDisplayedSurname);
		
		lblDisplayedAge = new JLabel("");
		lblDisplayedAge.setBounds(271, 50, 60, 14);
		panel_1.add(lblDisplayedAge);
		
		lblDisplayedMail = new JLabel("");
		lblDisplayedMail.setBounds(271, 78, 60, 14);
		panel_1.add(lblDisplayedMail);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Update Profile", null, panel_2, null);
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
		
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(10, 120, 59, 21);
		panel_2.add(lblCountry);
		
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
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(264, 88, 86, 20);
		panel_2.add(textFieldPassword);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(264, 56, 86, 20);
		panel_2.add(textFieldAge);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(264, 24, 86, 20);
		panel_2.add(textFieldMail);
		
		textFieldCountry = new JTextField();
		textFieldCountry.setColumns(10);
		textFieldCountry.setBounds(68, 120, 86, 20);
		panel_2.add(textFieldCountry);
		
		JButton button = new JButton("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateChanges();
			}
		});
		button.setBounds(155, 154, 101, 32);
		panel_2.add(button);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Edit User Profile", null, panel_3, null);
		panel_3.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(113, 107, 255, 20);
		panel_3.add(comboBox);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedIndex=comboBox.getSelectedIndex();
				showPlayerProfile();
			}
		});
		btnShow.setBounds(113, 154, 102, 23);
		panel_3.add(btnShow);
		
		JLabel lblUserName = new JLabel("Name :");
		lblUserName.setBounds(54, 34, 48, 21);
		panel_3.add(lblUserName);
		
		JLabel lblUserSurname = new JLabel("Surname :");
		lblUserSurname.setBounds(224, 34, 59, 21);
		panel_3.add(lblUserSurname);
		
		JLabel lblUserNickname = new JLabel("Nickname :");
		lblUserNickname.setBounds(54, 66, 59, 21);
		panel_3.add(lblUserNickname);
		
		JLabel lblUserPassword = new JLabel("Password :");
		lblUserPassword.setBounds(224, 66, 59, 21);
		panel_3.add(lblUserPassword);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setText((String) null);
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(112, 34, 86, 20);
		panel_3.add(textFieldUserName);
		
		textFieldUserSurname = new JTextField();
		textFieldUserSurname.setText((String) null);
		textFieldUserSurname.setColumns(10);
		textFieldUserSurname.setBounds(282, 34, 86, 20);
		panel_3.add(textFieldUserSurname);
		
		textFieldUserNickname = new JTextField();
		textFieldUserNickname.setText((String) null);
		textFieldUserNickname.setColumns(10);
		textFieldUserNickname.setBounds(112, 66, 86, 20);
		panel_3.add(textFieldUserNickname);
		
		textFieldUserPassword = new JTextField();
		textFieldUserPassword.setText("");
		textFieldUserPassword.setColumns(10);
		textFieldUserPassword.setBounds(282, 66, 86, 20);
		panel_3.add(textFieldUserPassword);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updatePlayerProfile();
				loadComboBox();
				
			}
		});
		btnUpdate.setBounds(271, 154, 97, 23);
		panel_3.add(btnUpdate);
		updateProfilInfo();
		loadComboBox();
		
	}
}
