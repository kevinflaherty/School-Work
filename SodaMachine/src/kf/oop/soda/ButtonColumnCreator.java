package kf.oop.soda;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 *  ButtonColumn class renders and edits buttons inside a specific column in a table.
 *  @author Kevin Flaherty
 *
 */
public class ButtonColumnCreator extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener, MouseListener {
	private JTable table;
	private JButton rButton;
	private JButton eButton;
	private Action action;
	private Border border;
	private Border foreground;
	private Object editorValue;
	private boolean isButtonColumnEditor;

	/**
	 *  Create the ButtonColumn to be used as a renderer and editor.
	 *
	 *  @param newTable the table containing the button renderer/editor
	 *  @param newAction the Action to be invoked when the button is invoked
	 *  @param newColumn the column to which the button renderer/editor is added
	 */
	public ButtonColumnCreator(JTable newTable, Action newAction, int newColumn) {
		table = newTable;
		action = newAction;
		rButton = new JButton();
		eButton = new JButton();
		eButton.setFocusPainted(false);
		eButton.addActionListener(this);
		border = eButton.getBorder();
		
		setForeground(new LineBorder(Color.BLACK));
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(newColumn).setCellRenderer(this);
		columnModel.getColumn(newColumn).setCellEditor(this);
		table.addMouseListener(this);
	}

	/**
	 *  The foreground color of the button when the cell has focus
	 *
	 *  @param foreground
	 */
	public void setForeground(Border newForeground) {
		foreground = newForeground;
		eButton.setBorder(foreground);
	}


	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (value == null) {
			eButton.setText("");
		}
		else {
			eButton.setText(value.toString());
		}

		editorValue = value;
		return eButton;
	}

	@Override
	public Object getCellEditorValue() {
		return editorValue;
	}

	/**
	 * Implement getTableCellRendererComponent
	 * Renders the buttons
	 */
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			rButton.setForeground(table.getSelectionForeground());
	 		rButton.setBackground(table.getSelectionBackground());
		}
		else {
			rButton.setForeground(table.getForeground());
			rButton.setBackground(UIManager.getColor("Button.background"));
		}

		if (hasFocus) {
			rButton.setBorder(foreground);
		}
		else {
			rButton.setBorder(border);
		}

		if (value == null) {
			rButton.setText("");
		}
		else {
			rButton.setText(value.toString());
		}
		return rButton;
	}

	/**
	 *	Perform action when button is clicked.
	 */
	public void actionPerformed(ActionEvent e) {
		int row = table.convertRowIndexToModel(table.getEditingRow());
		fireEditingStopped();

		ActionEvent event = new ActionEvent(table, ActionEvent.ACTION_PERFORMED, ""+row);
		if(action != null)
			action.actionPerformed(event);
	}

	/**
	 *  Invoke button editor when button is pressed and stop once released.
	 */
    public void mousePressed(MouseEvent e) {
    	if (table.isEditing() && table.getCellEditor() == this)
			isButtonColumnEditor = true;
    }

    public void mouseReleased(MouseEvent e) {
    	if (isButtonColumnEditor && table.isEditing())
    		table.getCellEditor().stopCellEditing();

		isButtonColumnEditor = false;
    }

    public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}