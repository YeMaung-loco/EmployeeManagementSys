package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Mapper.Employee_Mapper;
import Model.Employee;
import config.DBConfig;

public class EmployeeService {

	private final DBConfig dbConfig;
	private final Connection connection;

	public EmployeeService() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}

	public int insertEmployee(Employee employee) {
		int status = 0;
		try {
			PreparedStatement ps = this.dbConfig.getConnection().prepareStatement(
					"INSERT INTO pos_2022.employee (emp_name, emp_phone, emp_email, emp_address,username,password, role ,active) VALUES (?, ?, ?, ?, ?, ?,?,?)");
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getPhone());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getAddress());
			ps.setString(5, employee.getUsername());
			ps.setString(6, employee.getPassword());
			ps.setString(7, employee.getRole());
			ps.setBoolean(8, true);
			status = ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	

	public List<Employee> getAllEmployee() {
		List<Employee> empList = new ArrayList<Employee>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from pos_2022.employee");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp = Employee_Mapper.mapper(emp, rs);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}

	public Employee getEmployeeById(int Id) {
		Employee emp = new Employee();
		try {
			PreparedStatement ps = connection
					.prepareStatement("select * from pos_2022.employee where emp_id=" + Id + ";");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp = Employee_Mapper.mapper(emp, rs);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
	}
	
	public Employee lastEmployee() {
		Employee emp = new Employee();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM pos_2022.employee WHERE emp_id=(SELECT MAX(emp_id) FROM pos_2022.employee);");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp = Employee_Mapper.mapper(emp, rs);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
	}

	public Employee searchEmployeeByKey(String key) {
		Employee emp = new Employee();
		/*
		 * try { // PreparedStatement ps =
		 * connection.prepareStatement("select * from emp where emp_id=" + Id + ";");
		 * ResultSet rs = ps.executeQuery(); if (rs.next()) { emp =
		 * Employee_Mapper.mapper(emp, rs); } ps.close(); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */
		return emp;
	}

	public int deleteEmployee(int Id) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("delete from pos_2022.employee where emp_id=" + Id + ";");
			status = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return status;
	}

	public int updateEmployee(int id, Employee employee) {
		int status = 0;
		try {
			PreparedStatement ps = this.dbConfig.getConnection().prepareStatement(
					"UPDATE pos_2022.employee SET emp_name=?, emp_phone=?, emp_email=?, emp_address=?, username=?, password=?,role=?, active=? WHERE emp_id="
							+ id + ";");

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getPhone());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getAddress());
			ps.setString(5, employee.getUsername());
			ps.setString(6, employee.getPassword());
			ps.setString(7, employee.getRole());
			ps.setBoolean(8, employee.getActive());
			// ps.setString(9, id);

			status=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;

	}

}
