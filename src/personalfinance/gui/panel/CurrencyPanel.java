package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.table.ArticleTableData;
import personalfinance.gui.table.CurrencyTableData;
import personalfinance.gui.toolbar.FunctionsToolbar;
import personalfinance.settings.Style;

public class CurrencyPanel extends RightPanel {
    public CurrencyPanel(MainFrame frame) {
        super(frame, new CurrencyTableData(), "CURRENCIES", Style.ICON_PANEL_CURRENCIES, new FunctionsToolbar());
    }
}
