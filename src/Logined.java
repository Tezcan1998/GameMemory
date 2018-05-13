import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import java.awt.Choice;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;

public class Logined extends JFrame {

	private JPanel contentPane;
	private Main main;
	private User user;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldNickname;
	private JTextField textFieldMail;
	private JTextField textFieldAge;
	private JTextField textFieldPassword;
	private JLabel lblDisplayedName,lblDisplayedNickname,lblDisplayedSurname,lblDisplayedAge,lblDisplayedCountry,lblDisplayedMail;
	private JTextField textFieldCountry;
	private JLabel label_1,label_2,label_3,label_4;
	
	public Logined getReference()
	{
		return this;
	}
	

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
	
	public void updateChanges() throws ClassNotFoundException, SQLException
	{
		user.setName(textFieldName.getText());
		user.setSurname(textFieldSurname.getText());
		user.setNickname(textFieldNickname.getText());
		user.setAge(Integer.parseInt(textFieldAge.getText()));
		user.setMail(textFieldMail.getText());
		user.setCountry(textFieldCountry.getText());
		SQLiteConnection db=new PlayerConnection();
		db.updateProfile(user,textFieldPassword.getText() );
		updateProfilInfo();
		JOptionPane.showMessageDialog(null,"Update Successfull");
		
	}
	
	
	public void loadHighScores()
	{
		ArrayList<String> list=new ArrayList<String>();
		label_1.setText(Integer.toString(user.getHighscore()));
		SQLiteConnection db=new PlayerConnection();
		db.loadHighScores(list);
		
		if(list.size()==1)
		{
			label_2.setText(list.get(0));
		}
		else if(list.size()==2)
		{
			label_2.setText(list.get(0));
			label_3.setText(list.get(1));
		}
		else if(list.size()==3)
		{
			label_2.setText(list.get(0));
			label_3.setText(list.get(1));
			label_4.setText(list.get(2));
			
		}
		else {
			
		}
		
		
		
		
	}
	
	public Logined(Main _main, User user) throws ClassNotFoundException, SQLException {
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
		label.setBounds(10, 30, 45, 21);
		panel_1.add(label);
		
		JLabel lblSurname = new JLabel("Surname  :");
		lblSurname.setBounds(196, 30, 66, 21);
		panel_1.add(lblSurname);
		
		lblDisplayedName = new JLabel("");
		lblDisplayedName.setBounds(64, 33, 60, 14);
		panel_1.add(lblDisplayedName);
		
		lblDisplayedSurname = new JLabel("");
		lblDisplayedSurname.setBounds(255, 33, 79, 14);
		panel_1.add(lblDisplayedSurname);
		
		JLabel lblNickname = new JLabel("Nickname :");
		lblNickname.setBounds(10, 62, 60, 21);
		panel_1.add(lblNickname);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(196, 62, 45, 21);
		panel_1.add(lblAge);
		
		lblDisplayedNickname = new JLabel("");
		lblDisplayedNickname.setBounds(64, 65, 60, 14);
		panel_1.add(lblDisplayedNickname);
		
		lblDisplayedAge = new JLabel("");
		lblDisplayedAge.setBounds(255, 65, 60, 14);
		panel_1.add(lblDisplayedAge);
		
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(10, 94, 60, 21);
		panel_1.add(lblCountry);
		
		lblDisplayedCountry = new JLabel("");
		lblDisplayedCountry.setBounds(64, 97, 60, 14);
		panel_1.add(lblDisplayedCountry);
		
		JLabel lblUsermail = new JLabel("Mail :");
		lblUsermail.setBounds(196, 94, 45, 21);
		panel_1.add(lblUsermail);
		
		lblDisplayedMail = new JLabel("");
		lblDisplayedMail.setBounds(255, 97, 150, 14);
		panel_1.add(lblDisplayedMail);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Edit", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblEditName = new JLabel("Name :");
		lblEditName.setBounds(10, 36, 48, 21);
		panel_2.add(lblEditName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(75, 36, 86, 20);
		panel_2.add(textFieldName);
		textFieldName.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
					updateChanges();
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
			}

			
		});
		btnNewButton.setBounds(155, 179, 101, 32);
		panel_2.add(btnNewButton);
		
		JLabel lblEditSurname = new JLabel("Surname :");
		lblEditSurname.setBounds(10, 68, 59, 21);
		panel_2.add(lblEditSurname);
		
		JLabel lblEditNickname = new JLabel("Nickname :");
		lblEditNickname.setBounds(10, 100, 59, 21);
		panel_2.add(lblEditNickname);
		
		JLabel lblEditMail = new JLabel("Mail :");
		lblEditMail.setBounds(228, 36, 48, 21);
		panel_2.add(lblEditMail);
		
		JLabel lblEditAge = new JLabel("Age :");
		lblEditAge.setBounds(228, 68, 48, 21);
		panel_2.add(lblEditAge);
		
		JLabel lblEditPassword = new JLabel("Password :");
		lblEditPassword.setBounds(228, 100, 59, 21);
		panel_2.add(lblEditPassword);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(75, 67, 86, 20);
		panel_2.add(textFieldSurname);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setColumns(10);
		textFieldNickname.setBounds(75, 100, 86, 20);
		panel_2.add(textFieldNickname);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(288, 36, 86, 20);
		panel_2.add(textFieldMail);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(288, 68, 86, 20);
		panel_2.add(textFieldAge);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(288, 100, 86, 20);
		panel_2.add(textFieldPassword);
		
		textFieldCountry = new JTextField();
		textFieldCountry.setColumns(10);
		textFieldCountry.setBounds(75, 135, 86, 20);
		panel_2.add(textFieldCountry);
		
		JLabel lblCountry_1 = new JLabel("Country  :");
		lblCountry_1.setBounds(10, 138, 59, 21);
		panel_2.add(lblCountry_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("High Scores", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblYourScore = new JLabel("Your Score   :");
		lblYourScore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblYourScore.setBounds(10, 11, 185, 60);
		panel_3.add(lblYourScore);
		
		JLabel lblHighestScore = new JLabel("Highest Score   :");
		lblHighestScore.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHighestScore.setBounds(10, 76, 185, 35);
		panel_3.add(lblHighestScore);
		
		JLabel lblSecondScore = new JLabel("Second's Score :");
		lblSecondScore.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSecondScore.setBounds(10, 122, 175, 35);
		panel_3.add(lblSecondScore);
		
		JLabel lblThirdScore = new JLabel("Third's Score    :");
		lblThirdScore.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblThirdScore.setBounds(10, 168, 192, 35);
		panel_3.add(lblThirdScore);
		
		label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_1.setBounds(195, 11, 175, 60);
		panel_3.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_2.setBounds(195, 76, 175, 35);
		panel_3.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_3.setBounds(195, 122, 175, 35);
		panel_3.add(label_3);
		
        label_4 = new JLabel("");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_4.setBounds(195, 168, 175, 35);
		panel_3.add(label_4);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Play Game", null, panel_4, null);
		panel_4.setLayout(null);
		
		
		JRadioButton radioButtonAnimal = new JRadioButton("");
		radioButtonAnimal.setBounds(131, 115, 21, 23);
		panel_4.add(radioButtonAnimal);
		
		JRadioButton radioButtonFlower = new JRadioButton("");
		radioButtonFlower.setBounds(272, 115, 21, 23);
		panel_4.add(radioButtonFlower);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(radioButtonAnimal.isSelected())
				{
					Game game=new Game(getReference(),user,"AnimalType");
					game.setVisible(true);
				}
				else if(radioButtonFlower.isSelected())
				{
					Game game=new Game(getReference(),user,"FlowerType");
					game.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a game type","Unseccessfull Play",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnPlay.setBounds(168, 156, 105, 33);
		panel_4.add(btnPlay);
		
		
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		lblAnimal.setBounds(99, 70, 87, 38);
		panel_4.add(lblAnimal);
		
		JLabel lblFlower = new JLabel("Flower");
		lblFlower.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		lblFlower.setBounds(241, 70, 79, 38);
		panel_4.add(lblFlower);
		
		
		updateProfilInfo();
		loadHighScores();
	}
}
