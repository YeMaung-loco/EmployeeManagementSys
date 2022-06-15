package service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Employee;
import config.DBConfig;

public class EmployeeService {

	private final DBConfig dbConfig;

	public EmployeeService() {
		this.dbConfig = new DBConfig();
	}

	public int insertEmployee(Employee employee) {
		int status = 0;
		try {
			PreparedStatement ps = this.dbConfig.getConnection()
					.prepareStatement("INSERT INTO emp (emp_name, emp_address, emp_salary) VALUES ( ?, ?, ?)");
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getAddr());
			ps.setInt(3, employee.getSalary());
			status = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return status;
	}
}
