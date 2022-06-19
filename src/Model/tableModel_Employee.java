package Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class tableModel_Employee extends AbstractTableModel {

	List<Employee> empList;
	String headerList[] = new String[] { "Id", "Name", "Address", "Salary" };

	public tableModel_Employee(List<Employee> list) {
		empList = list;
	}

	@Override
	public int getRowCount() {
		return empList.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	
	  public String getColumnName(int col) { return headerList[col]; }
	 
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employee entity = null;
		entity = empList.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return entity.id;
		case 1:
			return entity.name;
		case 2:
			return entity.addr;
		case 3:
			return entity.salary;
		default:
			return "";
		}
	}
}
