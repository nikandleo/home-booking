package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.table.AccountTableData;
import personalfinance.gui.table.ArticleTableData;
import personalfinance.gui.toolbar.FunctionsToolbar;
import personalfinance.settings.Style;

public class ArticlePanel extends RightPanel {
    public ArticlePanel(MainFrame frame) {
        super(frame, new ArticleTableData(), "ARTICLES", Style.ICON_PANEL_ARTICLES, new FunctionsToolbar());
    }
}
