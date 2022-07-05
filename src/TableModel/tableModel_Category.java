package TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Brand;
import Model.Category;
import Model.Employee;

public class tableModel_Category extends AbstractTableModel{

	List<Category> categoryList;
	String headerList[] = new String[] { "Id", "Name" };

	public tableModel_Category(List<Category> list) {
		categoryList = list;
	}

	@Override
	public int getRowCount() {
		return categoryList.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	
	  public String getColumnName(int col) { return headerList[col]; }
	 
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Category entity = null;
		entity = categoryList.get(rowIndex);
		
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
