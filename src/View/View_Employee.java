package View;

import java.awt.Font;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View_Employee {

	JFrame frame;
	JTextField txtName, txtAddr, txtSalary;
	JLabel lblName, lblAddr, lblSalary;
	JButton btnSave;
	
	public View_Employee() {
		initComponents();
		setProperties();
		addComponents();
	}

	public void initComponents() {
		frame = new JFrame();
		txtName = new JTextField();
		txtAddr = new JTextField();
		txtSalary = new JTextField();
		btnSave = new JButton();
		lblName = new JLabel();
		lblAddr = new JLabel();
		lblSalary= new JLabel();
	}

	public void setProperties() {
		frame.setTitle("Employee Management System");
		frame.setBounds(300, 300, 850, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);

		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(50, 29, 106, 25);
		lblName.setText("Name");
		
		txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtName.setBounds(173, 30, 216, 25);
		txtName.setColumns(10);
		
		lblAddr.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddr.setBounds(50, 72, 106, 25);
		lblAddr.setText("Address");

		txtAddr.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAddr.setBounds(173, 73, 216, 25);
		txtAddr.setColumns(10);
		
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSalary.setBounds(50, 119, 106, 25);
		lblSalary.setText("Salary");

		txtSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalary.setBounds(173, 120, 216, 25);
		txtSalary.setColumns(10);

		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setText("Save");
		btnSave.setBounds(174, 214, 85, 25);
	}

	public void addComponents() {
		frame.getContentPane().add(txtName);
		frame.getContentPane().add(txtAddr);
		frame.getContentPane().add(txtSalary);
		frame.getContentPane().add(btnSave);
		frame.getContentPane().add(lblName);
		frame.getContentPane().add(lblAddr);
		frame.getContentPane().add(lblSalary);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTxtName() {
		return txtName;
	}
	public JTextField getTxtAddr() {
		return txtAddr;
	}
	public JTextField getTxtSalary() {
		return txtSalary;
	}

	public JButton getbtnSave() {
		return btnSave;
	}

	public JLabel getlblName() {
		return lblName;
	}

	public JLabel getlblAddr() {
		return lblAddr;
	}
	
	public JLabel getlblSalary() {
		return lblSalary;
	}

}
