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
		setType(Type.POPUP);
		setTitle("Skill Connect");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(186, 198, 207));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(10, 133, 99, 14);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setPreferredSize(new Dimension(40, 20));
		username.setMinimumSize(new Dimension(40, 20));
		username.setColumns(10);
		username.setBounds(119, 89, 229, 21);
		contentPane.add(username);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(10, 92, 99, 14);
		contentPane.add(lblUserName);
		
		JButton login = new JButton("Login");
		
		
		login.setBounds(119, 185, 229, 23);
		contentPane.add(login);
		
		JLabel mesg = new JLabel("");
		mesg.setBounds(119, 165, 229, 14);
		contentPane.add(mesg);
		
		password = new JPasswordField();
		password.setPreferredSize(new Dimension(40, 20));
		password.setMinimumSize(new Dimension(40, 20));
		password.setBounds(119, 130, 229, 21);
		contentPane.add(password);
		login.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s=username.getText();
				@SuppressWarnings("deprecation")
				String p=password.getText();
				s.trim();
				p.trim();
				if((s.equals("admin"))&&(p.equals("admin"))) {
					homepage ss=new homepage();
					ss.setVisible(true);
					dispose();
				}
				else mesg.setText("Incorrect Password");
			}
		});
	}
}

