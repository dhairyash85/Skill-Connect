package skillConnect;
import skillConnect.*;
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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

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
		setResizable(false);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
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
		Favourites.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Favourites will be displayed here");
		lblNewLabel.setBounds(10, 11, 207, 14);
		Favourites.add(lblNewLabel);
		
		Panel account = new Panel();
		account.setBackground(new Color(204, 215, 215));
		tabbedPane.addTab("My Account", null, account, null);
		account.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username: admin");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 86, 307, 48);
		account.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("College: V.E.S.I.T");
		lblNewLabel_2.setBounds(10, 130, 398, 14);
		account.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course: Engineering");
		lblNewLabel_3.setBounds(10, 155, 398, 14);
		account.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Year: 2nd Year");
		lblNewLabel_4.setBounds(10, 180, 398, 14);
		account.add(lblNewLabel_4);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		logout.setBounds(10, 393, 89, 23);
		account.add(logout);
	}
}
