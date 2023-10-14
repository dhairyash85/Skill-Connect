package skillConnect;

import java.awt.EventQueue;
import skillConnect.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Request extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Request frame = new Request("rushabh", "dhairyash");
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
	public Request(String username, String request) {
		setAlwaysOnTop(true);
		setType(Type.POPUP);
		setAutoRequestFocus(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(username+" has requested your number");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		lblNewLabel.setBounds(71, 52, 314, 25);
		contentPane.add(lblNewLabel);
		
		JButton yes = new JButton("Yes");
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long n=Long.parseLong(JOptionPane.showInputDialog("Enter your Number"));
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/SkillConnect?characterEncoding=utf8&autoReconnect=true&useSSL=false";
					String user="root";
					String pass="PW";
					Connection con=DriverManager.getConnection(url, user, pass);  
					Statement stmt=con.createStatement();
					ResultSet us=stmt.executeQuery("select * from user where username = '"+username+"'");
					us.next();
					Statement stm=con.createStatement();
					ResultSet ap=stm.executeQuery("select * from user where username = '"+request+"'");
					ap.next();
					Statement st=con.createStatement();
					String query = "INSERT INTO requestapproved (userid, phonenumber, approver) VALUES (?, ?, ?)";

				    PreparedStatement statement = con.prepareStatement(query);
				    statement.setInt(1, us.getInt("userid"));
				    statement.setLong(2, n);
				    statement.setInt(3, ap.getInt("userid"));

				    int rowsAffected = statement.executeUpdate();
					con.close();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
					
				}
				dispose();
			}
		});
		yes.setBounds(71, 144, 89, 23);
		contentPane.add(yes);
		
		JButton no = new JButton("No");
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		no.setBounds(240, 144, 89, 23);
		contentPane.add(no);
	}

}
