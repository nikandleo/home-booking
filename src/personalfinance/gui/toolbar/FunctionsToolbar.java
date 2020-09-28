package personalfinance.gui.toolbar;

import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainButton;
import personalfinance.gui.dialog.AddEditDialog;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.handler.Handler;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

public final class FunctionsToolbar extends AbstractToolbar implements EnableEditDelete {
    private MainButton editButton;
    private MainButton deleteButton;

    public FunctionsToolbar(Handler handler){
        super(Style.BORDER_FUNCTIONS_TOOLBAR, handler);
        init();
    }
    @Override
    protected void init() {
        addButton(Text.get("ADD"), Style.ICON_ADD, HandlerCode.ADD, false);
        editButton = addButton(Text.get("EDIT"), Style.ICON_EDIT, HandlerCode.EDIT, false);
        deleteButton = addButton(Text.get("DELETE"), Style.ICON_DELETE, HandlerCode.DELETE, false);
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
        editButton.setEnabled(enable);
        deleteButton.setEnabled(enable);
    }
}
