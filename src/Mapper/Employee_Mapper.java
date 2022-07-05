package Mapper;

import java.sql.ResultSet;
import Model.Employee;

public class Employee_Mapper {
	
	public static Employee mapper(Employee employee, ResultSet rs){
		 try {
	            employee.setId(rs.getInt("emp_id"));
	            employee.setName(rs.getString("emp_name"));
	            employee.setPhone(rs.getString("emp_phone"));
	            employee.setEmail(rs.getString("emp_email"));
	            employee.setAddress(rs.getString("emp_address"));
	            employee.setUsername(rs.getString("username"));
	            employee.setPassword(rs.getString("password"));
	            employee.setRole(rs.getString("role"));
	            employee.setActive(rs.getBoolean("active"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return employee;
	}

}
