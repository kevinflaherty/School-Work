package kf.oop.soda;

import javax.swing.table.AbstractTableModel;
/**
 * InventoryTableModel class for the table in admin screen.
 * @author Kevin Flaherty
 */
public class InventoryTableModel extends AbstractTableModel {
	private String[] columnNames = {"Name", "QIS", "Restock"};
	
	private Object[][] data ={{"Coke", 3, " "},
		{"Orange", 3, " "},
		{"Sprite", 3, " "},
		{"Ginger Ale", 3, " "}};

	public int getRowCount() {
		return data.length;
	}


	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    return true;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = aValue;
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	

}
