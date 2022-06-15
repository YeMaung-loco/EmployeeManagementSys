package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.Employee;
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
        this.employeeService = new EmployeeService();
        this.vEmployee=new View_Employee();
    }
	
	private void initController() {
		vEmployee.getbtnSave().addActionListener(this);
	}
	
	private void resetForm() {
		vEmployee.getTxtName().setText("");
		vEmployee.getTxtAddr().setText("");
		vEmployee.getTxtSalary().setText("");
	}
	
	private void save() {
		///Test
		employee=new Employee();
		employee.setName(vEmployee.getTxtName().getText());
		employee.setAddr(vEmployee.getTxtAddr().getText());
		employee.setSalary(Integer.parseInt(vEmployee.getTxtSalary().getText()));
		int status=employeeService.insertEmployee(employee);
		if(status>0) {
			alert("Successfully Saved!");
			resetForm();
		}
		else {
			alert("Failed Save!");
			resetForm();
		}
		employee=null;		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vEmployee.getbtnSave())) {
			save();
		}
		
	}
	
	private void alert(String msg) {
		JOptionPane.showMessageDialog(vEmployee.getFrame(), msg);
	}

}
