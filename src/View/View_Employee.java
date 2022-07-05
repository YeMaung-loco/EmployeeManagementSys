package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class View_Employee {

	JFrame frame;
	JTable table;
	DefaultTableModel dtm;
	JScrollPane scrollPane;
	JPanel inputPanel;
	JTextField txtName, txtPhone, txtEmail, txtSearch;
	JLabel lblName, lblPhone, lblEmail;
	JButton btnSave, btnClear, btnShow, btnClose, btnUpdate, btnDelete, btnEdit, btnSearch;
	JCheckBox chckActiveBox;
	private JTextField txtAddress;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtRole;

	public View_Employee() {
		initComponents();
		setProperties();
		addComponents();
	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("Phone");
		dtm.addColumn("Email");
		dtm.addColumn("Address");
		dtm.addColumn("UserName");
		dtm.addColumn("Password");
		dtm.addColumn("Role");
		dtm.addColumn("Active");
		table.setModel(dtm);
		
		setColumnWidth(0, 10);
		setColumnWidth(1, 40);
		
		
	}
	
	public void setColumnWidth(int index, int width) {
		DefaultTableColumnModel tableColumnModel=(DefaultTableColumnModel) table.getColumnModel();
		TableColumn tc=tableColumnModel.getColumn(index);
		tc.setPreferredWidth(width);
		
	}


	public void initComponents() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		txtName = new JTextField();
		txtPhone = new JTextField();
		txtEmail = new JTextField();
		txtSearch = new JTextField();

		btnSave = new JButton();
		btnClear = new JButton();
		btnShow = new JButton();
		btnClose = new JButton();
		btnUpdate = new JButton();
		btnDelete = new JButton();
		btnEdit = new JButton();
		btnSearch = new JButton();

		lblName = new JLabel();
		lblPhone = new JLabel();
		lblEmail = new JLabel();

		chckActiveBox = new JCheckBox();
		chckActiveBox.setBackground(new Color(255, 255, 51));

		inputPanel = new JPanel();
		inputPanel.setBackground(new Color(255, 255, 51));
		inputPanel.setForeground(Color.BLACK);

		table = new JTable();
		scrollPane = new JScrollPane(table);
		dtm = new DefaultTableModel();

	}

	public void setProperties() {
		frame.setTitle("Employee Management System");
		frame.setBounds(20, 10, 1270, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);

		scrollPane.setSize(800, 452);
		scrollPane.setLocation(420, 74);
		scrollPane.setViewportView(table);

		//Border borderTitle = BorderFactory.createTitledBorder("Employee Form");
		//inputPanel.setBorder(borderTitle);
		inputPanel.setBounds(20, 30, 360, 603);
		inputPanel.setLayout(null);

		Color color = UIManager.getColor("Table.gridColor");
		MatteBorder border = new MatteBorder(1, 1, 0, 0, color);
		table.setBorder(border);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(20, 30, 54, 25);
		lblName.setText("Name");

		txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtName.setBounds(130, 30, 210, 25);
		txtName.setColumns(10);

		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhone.setBounds(20, 70, 74, 25);
		lblPhone.setText("Phone");

		txtPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPhone.setBounds(130, 70, 210, 25);
		txtPhone.setColumns(10);

		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(20, 110, 58, 25);
		lblEmail.setText("Email");

		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEmail.setBounds(130, 110, 210, 25);
		txtEmail.setColumns(10);

		txtSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSearch.setColumns(10);
		txtSearch.setBounds(914, 22, 210, 25);

		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setText("Save");
		btnSave.setBounds(20, 545, 150, 27);

		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setText("Update");
		btnUpdate.setBounds(20, 545, 150, 27);
		// btnUpdate.setVisible(false);

		btnClear.setText("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(190, 545, 150, 27);

		btnShow.setText("Show");
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnShow.setBounds(420, 576, 170, 27);

		btnClose.setText("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setBounds(1050, 576, 170, 27);

		btnEdit.setText("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEdit.setBounds(633, 576, 170, 27);

		btnDelete.setText("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(846, 576, 170, 27);

		btnSearch.setText("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(1123, 21, 97, 27);

		chckActiveBox.setText("Active");
		chckActiveBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckActiveBox.setBounds(130, 303, 93, 21);

	}

	public void addComponents() {

		inputPanel.add(txtName);
		inputPanel.add(txtPhone);
		inputPanel.add(txtEmail);
		inputPanel.add(lblName);
		inputPanel.add(lblPhone);
		inputPanel.add(lblEmail);
		inputPanel.add(btnClear);
		inputPanel.add(btnSave);
		inputPanel.add(btnUpdate);

		frame.getContentPane().add(inputPanel);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(btnClose);
		frame.getContentPane().add(btnShow);

		frame.getContentPane().add(btnEdit);
		frame.getContentPane().add(btnDelete);

		JLabel lblAddr = new JLabel();
		lblAddr.setText("Address");
		lblAddr.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddr.setBounds(20, 150, 74, 25);
		inputPanel.add(lblAddr);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAddress.setColumns(10);
		txtAddress.setBounds(130, 150, 210, 25);
		inputPanel.add(txtAddress);

		JLabel lblUserName = new JLabel();
		lblUserName.setText("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserName.setBounds(20, 190, 120, 25);
		inputPanel.add(lblUserName);

		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUserName.setColumns(10);
		txtUserName.setBounds(130, 190, 210, 25);
		inputPanel.add(txtUserName);

		JLabel lblPassword = new JLabel();
		lblPassword.setText("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(20, 230, 89, 25);
		inputPanel.add(lblPassword);

		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPassword.setColumns(10);
		txtPassword.setBounds(130, 230, 210, 25);
		inputPanel.add(txtPassword);

		JLabel lblRole = new JLabel();
		lblRole.setText("Role");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRole.setBounds(20, 265, 89, 25);
		inputPanel.add(lblRole);

		txtRole = new JTextField();
		txtRole.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRole.setColumns(10);
		txtRole.setBounds(130, 265, 210, 25);
		inputPanel.add(txtRole);

		inputPanel.add(chckActiveBox);

		frame.getContentPane().add(txtSearch);

		frame.getContentPane().add(btnSearch);

		setTableDesign();

	}

	public JFrame getFrame() {
		return frame;
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JTextField getTxtPhone() {
		return txtPhone;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtAddress() {
		return txtAddress;
	}

	public JTextField getTxtUserName() {
		return txtUserName;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public JTextField getTxtRole() {
		return txtRole;
	}

	public JCheckBox getCheckBox() {
		return chckActiveBox;
	}

	public JButton getbtnSave() {
		return btnSave;
	}

	public JButton getbtnClear() {
		return btnClear;
	}

	public JButton getbtnShow() {
		return btnShow;
	}

	public JButton getbtnUpdate() {
		return btnUpdate;
	}

	public JButton getbtnEdit() {
		return btnEdit;
	}

	public JButton getbtnDelete() {
		return btnDelete;
	}

	public JButton getbtnClose() {
		return btnClose;
	}

}
