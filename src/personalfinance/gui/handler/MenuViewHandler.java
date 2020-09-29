package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.gui.panel.*;
import personalfinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MenuViewHandler extends Handler {
    public MenuViewHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case HandlerCode.MENU_VIEW_OVERVIEW: {
                showOverviewPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_ACCOUNTS: {
                showAccountPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_ARTICLES: {
                showArticlePanle();
                break;
            }
            case HandlerCode.MENU_VIEW_CURRENCIES: {
                showCurrencyPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_STATISTICS: {
                showStatisticsPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_TRANSACTIONS: {
                showTransactionPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_TRANSFERS: {
                showTransferPanel();
            }
        }
        super.actionPerformed(e);
    }

    protected void  showOverviewPanel(){
        frame.setRightPanel(new OverviewPanel(frame));
    }

    protected void  showAccountPanel(){
        frame.setRightPanel(new AccountPanel(frame));
    }

    protected void  showArticlePanle(){
        frame.setRightPanel(new ArticlePanel(frame));
    }

    protected void  showTransactionPanel(){
        frame.setRightPanel(new TransactionPanel(frame));
    }

    protected void  showTransferPanel(){
        frame.setRightPanel(new TransferPanel(frame));
    }

    protected void  showCurrencyPanel(){
        frame.setRightPanel(new CurrencyPanel(frame));
    }

    protected void  showStatisticsPanel(){
        frame.setRightPanel(new StatisticsPanel(frame));
    }
}
