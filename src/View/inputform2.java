package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class inputform2 extends JPanel {
	//JFrame frame;
	JPanel panel,panel1,panel2,panel3;
	JTextField txt1, txt2,txt3;
	
	
	JFrame containerFrame;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblNrc;
	private JTextField txtUserName;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel lblUserName;
	private JTextField txtNrc;
	private JTextField txtPassword;
	private JTextField txtStaffId;
	private JLabel lblPassword;
	private JLabel lblStaffId;
	int txtSize=20;

	public inputform2(JFrame container){
		containerFrame=container;
		initcomponent();
		setProperties();
		addComponents();
	}
	
	

	public inputform2() {
		initcomponent();
		setProperties();
		addComponents();

	}

	private void initcomponent() {

	//	frame = new JFrame();
		panel = new JPanel();
		
	
		
		 panel1 = new JPanel();
		 panel2 = new JPanel();
		 panel3 = new JPanel();
		 
		 txt1=new JTextField("txt1");
		 txt2=new JTextField("txt2");
		 txt3=new JTextField("txt3");
			
		
	}

	private void setProperties() {
		panel.setBounds(180, 34, 1144, 370);
		//frame.setBounds(180, 34, 1300, 400);
		
		panel.setLayout(new GridLayout(3,1));
		
		panel3.setLayout(new GridLayout(2, 6, 20, 25));
		
		lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel3.add(lblName);
		
		txtName = new JTextField();
		panel3.add(txtName);
		txtName.setColumns(10);
		
		lblNrc = new JLabel("NRC");
		lblNrc.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNrc.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel3.add(lblNrc);
		
		txtNrc = new JTextField();
		panel3.add(txtNrc);
		txtNrc.setColumns(txtSize);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel3.add(lblPhone);
		
		txtPhone = new JTextField();
		panel3.add(txtPhone);
		txtPhone.setColumns(txtSize);
		
		lblUserName = new JLabel("User Name");
		lblUserName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel3.add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel3.add(txtUserName);
		txtUserName.setColumns(txtSize);
		
		lblStaffId = new JLabel("Staff Id");
		lblStaffId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblStaffId.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel3.add(lblStaffId);
		
		txtStaffId = new JTextField();
		panel3.add(txtStaffId);
		txtStaffId.setColumns(txtSize);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel3.add(lblPassword);
		
		txtPassword = new JTextField();
		panel3.add(txtPassword);
		txtPassword.setColumns(txtSize);
		
	}

	private void addComponents() {
		panel1.add(txt1);
		panel2.add(txt2);
		
		panel.add(panel1);
		
		
		panel.add(panel3);
		panel.add(panel2);
		containerFrame.add(panel);
		//add(panel);
	}

	
	public JPanel getPanel_inptForm() {
		return panel;
	}
}
//tested