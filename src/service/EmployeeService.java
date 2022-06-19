package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Employee;
import config.DBConfig;

public class EmployeeService {

	private final DBConfig dbConfig;
	private final Connection connection;

	public EmployeeService() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection=dbConfig.getConnection();
		
		
	}

	public int insertEmployee(Employee employee) {
		int status = 0;
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO emp (emp_name, emp_address, emp_salary) VALUES ( ?, ?, ?)");
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

	public List<Employee> getAllEmployee() {
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp = null;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getString("emp_name"), rs.getString("emp_address"), rs.getInt("emp_salary"));
				emp.setId(rs.getInt("emp_id"));
				empList.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empList;
	}
}
