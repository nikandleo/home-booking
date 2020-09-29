package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.gui.panel.*;
import personalfinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MainToolbarHandler extends MenuViewHandler {
    public MainToolbarHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case HandlerCode.TOOLBAR_OVERVIEW: {
                showOverviewPanel();
                break;
            }
            case HandlerCode.TOOLBAR_ACCOUNTS: {
                showAccountPanel();
                break;
            }
            case HandlerCode.TOOLBAR_ARTICLES: {
                showArticlePanle();
                break;
            }
            case HandlerCode.TOOLBAR_CURRENCIES: {
                showCurrencyPanel();
                break;
            }
            case HandlerCode.TOOLBAR_STATISTICS: {
                showStatisticsPanel();
                break;
            }
            case HandlerCode.TOOLBAR_TRANSACTIONS: {
                showTransactionPanel();
                break;
            }
            case HandlerCode.TOOLBAR_TRANSFERS: {
                showTransferPanel();
            }
        }
        super.actionPerformed(e);
    }
}
