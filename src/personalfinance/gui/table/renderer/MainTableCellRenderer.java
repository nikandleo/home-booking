package personalfinance.gui.table.renderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MainTableCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int count){
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, count);
        setBorder(noFocusBorder);
        setHorizontalAlignment(SwingConstants.CENTER);
        return this;
    }
}
