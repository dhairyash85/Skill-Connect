package skillConnect;

import java.awt.EventQueue;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

public class Search extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search("dhairyash", "V.E.S.I.T");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JPanel panel;
	JLabel colg;
	JLabel usn;
	int u;
	int uid=1;
	public void loadUsers(String usern, String q) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/SkillConnect?characterEncoding=utf8&autoReconnect=true&useSSL=false";
			String pass="PW";
			Connection con=DriverManager.getConnection(url, "root", pass);  
			Statement stmt=con.createStatement();
			ResultSet temp = ((stmt.executeQuery("select * from user order by userid desc limit 1")));
			temp.next();
			u=temp.getInt("userid");
			if(uid>u){
				dispose();
				JOptionPane.showMessageDialog(null, "No more users found");
				return;
			}
			
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery("select * from user join mentor on user.userid=mentor.mentorid where '" + q + "' in (user.username, fname, lname, college, skill) and userid="+uid);
				if(!rs.next()) {
					uid++;
					loadUsers(usern, q);
				}
				if(rs.getString("username")==usern) {
					panel.removeAll();
					uid++;
					loadUsers(usern, q);
				}
				System.out.println(rs.getInt("userid"));
				panel = new JPanel();
				panel.setBackground(Color.WHITE);
				panel.setBounds(10, 30, 351, 95);
				contentPane.add(panel);
				panel.setLayout(null);
				
				usn = new JLabel(rs.getString("username"));
				usn.setFont(new Font("Tahoma", Font.BOLD, 15));
				usn.setBounds(10, 11, 263, 32);
				panel.add(usn);
				
				colg = new JLabel(rs.getString("college"));
				colg.setBounds(10, 49, 257, 14);
				panel.add(colg);
				
				JButton btnNewButton = new JButton("view");
				btnNewButton.setBounds(190, 35, 130, 23);
				panel.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UserDisplay us=new UserDisplay(usern, usn.getText());
					us.setVisible(true);
					us.setAlwaysOnTop(true);
				}
			});
				uid++;
				
		}catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public Search(String user, String query) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 400, 200);
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Search");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 123, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.setBounds(134, 127, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/SkillConnect?characterEncoding=utf8&autoReconnect=true&useSSL=false";
					String pass="PW";
					Connection con=DriverManager.getConnection(url, "root", pass);  
					Statement stmt=con.createStatement();
					ResultSet temp = ((stmt.executeQuery("select * from user order by userid desc limit 1")));
					temp.next();
					u=temp.getInt("userid");
					Statement s=con.createStatement();
					ResultSet rs;
					while(true){
						rs=s.executeQuery("select * from user join mentor where '" + query + "' in (user.username, fname, lname, college, skill) and userid="+uid);
						if(rs.next()) break;
						uid++;
					}
					usn.setText(rs.getString("username"));
					colg.setText(rs.getString("college"));
					
			}catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			}
		});
		loadUsers(user, query);
		contentPane.add(btnNewButton_1);
		
		
		
		
	}
}
