package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.AccountAddEditDialog;
import personalfinance.gui.dialog.ArticleAddEditDialog;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.ArticleTableData;
import personalfinance.gui.toolbar.FunctionsToolbar;
import personalfinance.settings.Style;

public class ArticlePanel extends RightPanel {
    public ArticlePanel(MainFrame frame) {
        super(frame, new ArticleTableData(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))),
                "ARTICLES", Style.ICON_PANEL_ARTICLES, new FunctionsToolbar(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))));
    }
}
