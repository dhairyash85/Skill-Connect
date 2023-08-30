package skillConnect;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
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
	public homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setPreferredSize(new Dimension(5, 10));
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 884, 461);
		contentPane.add(tabbedPane);
		
		JPanel mainpage = new JPanel();
		mainpage.setBackground(new Color(204, 215, 215));
		tabbedPane.addTab("Home", null, mainpage, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		mainpage.setLayout(null);
		
		TextField searchfield = new TextField();
		searchfield.setBounds(10, 10, 273, 22);
		mainpage.add(searchfield);
		
		JButton search = new JButton("Search");
		search.setBackground(Color.WHITE);
		search.setBounds(289, 10, 89, 23);
		mainpage.add(search);
		
		JPanel Favourites = new JPanel();
		Favourites.setBackground(new Color(204, 215, 215));
		tabbedPane.addTab("Favourites", null, Favourites, null);
		
		JLabel lblNewLabel = new JLabel("Ass and tits");
		Favourites.add(lblNewLabel);
		
		Panel account = new Panel();
		account.setBackground(new Color(204, 215, 215));
		tabbedPane.addTab("My Account", null, account, null);
		
		JLabel lblNewLabel_1 = new JLabel("Username: nigger");
		account.add(lblNewLabel_1);
	}
}
