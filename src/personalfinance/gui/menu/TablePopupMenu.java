package personalfinance.gui.menu;

import personalfinance.gui.Refresh;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;

public class TablePopupMenu extends JPopupMenu implements Refresh {
    private final FunctionsHandler handler;

    public TablePopupMenu(FunctionsHandler handler){
        super();
        this.handler = handler;
        init();
    }

    private void init() {
        JMenuItem editItem = new JMenuItem(Text.get("EDIT"));
        JMenuItem deleteItem = new JMenuItem(Text.get("DELETE"));

        editItem.setActionCommand(HandlerCode.EDIT);
        deleteItem.setActionCommand(HandlerCode.DELETE);

        editItem.addActionListener(handler);
        deleteItem.addActionListener(handler);

        editItem.setIcon(Style.ICON_MENU_POPUP_EDIT);
        deleteItem.setIcon(Style.ICON_MENU_POPUP_DELETE);

        add(editItem);
        add(deleteItem);
    }

    @Override
    public void refresh() {

    }
}
