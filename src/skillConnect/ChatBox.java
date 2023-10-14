package skillConnect;
import skillConnect.*;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatBox extends JFrame {

	private JPanel contentPane;
	JTabbedPane message; 
	/**
	 * Launch the application.
	 */
	Connection con;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatBox frame = new ChatBox(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void loadUsers(int userid) {
		try {
			
//			ResultSet rs=st.executeQuery("select * from messageinfo where user1="+userid+" or user2="+userid);
//			System.out.println(rs);
			
			for(int i=1;i<=30;i++) {
				if(i==userid) continue;
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from messageinfo where (user1="+userid+" or user2 = "+userid+") and (user1="+i+" or user2="+i+")");
				if(rs.next()) {
				

				// Statement s=con.createStatement();
				ResultSet user;
//				int receiver;
				user=st.executeQuery("select * from user where userid="+i);
				user.next();
//				ResultSet msg=st.executeQuery("select * from message where senderid="+user1+" or senderid = "+user2+" and receiverid="+user1+" or receiverid=user2");
				JPanel panel = new JPanel();
				JTextField textField;textField = new JTextField();
				textField.setBounds(0, 234, 270, 20);
				panel.add(textField);
				textField.setColumns(10);
				JTextArea msg=new JTextArea();
				msg.setEditable(false);
				msg.setBounds(0, 0, 353, 251);
				
				JButton btnNewButton = new JButton("Send");
				int receiver=i;
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Statement ne=con.createStatement();
							String mssg=textField.getText();
							textField.setText("");
							int b=ne.executeUpdate("insert into message(senderid, receiverid, messagetext) values("+userid+", "+receiver+", '"+(String)(mssg)+"')");
							loadMessage(userid, receiver, msg);
							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
				btnNewButton.setBounds(272, 233, 80, 20);
				panel.add(btnNewButton);
				message.addTab(user.getString("fname"), null, panel, null);
				panel.setLayout(null);
				loadMessage(userid, i, msg);
				panel.add(msg);
				}
				
			}
//			loadUsers();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}
	private void loadMessage(int user1, int user2, JTextArea ms) {
		try {
			ms.setText("");
			// int i=1;
			Statement s=con.createStatement();
			ResultSet text=s.executeQuery("select * from message where (senderid="+user1+" or receiverid="+user1+") and (senderid="+user2+" or receiverid="+user2+")");
			while(text.next()) {
				Statement x=con.createStatement();
				ResultSet user=x.executeQuery("select * from user where userid='"+text.getString("senderid")+"'");
				user.next();
				ms.append(user.getString("username")+": "+text.getString("messagetext")+"\n");
			}
//			while(text.next()) {
//				ms.append(text.getString("messagetext"));
//			}
		}catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public ChatBox(int userid) {
		setTitle("Messages");
		setResizable(false);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/SkillConnect?characterEncoding=utf8&autoReconnect=true&useSSL=false";
			String user="root";
			String pass="PW";
			con=DriverManager.getConnection(url, user, pass);  
			// Statement stmt=con.createStatement();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			setTitle("Messages");
			setAutoRequestFocus(true);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			message= new JTabbedPane(JTabbedPane.LEFT);
			message.setBounds(0, 0, 434, 261);
			
			contentPane.add(message);
			
			
			
			
			
//			JPanel panel = new JPanel();
//			message.addTab("New tab", null, panel, null);
//			panel.setLayout(null);
//			
//			JTextPane textPane = new JTextPane();
//			textPane.setEditable(false);
//			textPane.setBounds(0, 0, 373, 256);
			loadUsers(userid);
//			panel.add(textPane);
		}catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}