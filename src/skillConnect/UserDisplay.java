package skillConnect;

import java.awt.EventQueue;
import java.awt.Window.Type;
import skillConnect.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UserDisplay extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDisplay frame = new UserDisplay("dhairyash","rushabh");
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
	public UserDisplay(String username, String userd) {
		try {
			//String username="dhairyash";
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/SkillConnect?characterEncoding=utf8&autoReconnect=true&useSSL=false";
//			String user="root";
			String pass="PW";
			Connection con=DriverManager.getConnection(url, "root", pass);  
			Statement stmt=con.createStatement();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(200, 100, 900, 500);
			setResizable(false);
			setType(Type.POPUP);
			setAlwaysOnTop(true);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 128, 128));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			setContentPane(contentPane);
			contentPane.setLayout(null);
			ResultSet rs=stmt.executeQuery("select * from user where username='"+userd+"'");
			rs.next();
			int user1=rs.getInt("userid");
			setTitle(rs.getString("username"));
			JLabel user = new JLabel("User:"+rs.getString("username"));
			user.setForeground(new Color(255, 255, 255));
			user.setFont(new Font("Georgia", Font.BOLD, 25));
			user.setBounds(80, 100, 310, 51);
			contentPane.add(user);
			
			JLabel college = new JLabel("College:"+rs.getString("college"));
			college.setForeground(new Color(255, 255, 255));
			college.setFont(new Font("Georgia", Font.BOLD, 15));
			college.setBounds(80, 162, 188, 34);
			contentPane.add(college);
			
			Statement s=con.createStatement();
			ResultSet m=s.executeQuery("select * from mentor where username='"+userd+"'");
			m.next();
			JLabel skill = new JLabel("Skills: " + m.getString("skill") );
			skill.setForeground(new Color(255, 255, 255));
			skill.setFont(new Font("Georgia", Font.BOLD, 15));
			skill.setBounds(80, 207, 188, 34);
			contentPane.add(skill);
			
			JButton chat = new JButton("Request Phone Number");
			chat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				//	Request r=new Request(username, userd);
					try {
						Class.forName("com.mysql.jdbc.Driver");
						String url="jdbc:mysql://localhost:3306/SkillConnect?characterEncoding=utf8&autoReconnect=true&useSSL=false";
						String user="root";
						String pass="PW";
						Connection con=DriverManager.getConnection(url, user, pass);  
						Statement stmt=con.createStatement();
						Statement stt=con.createStatement();
						ResultSet r1=stt.executeQuery("select * from user where username='"+username+"'");
						
						Statement st=con.createStatement();
						ResultSet r2=st.executeQuery("select * from user where username='"+userd+"'");
						
						if(r1.next()&&r2.next()) {
							int u1=r1.getInt("userid");
							int u2=r2.getInt("userid");
							boolean t=stmt.execute("insert into request values("+u1+","+u2+","+false+")");
						}
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			chat.setBounds(502, 407, 196, 23);
			contentPane.add(chat);
			
			JButton back = new JButton("Back");
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			back.setBounds(708, 407, 89, 23);
			contentPane.add(back);
			
			JButton mssg = new JButton("Chat");
			mssg.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Statement s=con.createStatement();
						Statement stt=con.createStatement();
						ResultSet r1=stt.executeQuery("select * from user where username='"+username+"'");
						r1.next();
						int user2=r1.getInt("userid");
						Statement check=con.createStatement();
						ResultSet c=check.executeQuery("select * from messageinfo where user1="+user1+" and user2="+user2);
//						if(!c.next()) {
						int i=s.executeUpdate("insert into messageinfo values("+user1+", "+user2+")");
						ChatBox ch=new ChatBox(user2);
						ch.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			mssg.setBounds(403, 407, 89, 23);
			contentPane.add(mssg);
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	}

}
