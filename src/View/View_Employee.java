package View;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class View_Employee {

	JFrame frame;
	JTable table;
	DefaultTableModel dtm;
	JScrollPane scrollPane;
	JPanel inputPanel;
	JTextField txtName, txtAddr, txtSalary;
	JLabel lblName, lblAddr, lblSalary;
	JButton btnSave, btnClear, btnShow, btnClose;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public View_Employee() {
		initComponents();
		setProperties();
		addComponents();
	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("Address");
		dtm.addColumn("Salary");
		table.setModel(dtm);
	}

	public void initComponents() {
		frame = new JFrame();
		txtName = new JTextField();
		txtAddr = new JTextField();
		txtSalary = new JTextField();
		btnSave = new JButton();
		btnClear = new JButton();
		btnShow= new JButton();
		btnClose= new JButton();

		lblName = new JLabel();
		lblAddr = new JLabel();
		lblSalary = new JLabel();

		inputPanel = new JPanel();
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

		scrollPane.setSize(800, 500);
		scrollPane.setLocation(420, 26);

		Border borderTitle = BorderFactory.createTitledBorder("Employee Form");
		inputPanel.setBorder(borderTitle);
		inputPanel.setBounds(20,30,360,508);
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

		lblAddr.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddr.setBounds(20, 70, 74, 25);
		lblAddr.setText("Address");

		txtAddr.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAddr.setBounds(130, 70, 210, 25);
		txtAddr.setColumns(10);

		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSalary.setBounds(20, 110, 58, 25);
		lblSalary.setText("Salary");

		txtSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalary.setBounds(130, 110, 210, 25);
		txtSalary.setColumns(10);

		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setText("Save");
		btnSave.setBounds(20, 461, 150, 27);

		btnClear.setText("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(190, 461, 150, 27);

		btnShow.setText("Show");
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnShow.setBounds(420, 576, 170, 27);

		btnClose.setText("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setBounds(1050, 576, 170, 27);

	}

	public void addComponents() {
		/*
		 * frame.getContentPane().add(txtName); frame.getContentPane().add(txtAddr);
		 * frame.getContentPane().add(txtSalary); frame.getContentPane().add(lblName);
		 * frame.getContentPane().add(lblAddr); frame.getContentPane().add(lblSalary);
		 * 
		 * frame.getContentPane().add(btnClear); frame.getContentPane().add(btnShow);
		 * frame.getContentPane().add(btnSave); frame.getContentPane().add(btnClose);
		 * 
		 * frame.getContentPane().add(scrollPane);
		 */
		inputPanel.setLayout(null);

		inputPanel.add(txtName);
		inputPanel.add(txtAddr);
		inputPanel.add(txtSalary);
		inputPanel.add(lblName);
		inputPanel.add(lblAddr);
		inputPanel.add(lblSalary);

		inputPanel.add(btnClear);
		inputPanel.add(btnSave);

		frame.getContentPane().add(inputPanel);
		
		JLabel lblName_1 = new JLabel();
		lblName_1.setText("Name");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName_1.setBounds(20, 150, 54, 25);
		inputPanel.add(lblName_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBounds(130, 150, 210, 25);
		inputPanel.add(textField);
		
		JLabel lblAddr_1 = new JLabel();
		lblAddr_1.setText("Address");
		lblAddr_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddr_1.setBounds(20, 190, 74, 25);
		inputPanel.add(lblAddr_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(130, 190, 210, 25);
		inputPanel.add(textField_1);
		
		JLabel lblSalary_1 = new JLabel();
		lblSalary_1.setText("Salary");
		lblSalary_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSalary_1.setBounds(20, 230, 58, 25);
		inputPanel.add(lblSalary_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(130, 230, 210, 25);
		inputPanel.add(textField_2);
		frame.getContentPane().add(scrollPane);
		
		frame.getContentPane().add(btnClose);
		frame.getContentPane().add(btnShow);
		
		JButton btnImport = new JButton();
		btnImport.setText("Import");
		btnImport.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnImport.setBounds(633, 576, 170, 27);
		frame.getContentPane().add(btnImport);
		
		JButton btnExport = new JButton();
		btnExport.setText("Export");
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExport.setBounds(846, 576, 170, 27);
		frame.getContentPane().add(btnExport);

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

	public JTextField getTxtAddr() {
		return txtAddr;
	}

	public JTextField getTxtSalary() {
		return txtSalary;
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

	public JButton getbtnClose() {
		return btnClose;
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
