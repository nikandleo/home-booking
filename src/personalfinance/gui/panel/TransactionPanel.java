package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.table.TransactionTableData;
import personalfinance.gui.toolbar.FunctionsToolbar;
import personalfinance.settings.Style;

import javax.swing.*;

public class TransactionPanel extends RightPanel {
    public TransactionPanel(MainFrame frame) {
        super(frame, new TransactionTableData(), "TRANSACTIONS", Style.ICON_PANEL_TRANSACTIONS,
                new JPanel[] {new FunctionsToolbar(), new FilterPanel(frame)});
    }
}
