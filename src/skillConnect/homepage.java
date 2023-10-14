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
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Component;
public class homepage extends JFrame {

	private JPanel contentPane;
	JPanel mentor[]=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage("dhairyash");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	String p1,p2, p3;
	
	/**
	 * Create the frame.
	 */

	public homepage(String username) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/SkillConnect?characterEncoding=utf8&autoReconnect=true&useSSL=false";
			String user="root";
			String pass="PW";
			Connection con=DriverManager.getConnection(url, user, pass);  
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user where username='" + username + "'");
			rs.next();
			int userid=rs.getInt("userid");
			// System.out.println(userid);
			Statement s=con.createStatement();
			int us2=rs.getInt("userid");
			// Resultset user=s.executeQuery("select * from user where username='"+userd)
			ResultSet r=s.executeQuery("select * from request where receiverid="+rs.getInt("userid")+" and processed=false");
			//rs.next();
			
			if(r.next()){
				int use=r.getInt("senderid");
				Statement req=con.createStatement();
				ResultSet re=req.executeQuery("select * from user where userid="+use);
				re.next();
				Request rqst=new Request(re.getString("username"), username);
				rqst.setVisible(true);
				Statement s1=con.createStatement();
				int u=s1.executeUpdate("update request set processed=true where receiverid="+us2);
			}
			setResizable(false);
			setType(Type.POPUP);
			setTitle("Skill Connect");
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
			mainpage.setBackground(new Color(0, 128, 128));
			tabbedPane.addTab("Home", null, mainpage, null);
			tabbedPane.setBackgroundAt(0, Color.WHITE);
			mainpage.setLayout(null);
			
			TextField searchfield = new TextField();
			searchfield.setBounds(10, 10, 273, 22);
			mainpage.add(searchfield);
			
			JButton search = new JButton("Search");
			search.setBackground(Color.WHITE);
			search.setBounds(289, 10, 89, 23);
						search.addActionListener((ActionEvent e)->{
							Search win=new Search(username, searchfield.getText());
							win.setVisible(true);
						});
			mainpage.add(search);
			Statement stm=con.createStatement();
			ResultSet dis1=stm.executeQuery("select * from mentor "
					+ "order by RAND() "
					+ "limit 1;");
			dis1.next();
			
			ResultSet det1=stm.executeQuery("select * from user where userid=" + dis1.getInt("mentorid"));
			det1.next();
			
			JPanel panel1 = new JPanel();
			panel1.setBackground(new Color(255, 255, 255));
			panel1.setBounds(10, 55, 749, 110);
			mainpage.add(panel1);
			panel1.setLayout(null);
			p1=det1.getString("username");
			JLabel mentor1 = new JLabel(p1);
			mentor1.setFont(new Font("Tahoma", Font.BOLD, 15));
			mentor1.setBounds(10, 11, 263, 32);
			panel1.add(mentor1);
			
			JLabel college1 = new JLabel(det1.getString("college"));
			college1.setBounds(10, 54, 257, 14);
			panel1.add(college1);
			// rs.next();
			JButton btn1 = new JButton("View");
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					p1=mentor1.getText();
					UserDisplay us=new UserDisplay(username,p1);
					us.setVisible(true);
				}
			});
			btn1.setBounds(600, 45, 130, 23);
			panel1.add(btn1);
//			dis.next();
			
			JPanel panel2 = new JPanel();
			panel2.setBackground(new Color(255, 255, 255));
			panel2.setLayout(null);
			panel2.setBounds(10, 175, 749, 110);
			mainpage.add(panel2);
			
			ResultSet dis2=stm.executeQuery("select * from mentor "
						+ "order by RAND() "
						+ "limit 1;");
			dis2.next();
			ResultSet det2=stm.executeQuery("select * from user where userid=" + dis2.getInt("mentorid"));
			det2.next();
			p2=det2.getString("username");
			// System.out.println(det2.getString("username")+" "+p2);
			JLabel mentor2 = new JLabel(p2);
			mentor2.setFont(new Font("Tahoma", Font.BOLD, 15));
			mentor2.setBounds(10, 11, 263, 32);
			panel2.add(mentor2);
			
			JLabel college2 = new JLabel(det2.getString("college"));
			college2.setBounds(10, 54, 257, 14);
			panel2.add(college2);
			
			JButton btn2 = new JButton("View");
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						p2=mentor2.getText();
						UserDisplay us=new UserDisplay(username, p2);
						us.setVisible(true);
					
				}
			});
			btn2.setBounds(600, 45, 130, 23);
			panel2.add(btn2);
			
			JPanel panel3 = new JPanel();
			panel3.setBackground(new Color(255, 255, 255));
			panel3.setLayout(null);
			panel3.setBounds(10, 295, 749, 110);
			mainpage.add(panel3);
			
			ResultSet dis3=stm.executeQuery("select * from mentor "
					+ "order by RAND() "
					+ "limit 1;");
			dis3.next();
			ResultSet det3=stm.executeQuery("select * from user where userid=" + dis3.getInt("mentorid"));
			det3.next();
			p3=det3.getString("username");
			JLabel mentor3 = new JLabel(p3);
			mentor3.setFont(new Font("Tahoma", Font.BOLD, 15));
			mentor3.setBounds(10, 11, 263, 32);
			panel3.add(mentor3);
			
			JLabel college3 = new JLabel(det3.getString("college"));
			college3.setBounds(10, 54, 257, 14);
			panel3.add(college3);
			
			JButton btn3 = new JButton("View");
			btn3.setBounds(600, 45, 130, 23);
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					p3=mentor3.getText();
					UserDisplay us=new UserDisplay(username, p3);
					us.setVisible(true);
				}
			});
			panel3.add(btn3);
			
			JButton next = new JButton("Next");
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ResultSet d1=stm.executeQuery("select * from mentor "
								+ "order by RAND() "
								+ "limit 3;");
						d1.next();
						ResultSet de1=stm.executeQuery("select * from user where userid=" + d1.getInt("mentorid"));
						de1.next();
						mentor1.setText(de1.getString("username"));
						college1.setText(de1.getString("college"));
						ResultSet d2=stm.executeQuery("select * from mentor "
								+ "order by RAND() "
								+ "limit 3;");
						d2.next();
						ResultSet de2=stm.executeQuery("select * from user where userid=" + d2.getInt("mentorid"));
						de2.next();
						mentor2.setText(de2.getString("username"));
						college2.setText(de2.getString("college"));
						ResultSet d3=stm.executeQuery("select * from mentor "
								+ "order by RAND() "
								+ "limit 3;");
						d3.next();
						ResultSet de3=stm.executeQuery("select * from user where userid=" + d3.getInt("mentorid"));
						de3.next();
						mentor3.setText(de3.getString("username"));
						college3.setText(de3.getString("college"));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			next.setBounds(317, 416, 142, 23);
			mainpage.add(next);
			
			JButton btnNewButton = new JButton("Messages");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ChatBox ch=new ChatBox(userid);
					ch.setVisible(true);
				}
			});
			btnNewButton.setBounds(588, 10, 128, 23);
			mainpage.add(btnNewButton);
			
	        setLocationRelativeTo(null);
			
			JPanel phonenumber = new JPanel();
			phonenumber.setBackground(new Color(0, 128, 128));
			tabbedPane.addTab("Phone Number", null, phonenumber, null);
			phonenumber.setLayout(null);
			
			JTextArea textArea = new JTextArea();
			textArea.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
			textArea.setEditable(false);
			textArea.setBounds(0, 0, 793, 456);
			Statement te=con.createStatement();
			ResultSet text=te.executeQuery("select * from requestapproved where userid="+rs.getInt("userid"));
			Statement disp=con.createStatement();
			while (text.next()) {
				ResultSet display=disp.executeQuery("select * from user where userid="+text.getString("approver"));
				display.next();
				textArea.append(Long.toString((text.getLong("phonenumber")))+ " " +display.getString("username")+"\n");
			}
			phonenumber.add(textArea);
			
			
			Panel account = new Panel();
			account.setBackground(new Color(0, 128, 128));
			tabbedPane.addTab("My Account", null, account, null);
			account.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Username: " + rs.getString(8));
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(10, 11, 307, 48);
			account.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("College: " + rs.getString("college"));
			lblNewLabel_2.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setBounds(10, 55, 398, 14);
			account.add(lblNewLabel_2);
			
			// JLabel lblNewLabel_3 = new JLabel("Course: Engineering");
			// lblNewLabel_3.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
			// lblNewLabel_3.setForeground(new Color(255, 255, 255));
			// lblNewLabel_3.setBounds(10, 80, 398, 14);
			// account.add(lblNewLabel_3);
			
			// JLabel lblNewLabel_4 = new JLabel("Year: 2nd Year");
			// lblNewLabel_4.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
			// lblNewLabel_4.setForeground(new Color(255, 255, 255));
			// lblNewLabel_4.setBounds(10, 105, 398, 14);
			// account.add(lblNewLabel_4);
			
			JButton logout = new JButton("Logout");
			logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			logout.setBounds(10, 393, 89, 23);
			account.add(logout);
	}
	catch(Exception g){System.out.println(g);}
	}
}
