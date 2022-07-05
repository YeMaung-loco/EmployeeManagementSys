package View;

import java.awt.Color;
import java.awt.Font;

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
import javax.swing.table.DefaultTableModel;

public class View_Brand {
	JFrame frame;
	JTable table;
	DefaultTableModel dtm;
	JScrollPane scrollPane;
	JPanel inputPanel;
	JButton btnSave, btnClear, btnShow, btnClose, btnUpdate, btnDelete, btnEdit, btnSearch;
	JTextField txtName, txtSearch;
	JLabel lblName;

	public View_Brand() {
		initComponents();
		setProperties();
		addComponents();
	}

	private void initComponents() {
		frame = new JFrame();
		txtName = new JTextField();
		txtSearch = new JTextField();
		/*
		 * txtPhone = new JTextField(); txtEmail = new JTextField(); txtSearch = new
		 * JTextField();
		 */

		btnSave = new JButton();
		btnClear = new JButton();
		btnShow = new JButton();
		btnClose = new JButton();
		btnUpdate = new JButton();
		btnDelete = new JButton();
		btnEdit = new JButton();
		btnSearch = new JButton();

		lblName = new JLabel();
		/*
		 * lblPhone = new JLabel(); lblEmail = new JLabel();
		 */

		inputPanel = new JPanel();
		inputPanel.setForeground(Color.BLACK);

		table = new JTable();
		scrollPane = new JScrollPane(table);
		dtm = new DefaultTableModel();

	}

	private void addComponents() {
		inputPanel.add(txtName);
		inputPanel.add(lblName);
		inputPanel.add(btnClear);
		inputPanel.add(btnSave);
		inputPanel.add(btnUpdate);

		frame.getContentPane().add(inputPanel);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(btnClose);
		frame.getContentPane().add(btnShow);
		frame.getContentPane().add(btnEdit);
		frame.getContentPane().add(btnDelete);

		frame.getContentPane().add(txtSearch);
		frame.getContentPane().add(btnSearch);

		setTableDesign();

	}

	private void setProperties() {
		frame.setTitle("Employee Management System");
		frame.setBounds(20, 10, 1270, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);

		scrollPane.setSize(800, 452);
		scrollPane.setLocation(420, 74);
		scrollPane.setViewportView(table);

		Border borderTitle = BorderFactory.createTitledBorder("Brand Form");
		inputPanel.setBorder(borderTitle);
		inputPanel.setBounds(20, 30, 360, 573);
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

		txtSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSearch.setColumns(10);
		txtSearch.setBounds(914, 22, 210, 25);

		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setText("Save");
		btnSave.setBounds(20, 461, 150, 27);

		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setText("Update");
		btnUpdate.setBounds(20, 461, 150, 27);
		btnUpdate.setVisible(false);

		btnClear.setText("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(190, 461, 150, 27);

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

	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		table.setModel(dtm);
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
