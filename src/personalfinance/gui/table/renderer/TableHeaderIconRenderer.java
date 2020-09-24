package personalfinance.gui.table.renderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableHeaderIconRenderer extends DefaultTableCellRenderer {
    private final JLabel label;

    public TableHeaderIconRenderer(ImageIcon icon){
        super();
        label = new JLabel(icon);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int count){
        TableCellRenderer tcr = table.getTableHeader().getDefaultRenderer();
        Component renderer = tcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, count);
        label.setFont(renderer.getFont());
        label.setForeground(renderer.getForeground());
        label.setBorder(((JComponent)renderer).getBorder());
        label.setText(value.toString());

        return label;
    }
}
