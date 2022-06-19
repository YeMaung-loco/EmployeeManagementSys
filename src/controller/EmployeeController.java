package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import Model.Employee;
import Model.tableModel_Employee;
import View.View_Employee;
import service.EmployeeService;

public class EmployeeController implements ActionListener {
	private View_Employee vEmployee;
	private EmployeeService employeeService;
	private Employee employee;

	public EmployeeController() {
		dependencyInjection();
		initController();
		resetForm();
	}

	private void dependencyInjection() {
		try {
			this.employeeService = new EmployeeService();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.vEmployee = new View_Employee();
	}

	private void initController() {
		vEmployee.getbtnSave().addActionListener(this);
		vEmployee.getbtnClear().addActionListener(this);
		vEmployee.getbtnShow().addActionListener(this);
		vEmployee.getbtnClose().addActionListener(this);

	}

	private void resetForm() {
		vEmployee.getTxtName().setText("");
		vEmployee.getTxtAddr().setText("");
		vEmployee.getTxtSalary().setText("");
	}

	private void save() {
		employee = new Employee();
		employee.setName(vEmployee.getTxtName().getText());
		employee.setAddr(vEmployee.getTxtAddr().getText());
		employee.setSalary(Integer.parseInt(vEmployee.getTxtSalary().getText()));
		int status = employeeService.insertEmployee(employee);
		if (status > 0) {
			alert("Successfully Saved!");
			resetForm();
		} else {
			alert("Failed Save!");
			resetForm();
		}
		employee = null;
	}

	private void show() {
		List<Employee> empList = new ArrayList<Employee>();
		empList = employeeService.getAllEmployee();
		AbstractTableModel model = new tableModel_Employee(empList);
		vEmployee.getTable().setModel(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vEmployee.getbtnSave())) {
			save();
		}

		if (e.getSource().equals(vEmployee.getbtnClear())) {
			resetForm();
		}

		if (e.getSource().equals(vEmployee.getbtnShow())) {
			show();
		}
		if(e.getSource().equals(vEmployee.getbtnClose())) {
			System.exit(0);
		}

	}

	private void alert(String msg) {
		JOptionPane.showMessageDialog(vEmployee.getFrame(), msg);
	}

}
