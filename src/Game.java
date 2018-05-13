import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Game extends JFrame {

	private JPanel contentPane;
	private Logined main;
	private User user;
	private String gametype;
	

	public Game(User user, String string) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}



	/**
	 * @wbp.parser.constructor
	 */
	public Game(Logined logined, User user, String gametype) {
		this.main=logined;
		this.user=user;
		this.gametype=gametype;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(28, 11, 64, 42);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(123, 11, 64, 42);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(221, 11, 64, 42);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.setBounds(323, 11, 64, 42);
		getContentPane().add(button_2);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(369, 216, 55, 34);
		getContentPane().add(btnNewButton_1);
		logined.setVisible(false);
		// TODO Auto-generated constructor stub
	}

}
