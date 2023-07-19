package Ej2;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MiCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        	DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        	value = modelo.getValueAt(row, 4);
        	System.out.println(value);
        	if( value != null && Integer.parseInt(value.toString()) < 5) {
	            cellComponent.setForeground(Color.RED);
	        } else {
	            cellComponent.setForeground(Color.GREEN);
	        }

        return cellComponent;
    }
}