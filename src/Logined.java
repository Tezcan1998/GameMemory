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
import java.awt.event.ActionEvent;

public class Logined extends JFrame {

	private JPanel contentPane;
	private Main main;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldNickname;
	private JTextField textFieldMail;
	private JTextField textFieldAge;
	private JTextField textFieldPassword;
	private JLabel lblDisplayedName,lblDisplayedNickname,lblDisplayedSurname,lblDisplayedAge,lblDisplayedCountry,lblDisplayedMail;
	
	
	private int userID;

	public void updateProfilInfo() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con=(Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ASUS\\workspace\\GameMemory\\SQLite\\gamedb.sqlite");
			Statement st=(Statement) con.createStatement();
			ResultSet rs = st.executeQuery("select * from users");
	        while(rs.next())
	        {
		        if(rs.getInt("UserId")==userID)	
		        {
		        	
		        	lblDisplayedName.setText(rs.getString("UserName"));
		        	lblDisplayedNickname.setText(rs.getString("UserNickName"));
		        	lblDisplayedSurname.setText(rs.getString("UserSurname"));
		        	lblDisplayedAge.setText(Integer.toString(rs.getInt("UserAge")));
		        	lblDisplayedCountry.setText(rs.getString("UserCountry"));
		        	lblDisplayedMail.setText(rs.getString("UserMail"));
		        	
		        	
		        	///yukardakinin benzeri buraya yapýlsýn 
		        	textFieldName.setText(rs.getString("UserName"));
		        	
		        }
	          
	          System.out.println("name = " + rs.getString("name"));
	          System.out.println("id = " + rs.getInt("id"));
	        }
		}
		catch(Exception ex)
		{
			
		}
		
	}
	
	public void updateChanges()
	{
		//elleme
	}
	
	public Logined(Main _main, int tempId) throws ClassNotFoundException, SQLException {
		this.main=_main;
		userID=tempId;
		
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
				
				updateChanges();
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
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("High Scores", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Play Game", null, panel_4, null);
		panel_4.setLayout(null);
		
		
		updateProfilInfo();
	}
}
