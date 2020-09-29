package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.AddEditDialog;
import personalfinance.gui.dialog.ConfirmDialog;
import personalfinance.gui.table.TableData;
import personalfinance.gui.table.model.MainTableModel;
import personalfinance.model.Common;
import personalfinance.saveload.SaveData;
import personalfinance.settings.HandlerCode;

import javax.swing.*;
import java.awt.event.*;

public class FunctionsHandler extends Handler implements MouseListener, KeyListener {
    private final AddEditDialog dialog;

    public FunctionsHandler(MainFrame frame, AddEditDialog dialog) {
        super(frame);
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case HandlerCode.ADD:
                add();
                break;
            case HandlerCode.EDIT:
                edit();
                break;
            case HandlerCode.DELETE:
                delete();
        }
        super.actionPerformed(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DELETE)
            delete();
        frame.refresh();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() instanceof TableData) {
            if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1)
            {
                showAddEditDialog(getSelectedCommon());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() instanceof TableData) {
            if(e.getButton() == MouseEvent.BUTTON3){
                TableData td = frame.getRightPanel().getTableData();
                int row = td.rowAtPoint(e.getPoint());
                td.setRowSelectionInterval(row, row);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void add() {
        showAddEditDialog(null);
    }

    public void edit() {
        showAddEditDialog(getSelectedCommon());
    }

    public void delete() {
        Common c = getSelectedCommon();
        if(c != null)
        {
            int result = ConfirmDialog.show(frame, "CONFIRM_DELETE_TEXT", "CONFIRM_DELETE_TITLE");
            if(result == JOptionPane.YES_OPTION)
            {
                SaveData.getInstance().remove(c);
            }
        }
    }

    private Common getSelectedCommon(){
        TableData td = frame.getRightPanel().getTableData();
        Common c = ((MainTableModel)td.getModel()).getCommonByRow(td.getSelectedRow());
        return c;
    }

    private void showAddEditDialog(Common c)
    {
        dialog.setCommon(c);
        dialog.showDialog();
    }
}
