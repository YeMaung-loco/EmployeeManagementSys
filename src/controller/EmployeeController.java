package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import Model.Employee;
import TableModel.tableModel_Employee;
import View.View_Employee;
import service.EmployeeService;

public class EmployeeController implements ActionListener, ListSelectionListener {
	private View_Employee vEmployee;
	private EmployeeService employeeService;
	private Employee employee;
	tableModel_Employee model;
	static int temp_id;
	private JButton btnSave, btnClear, btnShow, btnClose, btnUpdate, btnDelete, btnEdit;
	private JTextField txtName, txtPhone, txtEmail, txtAddress, txtUserName, txtPassword, txtRole;
	private JCheckBox chckActive;
	private JTable table;

	public EmployeeController() {
		dependencyInjection();
		initComponents();
		initController();
		dataToView(employee);
	}

	private void dependencyInjection() {
		try {
			this.employeeService = new EmployeeService();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.vEmployee = new View_Employee();
	}

	private void dataToView(Employee emp) {
		txtName.setText(emp == null ? "" : emp.getName());
		txtPhone.setText(emp == null ? "" : emp.getPhone());
		txtEmail.setText(emp == null ? "" : emp.getEmail());
		txtAddress.setText(emp == null ? "" : emp.getAddress());
		txtUserName.setText(emp == null ? "" : emp.getUsername());
		txtPassword.setText(emp == null ? "" : emp.getPassword());
		txtRole.setText(emp == null ? "" : emp.getRole());
		chckActive.setSelected(emp != null && emp.getActive() ? true : false);
	}

	private void save() {
		setModel();
		int status = employeeService.insertEmployee(employee);
		if (status > 0) {
			employee = employeeService.lastEmployee();
			if (model != null)
				model.insertRow(employee);

			alert("Successfully Saved!");

		} else {
			alert("Failed Save!");

		}
		employee = null;
		dataToView(employee);
	}

	private void show() {
		List<Employee> empList = new ArrayList<Employee>();
		empList = employeeService.getAllEmployee();
		model = new TableModel.tableModel_Employee(empList, vEmployee);
		table.setModel(model);
	}

	private void delete() {
		int modelRowIndex = table.convertRowIndexToModel(table.getSelectedRow());
		if (modelRowIndex != -1) {
			int status = employeeService.deleteEmployee(temp_id);
			if (status > 0) {
				model.removeRow(modelRowIndex);
				alert("Successfully Deleted!");
			} else
				alert("Delete Failed!");
		} else {
			alert("Select a row to Delete!!");

		}
	}

	private void edit() {
		Employee employee = new Employee();
		employee = employeeService.getEmployeeById(temp_id);
		dataToView(employee);
	}

	private void update() {
		setModel();
		int status = employeeService.updateEmployee(temp_id, employee);
		if (status > 0) {
			alert("Successfully Updated!");
			int modelRowIndex = table.convertRowIndexToModel(table.getSelectedRow());
			model.setValueAt(employee, modelRowIndex);
		} else {
			alert("Failed update!");
		}
		employee = null;
		dataToView(employee);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnSave)) {
			save();
		}

		if (e.getSource().equals(btnClear)) {
			employee = null;
			dataToView(employee);
		}

		if (e.getSource().equals(btnShow)) {
			show();
		}
		if (e.getSource().equals(btnClose)) {
			vEmployee.getFrame().dispose();
			Main_Controller main_Controller = new Main_Controller();
		}

		if (e.getSource().equals(btnDelete)) {
			delete();
		}
		if (e.getSource().equals(btnEdit)) {
			btnSave.setVisible(false);
			btnUpdate.setVisible(true);
			edit();
		}
		if (e.getSource().equals(btnUpdate)) {
			btnSave.setVisible(true);
			btnUpdate.setVisible(false);
			update();
		}
	}

	public void valueChanged(ListSelectionEvent e) {
		if (!table.getSelectionModel().isSelectionEmpty()) {
			temp_id = Integer
					.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
		} else {
			System.out.println("Empty");
		}
	}

	private void alert(String msg) {
		JOptionPane.showMessageDialog(vEmployee.getFrame(), msg);
	}

	private void initComponents() {
		btnSave = vEmployee.getbtnSave();
		btnClear = vEmployee.getbtnClear();
		btnShow = vEmployee.getbtnShow();
		btnClose = vEmployee.getbtnClose();
		btnUpdate = vEmployee.getbtnUpdate();
		btnDelete = vEmployee.getbtnDelete();
		btnEdit = vEmployee.getbtnEdit();
		table = vEmployee.getTable();

		txtName = vEmployee.getTxtName();
		txtPhone = vEmployee.getTxtPhone();
		txtEmail = vEmployee.getTxtEmail();
		txtAddress = vEmployee.getTxtAddress();
		txtUserName = vEmployee.getTxtUserName();
		txtPassword = vEmployee.getTxtPassword();
		txtRole = vEmployee.getTxtRole();

		chckActive = vEmployee.getCheckBox();

	}

	private void initController() {
		btnSave.addActionListener(this);
		btnClear.addActionListener(this);
		btnShow.addActionListener(this);
		btnClose.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnEdit.addActionListener(this);
		table.getSelectionModel().addListSelectionListener(this);
	}

	private void setModel() {
		employee = new Employee();
		employee.setName(txtName.getText());
		employee.setPhone(txtPhone.getText());
		employee.setEmail(txtEmail.getText());
		employee.setAddress(txtAddress.getText());
		employee.setUsername(txtUserName.getText());
		employee.setPassword(txtPassword.getText());
		employee.setRole(txtRole.getText());
		employee.setActive(chckActive.isSelected() ? true : false);

	}

}
