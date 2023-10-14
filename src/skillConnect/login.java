package skillConnect;
import java.awt.EventQueue;
import skillConnect.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
// import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import skillConnect.homepage;
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DebugGraphics;
import java.awt.ComponentOrientation;
import skillConnect.*;
class NewPage extends JFrame{
	  NewPage()  
	    {  
	        setDefaultCloseOperation(javax.swing.  
	        WindowConstants.DISPOSE_ON_CLOSE);  
	        setTitle("Welcome");  
	        setSize(400, 200);  
	    }  
}

public class login extends JFrame {

	private JPanel contentPane;
	public JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/SkillConnect?characterEncoding=utf8&autoReconnect=true&useSSL=false";
		String user="root";
		String pass="PW";
		Connection con;
		con = DriverManager.getConnection(url, user, pass);

		setType(Type.POPUP);
		setTitle("Skill Connect");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 133, 99, 14);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setPreferredSize(new Dimension(40, 20));
		username.setMinimumSize(new Dimension(40, 20));
		username.setColumns(10);
		username.setBounds(119, 89, 229, 21);
		contentPane.add(username);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblUserName.setForeground(new Color(255, 255, 255));
		lblUserName.setBounds(10, 92, 99, 14);
		contentPane.add(lblUserName);
		
		JButton login = new JButton("Login");
		
		
		login.setBounds(119, 185, 99, 23);
		contentPane.add(login);
		
		JLabel mesg = new JLabel("");
		mesg.setBounds(119, 165, 229, 14);
		contentPane.add(mesg);
		
		password = new JPasswordField();
		password.setPreferredSize(new Dimension(40, 20));
		password.setMinimumSize(new Dimension(40, 20));
		password.setBounds(119, 130, 229, 21);
		contentPane.add(password);
		
		JButton signup = new JButton("Sign-Up");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp ob=new signUp();
				ob.setVisible(true);
			}
		});
		signup.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);
		signup.setBounds(249, 185, 99, 23);
		contentPane.add(signup);
		
		JLabel lblNewLabel_1 = new JLabel("Skill Connect");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel_1.setBounds(119, 25, 229, 38);
		contentPane.add(lblNewLabel_1);
		login.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s=username.getText();
				@SuppressWarnings("deprecation")
				String p=password.getText();
				s.trim();
				p.trim();
				
										try {
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select * from user where username='" + s + "' and password='" + p + "'");  
					if(rs.next()){
						homepage ob=new homepage(s);
						ob.setVisible(true);
						dispose();
					}
					else mesg.setText("Incorrect Password");
				
					} catch (SQLException e1) {
						e1.printStackTrace();
					}  
			}
		});
		}
		catch(Exception g)
		{ 
			System.out.println(g);
		}
	}
}

