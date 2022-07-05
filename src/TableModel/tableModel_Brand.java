package TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Brand;
import Model.Employee;

public class tableModel_Brand extends AbstractTableModel{

	List<Brand> brandList;
	String headerList[] = new String[] { "Id", "Name" };

	public tableModel_Brand(List<Brand> list) {
		brandList = list;
	}

	@Override
	public int getRowCount() {
		return brandList.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	
	  public String getColumnName(int col) { return headerList[col]; }
	 
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Brand entity = null;
		entity = brandList.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getName();
		default:
			return "";
		}
	}

}
