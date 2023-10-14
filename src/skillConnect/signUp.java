package skillConnect;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.Window.Type;
import skillConnect.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signUp extends JFrame {

	private JPanel contentPane;
	private JTextField fn;
	private JTextField ln;
	private JTextField cl;
	private JTextField us;
	private JLabel lblNewLabel_3;
	private JTextField em;
	private JLabel lblNewLabel_4;
	private JTextField pa;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUp frame = new signUp();
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
	public signUp() {
		setTitle("Sign-Up");
		setResizable(false);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fn = new JTextField();
		fn.setBounds(154, 90, 222, 20);
		contentPane.add(fn);
		fn.setColumns(10);
		
		ln = new JTextField();
		ln.setColumns(10);
		ln.setBounds(566, 90, 222, 20);
		contentPane.add(ln);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(27, 93, 148, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(477, 93, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("College");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(27, 138, 148, 14);
		contentPane.add(lblNewLabel_2);
		
		cl = new JTextField();
		cl.setBounds(154, 135, 338, 20);
		contentPane.add(cl);
		cl.setColumns(10);
		
		us = new JTextField();
		us.setColumns(10);
		us.setBounds(154, 180, 338, 20);
		contentPane.add(us);
		
		lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(27, 183, 148, 14);
		contentPane.add(lblNewLabel_3);
		
		em = new JTextField();
		em.setColumns(10);
		em.setBounds(154, 228, 338, 20);
		contentPane.add(em);
		
		lblNewLabel_4 = new JLabel("Email Address");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(27, 231, 148, 14);
		contentPane.add(lblNewLabel_4);
		
		pa = new JTextField();
		pa.setColumns(10);
		pa.setBounds(154, 279, 338, 20);
		contentPane.add(pa);
		
		lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(27, 282, 148, 14);
		contentPane.add(lblNewLabel_5);
		
		JCheckBox std = new JCheckBox("Student");
		std.setBounds(676, 290, 97, 23);
		contentPane.add(std);
		
		JCheckBox teach = new JCheckBox("Teacher");
		teach.setBounds(676, 252, 97, 23);
		contentPane.add(teach);
		
		JLabel submit = new JLabel("Register as?");
		submit.setFont(new Font("Tahoma", Font.BOLD, 11));
		submit.setForeground(new Color(255, 255, 255));
		submit.setBounds(676, 216, 97, 14);
		contentPane.add(submit);
		
		JLabel er1 = new JLabel("");
		er1.setForeground(new Color(255, 0, 0));
		er1.setBounds(27, 208, 349, 14);
		contentPane.add(er1);
		
		JLabel er2 = new JLabel("");
		er2.setForeground(Color.RED);
		er2.setBounds(27, 259, 349, 14);
		contentPane.add(er2);
		
		JLabel er3 = new JLabel("");
		er3.setForeground(Color.RED);
		er3.setBounds(27, 310, 349, 14);
		contentPane.add(er3);
		
		JLabel er4 = new JLabel("");
		er4.setForeground(Color.RED);
		er4.setBounds(639, 234, 177, 14);
		contentPane.add(er4);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				er1.setText("");
				er2.setText("");
				er3.setText("");
				er4.setText("");

				String user=us.getText();
				String pass=us.getText();
				String email=em.getText();
				String fname=fn.getText();
				String lname=ln.getText();
				String cllg=cl.getText();
				if(user.equals("")||pass.equals("")||email.equals("")||fname.equals("")||lname.equals("")||cllg.equals("")){er3.setText("Please Fill all the details");}
				// System.out.println(pass+" " + pare.getText());
				// if(pass!=pare.getText()){
				// 	er3.setText("Both passwords are different");
				// 	return;
				// }
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/SkillConnect?characterEncoding=utf8&autoReconnect=true&useSSL=false";
//					String user="root";
					// String pass="PW";
					Connection con=DriverManager.getConnection(url, "root", "PW");  
					Statement s=con.createStatement();
					ResultSet rs=s.executeQuery("select * from user where username='"+user+"'");
					if(rs.next()){
						er1.setText("Username not avilable");
						return;
					}
					Statement ss=con.createStatement();
					ResultSet rs1=ss.executeQuery("select * from user where email='"+email+"'");
					if(rs1.next()){
						er2.setText("Email address already in use");
						return;
					}
					if(!(std.isSelected()||teach.isSelected())) {
						er4.setText("Please select atleast one option");
					}
					Statement s1=con.createStatement();
					Statement s2=con.createStatement();
					ResultSet tepm=s2.executeQuery("select * from user order by userid desc");
					tepm.next();
					int id=tepm.getInt("userid");
					// System.out.println(id);
					id++;
					int i=s1.executeUpdate("insert into user(userid, email, fname, lname, password, college, username) values("+id+",'"+email+"', '"+fname+"','"+lname+"','"+pass+"','"+cllg+"','"+user+"')");
					if(std.isSelected()){
						Statement stu=con.createStatement();
						int j=stu.executeUpdate("insert into mentee(menteeid, username) values("+id+", '"+user+"')");
					}
					if(teach.isSelected()){
						String skill=JOptionPane.showInputDialog("Enter your skills");
						int n=Integer.parseInt(JOptionPane.showInputDialog("Enter your experienc in years"));
						Statement stu=con.createStatement();
						int j=stu.executeUpdate("insert into mentor(experience, mentorid, username, skill) values("+n+","+id+", '"+user+"', '"+skill+"')");
					}
				}catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}  
		}  
				
			}
		);
		btnNewButton.setBounds(361, 387, 148, 23);
		contentPane.add(btnNewButton);
		
	}
}
