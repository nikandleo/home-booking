package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.AccountAddEditDialog;
import personalfinance.gui.dialog.ArticleAddEditDialog;
import personalfinance.gui.dialog.TransferAddEditDialog;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.TransferTableData;
import personalfinance.gui.toolbar.FunctionsToolbar;
import personalfinance.settings.Style;

import javax.swing.*;

public class TransferPanel extends RightPanel {
    public TransferPanel(MainFrame frame) {
        super(frame, new TransferTableData(new FunctionsHandler(frame, new TransferAddEditDialog(frame))),
                "TRANSFERS", Style.ICON_PANEL_TRANSFERS,
                new JPanel[] {new FunctionsToolbar(new FunctionsHandler(frame, new TransferAddEditDialog(frame))), new FilterPanel(frame)});
    }
}
