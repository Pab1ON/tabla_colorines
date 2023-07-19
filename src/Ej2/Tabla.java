package Ej2;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JTable {
    public Tabla(DefaultTableModel model) {
        super(model);
        setDefaultRenderer(Object.class, new MiCellRenderer());
    }

    private class MiCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Cambia el color de la fuente en función de tus criterios
            if (value != null && Integer.parseInt(value.toString()) > 50) {
                cellComponent.setForeground(Color.RED);
            } else {
                cellComponent.setForeground(table.getForeground());
            }

            return cellComponent;
        }
    }

    public static void main(String[] args) {
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new Object[]{"Nombre", "Edad"});
        Tabla tabla = new Tabla(model);

        JFrame frame = new JFrame("Tabla Personalizada");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(tabla));
        frame.pack();
        frame.setVisible(true);

        // Agregar datos a la tabla para demostrar el cambio de color de fuente
        model.addRow(new Object[]{"Paco", 35});
        model.addRow(new Object[]{20, 60});
    }
}