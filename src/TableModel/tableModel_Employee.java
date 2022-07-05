package TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Employee;
import View.View_Employee;

public class tableModel_Employee extends AbstractTableModel {

	private static final long serialVersionUID = -4026402599426071004L;

	List<Employee> empList;
	View_Employee view_Employee;
	String headerList[] = new String[] { "Id", "Name", "Phone", "Email", "Address", "User Name", "Password", "Role",
			"Active" };

	public tableModel_Employee(List<Employee> list, View_Employee vEmployee) {
		empList = list;
		view_Employee = vEmployee;
	}

	public tableModel_Employee() {

	}

	@Override
	public int getRowCount() {
		return empList.size();
	}

	@Override
	public int getColumnCount() {
		return 9;
	}

	public String getColumnName(int col) {
		return headerList[col];
	}

	public void removeRow(int rowIndex) {
		empList.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void insertRow(Employee emp) {
		empList.add(emp);
		fireTableRowsInserted(empList.size() - 1, empList.size() - 1);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employee entity = null;
		entity = empList.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getName();
		case 2:
			return entity.getPhone();
		case 3:
			return entity.getEmail();
		case 4:
			return entity.getAddress();
		case 5:
			return entity.getUsername();
		case 6:
			return entity.getPassword();
		case 7:
			return entity.getRole();
		case 8:
			return entity.getActive();
		default:
			return "";
		}
	}

	public void setValueAt(Employee e, int rowIndex) {
		Employee emp = empList.get(rowIndex);
		for (int i = 1; headerList.length > i; i++)
			switch (i) {
			case 1:
				emp.setName(e.getName());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 2:
				emp.setPhone(e.getPhone());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 3:
				emp.setEmail(e.getEmail());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 4:
				emp.setAddress(e.getAddress());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 5:
				emp.setUsername(e.getUsername());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 6:
				emp.setPassword(e.getPassword());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 7:
				emp.setRole(e.getRole());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 8:
				emp.setActive(e.getActive());
				fireTableCellUpdated(rowIndex, i);
				break;
			}

	}

}
